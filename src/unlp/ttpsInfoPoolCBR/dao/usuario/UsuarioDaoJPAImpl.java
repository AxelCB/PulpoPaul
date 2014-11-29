package unlp.ttpsInfoPoolCBR.dao.usuario;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Axel on 22/11/2014.
 */
public class UsuarioDaoJPAImpl extends GenericDaoJPAImpl<Usuario,Usuario> implements IUsuarioDao{
    public UsuarioDaoJPAImpl() {
        super(Usuario.class, Usuario.class);
    }
    
    @Override
    public Usuario buscarPorEmail(String email) throws Exception{
    	EntityManager em = null;
    	Usuario usuario = null;
    	try{
	    	em = EntityManagerFactoryHolder.getEntityManager();
	    	TypedQuery jpaql = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
	    	jpaql.setParameter("email", email);
	    	List<Usuario> listaUsuario = jpaql.getResultList();
	    	if(!listaUsuario.isEmpty()){
	    		usuario = listaUsuario.get(0);
	    	}
	    	em.close();
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    	return usuario;
    }

	@Override
	public Usuario traerMensajes(Usuario usuario) throws Exception {
		EntityManager em = null;
		try{
			em = EntityManagerFactoryHolder.getEntityManager();
			usuario = em.find(Usuario.class, usuario.getId());
			
			usuario.getBandejaEntrada().size();
			usuario.getBandejaSalida().size();

			em.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario traerDenuncias(Usuario usuario) throws Exception {
		EntityManager em = null;
		try{
			em = EntityManagerFactoryHolder.getEntityManager();
			usuario = em.find(Usuario.class, usuario.getId());

			usuario.getDenunciasHechas().size();
			usuario.getMisDenuncias().size();

			em.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario traerCalificaciones(Usuario usuario) throws Exception {
		EntityManager em = null;
		try{
			em = EntityManagerFactoryHolder.getEntityManager();
			usuario = em.find(Usuario.class, usuario.getId());

			usuario.getCalificacionesHechas().size();
			usuario.getMisCalificaciones().size();

			em.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario traerRecorridos(Usuario usuario) throws Exception {
		EntityManager em = null;
		try{
			em = EntityManagerFactoryHolder.getEntityManager();
			usuario = em.find(Usuario.class, usuario.getId());

			usuario.getRecorridosMios().size();
			usuario.getRecorridosViajo().size();
			usuario.getHistorial().size();

			em.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}

}
