package unlp.ttpsInfoPoolCBR.dao.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.util.MapperUtils;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.RolVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

/**
 * Created by Axel on 22/11/2014.
 */
public class UsuarioDaoJPAImpl extends GenericDaoJPAImpl<Usuario,UsuarioVo> implements IUsuarioDao{
	
    public UsuarioDaoJPAImpl() {
        super(Usuario.class, UsuarioVo.class);
    }
    
    @Autowired
    IRecorridoDao recorridoDao;
    
    @Override
    public UsuarioVo buscarPorEmail(EntityManager em,String email) throws Exception{
    	Usuario usuario = null;
    	UsuarioVo usuarioVo = null;
    	try{
	    	TypedQuery<Usuario> jpaql = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
	    	jpaql.setParameter("email", email);
	    	List<Usuario> listaUsuario = jpaql.getResultList();
	    	if(!listaUsuario.isEmpty()){
	    		usuario = listaUsuario.get(0);
	    		usuarioVo = MapperUtils.map(usuario, UsuarioVo.class);
	    	}
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    	return usuarioVo;
    }

	@Override
	public UsuarioVo traerMensajes(EntityManager em,UsuarioVo usuarioVo) throws Exception {
		Usuario usuario = null;
		try{
			usuario = em.find(Usuario.class, usuarioVo.getId());
			
			usuario.getBandejaEntrada().size();
			usuario.getBandejaSalida().size();

			usuarioVo = MapperUtils.map(usuario, UsuarioVo.class);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuarioVo;
	}

	@Override
	public UsuarioVo traerDenuncias(EntityManager em,UsuarioVo usuarioVo) throws Exception {
		Usuario usuario = null;
		try{
			usuario = em.find(Usuario.class, usuarioVo.getId());

			usuario.getDenunciasHechas().size();
			usuario.getMisDenuncias().size();

			usuarioVo = MapperUtils.map(usuario, UsuarioVo.class);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuarioVo;
	}

	@Override
	public UsuarioVo traerCalificaciones(EntityManager em,UsuarioVo usuarioVo) throws Exception {
		Usuario usuario = null;
		try{
			usuario = em.find(Usuario.class, usuarioVo.getId());

			usuario.getCalificacionesHechas().size();
			usuario.getMisCalificaciones().size();

			usuarioVo = MapperUtils.map(usuario, UsuarioVo.class);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuarioVo;
	}

	@Override
	public UsuarioVo traerRecorridos(EntityManager em,UsuarioVo usuarioVo) throws Exception {
		Usuario usuario = null;
		try{
			usuario = em.find(Usuario.class, usuarioVo.getId());
			
			usuario.getRecorridosMios().size();
			usuario.getRecorridosViajo().size();
			usuario.getHistorial().size();

			usuarioVo = MapperUtils.map(usuario, UsuarioVo.class);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuarioVo;
	}

	@Override
	public UsuarioVo login(EntityManager em,String email, String password) throws Exception {
		UsuarioVo usuarioVo = this.buscarPorEmail(em,email);
		if(usuarioVo != null){
			if(!usuarioVo.getClave().equals(password)){
				usuarioVo = null;
			}
		}
    	return usuarioVo;
	}
	
	@Override
	public UsuarioVo traerMisRecorridos(EntityManager em,UsuarioVo usuarioVo) throws Exception{
		Usuario usuario = null;
		try{
			TypedQuery<Usuario> jpaql = em.createQuery("select u from Usuario u join fetch u.recorridosMios where u.id = :id", Usuario.class);
			jpaql.setParameter("id", usuarioVo.getId());
			List<Usuario> usuarios = jpaql.getResultList();
			if(!usuarios.isEmpty()){
				usuario = usuarios.get(0);
				usuarioVo = MapperUtils.map(usuario, UsuarioVo.class);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return usuarioVo;
	}
	
	@Override
	public List<UsuarioVo> listarDeRol(EntityManager em,RolVo rol) throws Exception {
		 List<Usuario> listaUsuario = new ArrayList<Usuario>();
		 List<UsuarioVo> listaUsuarioVo = new ArrayList<UsuarioVo>();
	        try{
	            TypedQuery<Usuario> jpaql = em.createQuery("select u from " + persistentClass.getSimpleName() + " u where rol_id = :idRol",persistentClass);
	            jpaql.setParameter("idRol", rol.getId());
	            listaUsuario = jpaql.getResultList();
	            listaUsuarioVo = MapperUtils.map(listaUsuario,UsuarioVo.class);
	        }catch(Exception ex){
	            throw ex;
	        }
	        return listaUsuarioVo;
	}
	
	@Override
	public UsuarioVo traerBandejaEntrada(EntityManager em,UsuarioVo usuarioVo) throws Exception{
		Usuario usuario = null;
		try{
			TypedQuery<Usuario> jpaql = em.createQuery("select u from Usuario u join fetch u.bandejaEntrada where u.id = :id", Usuario.class);
			jpaql.setParameter("id", usuarioVo.getId());
			List<Usuario> usuarios = jpaql.getResultList();
			if(!usuarios.isEmpty()){
				usuario = usuarios.get(0);
				usuarioVo = MapperUtils.map(usuario, UsuarioVo.class);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return usuarioVo;
	}

	@Override
	public List<UsuarioVo> listarExceptoUno(EntityManager em, Integer idUsuario)
			throws Exception {
		 List<Usuario> listaUsuario = new ArrayList<Usuario>();
		 List<UsuarioVo> listaUsuarioVo = new ArrayList<UsuarioVo>();
	        try{
	            TypedQuery<Usuario> jpaql = em.createQuery("select u from " + persistentClass.getSimpleName() + " u where id != :idUsuario",persistentClass);
	            jpaql.setParameter("idUsuario", idUsuario);
	            listaUsuario = jpaql.getResultList();
	            listaUsuarioVo = MapperUtils.map(listaUsuario,UsuarioVo.class);
	        }catch(Exception ex){
	            throw ex;
	        }
	        return listaUsuarioVo;
	}
	
	@Override
    @Transactional
    public void borrar(EntityManager em,Integer idUsuarioVO) throws Exception {
        try{
            Usuario usuario = em.find(persistentClass,idUsuarioVO);
            RecorridoVo recorridoVo;
            UsuarioVo usuarioVo;
            if(!usuario.equals(null)){
            	for (Recorrido recorrido : usuario.getRecorridosMios()) {
					this.getRecorridoDao().borrar(em, recorrido.getId());
				}
            	for (Recorrido recorrido : usuario.getRecorridosViajo()) {
            		recorridoVo = MapperUtils.map(recorrido, RecorridoVo.class);
            		usuarioVo = MapperUtils.map(usuario, UsuarioVo.class);
					this.getRecorridoDao().eliminarPasajero(em, recorridoVo, usuarioVo);
				}
            	usuario.setBorrado(Boolean.TRUE);
            	em.merge(usuario);
            }
        }catch(Exception ex){
            throw ex;
        }
    }

	public IRecorridoDao getRecorridoDao() {
		return recorridoDao;
	}

	public void setRecorridoDao(IRecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
	}

}
