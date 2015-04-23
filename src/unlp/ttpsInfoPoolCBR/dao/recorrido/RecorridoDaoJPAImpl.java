 package unlp.ttpsInfoPoolCBR.dao.recorrido;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.util.MapperUtils;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

/**
 * Created by Axel on 23/11/2014.
 */
public class RecorridoDaoJPAImpl extends GenericDaoJPAImpl<Recorrido,RecorridoVo> implements IRecorridoDao {
    public RecorridoDaoJPAImpl() {
        super(Recorrido.class, RecorridoVo.class);
    }
    
    @Override
    public List<RecorridoVo> listarDisponibles(EntityManager em,UsuarioVo usuarioVo) throws Exception {
        List<Recorrido> listaRecorrido = new ArrayList<Recorrido>();
        List<RecorridoVo> listaRecorridoVo = new ArrayList<RecorridoVo>();
        try{ 
        	Usuario usuario = MapperUtils.map(usuarioVo, Usuario.class);
            TypedQuery<Recorrido> jpaql = em.createQuery(
            		"SELECT r FROM Recorrido r WHERE r.propietario!=:usuario AND r.borrado = false AND :usuario NOT MEMBER OF r.pasajeros"
            		,persistentClass);
            jpaql.setParameter("usuario", usuario);
//            		"select r from " + persistentClass.getSimpleName() + " r "
//            		+ "WHERE r.lugares > ("
//            			+ "SELECT count(*) FROM Recorrido rec "
//            			+ "INNER JOIN rec.pasajeros " //Usuario_Recorrido_Viajo urv ON (rec.id = urv.recorrido_id)
//            			+ "GROUP BY rec.id)",persistentClass);
            listaRecorrido = jpaql.getResultList();
            listaRecorridoVo = MapperUtils.map(listaRecorrido,RecorridoVo.class);
        }catch(Exception ex){
            throw ex;
        }
        return listaRecorridoVo;
    }

	@Override
	public RecorridoVo traerPasajeros(EntityManager em, RecorridoVo recorridoVo)
			throws Exception {
		Recorrido recorrido = null;
		try{
			recorrido = em.find(Recorrido.class, recorridoVo.getId());
			
			recorrido.getPasajeros();
			recorrido.getPasajerosHistorial();

			recorridoVo = MapperUtils.map(recorrido, RecorridoVo.class);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return recorridoVo;
	}

	@Override
	@Transactional
	public RecorridoVo eliminarPasajero(EntityManager em,
			RecorridoVo recorridoVo, UsuarioVo usuarioVo) throws Exception {
		Recorrido recorrido = null;
		Usuario usuario = null;
		try{
			recorrido = em.find(Recorrido.class, recorridoVo.getId());
			usuario = em.find(Usuario.class,usuarioVo.getId());
//			usuario.getRecorridosViajo().remove(recorrido);
			
			recorrido.eliminarPasajero(usuario);
			recorrido=em.merge(recorrido);
			recorridoVo = MapperUtils.map(recorrido, RecorridoVo.class);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return recorridoVo;
	}
	
	@Override
    @Transactional
    public void borrar(EntityManager em,Integer idRecorridoVO) throws Exception {
        try{
            Recorrido recorrido = em.find(persistentClass,idRecorridoVO);
            RecorridoVo recorridoVo;
            UsuarioVo usuarioVo;
            if(!recorrido.equals(null)){
            	recorridoVo = MapperUtils.map(recorrido, RecorridoVo.class);
            	for (UsuarioVo pasajero : recorridoVo.getPasajeros()) {
            		usuarioVo = MapperUtils.map(pasajero, UsuarioVo.class);
            		this.eliminarPasajero(em, recorridoVo, usuarioVo);
            	}
            	recorrido.setBorrado(Boolean.TRUE);
            	em.merge(recorrido);
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
