 package unlp.ttpsInfoPoolCBR.dao.recorrido;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
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
    public List<RecorridoVo> listarDisponibles(EntityManager em,UsuarioVo usuario) throws Exception {
        List<Recorrido> listaRecorrido = new ArrayList<Recorrido>();
        List<RecorridoVo> listaRecorridoVo = new ArrayList<RecorridoVo>();
        try{
            TypedQuery<Recorrido> jpaql = em.createQuery(
            		"SELECT r FROM Recorrido r WHERE r.propietario!=:admin"
            		,persistentClass);
            jpaql.setParameter("admin", usuario);
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
    
}
