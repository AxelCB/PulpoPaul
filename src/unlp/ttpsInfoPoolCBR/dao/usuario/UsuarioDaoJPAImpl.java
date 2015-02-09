package unlp.ttpsInfoPoolCBR.dao.usuario;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    	Usuario usuario = null;
    	try{
	    	TypedQuery<Usuario> jpaql = this.getEm().createQuery("select u from Usuario u where u.email = :email", Usuario.class);
	    	jpaql.setParameter("email", email);
	    	List<Usuario> listaUsuario = jpaql.getResultList();
	    	if(!listaUsuario.isEmpty()){
	    		usuario = listaUsuario.get(0);
	    	}
	    	this.getEm().close();
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    	return usuario;
    }

	@Override
	public Usuario traerMensajes(Usuario usuario) throws Exception {
		try{
			usuario = this.getEm().find(Usuario.class, usuario.getId());
			
			usuario.getBandejaEntrada().size();
			usuario.getBandejaSalida().size();

			this.getEm().close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario traerDenuncias(Usuario usuario) throws Exception {
		try{
			usuario = this.getEm().find(Usuario.class, usuario.getId());

			usuario.getDenunciasHechas().size();
			usuario.getMisDenuncias().size();

			this.getEm().close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario traerCalificaciones(Usuario usuario) throws Exception {
		try{
			usuario = this.getEm().find(Usuario.class, usuario.getId());

			usuario.getCalificacionesHechas().size();
			usuario.getMisCalificaciones().size();

			this.getEm().close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario traerRecorridos(Usuario usuario) throws Exception {
		try{
			usuario = this.getEm().find(Usuario.class, usuario.getId());
			
			usuario.getRecorridosMios().size();
			usuario.getRecorridosViajo().size();
			usuario.getHistorial().size();

			this.getEm().close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario login(String email, String password) throws Exception {
		Usuario usuario = this.buscarPorEmail(email);
		if(usuario != null){
			if(!usuario.getClave().equals(password)){
				usuario = null;
			}
		}
    	return usuario;
	}
	
	@Override
	public Usuario traerMisRecorridos(Usuario usuario) throws Exception{
		try{
			TypedQuery<Usuario> jpaql = this.getEm().createQuery("select u from Usuario u join fetch u.recorridosMios where u.id = :id", Usuario.class);
			jpaql.setParameter("id", usuario.getId());
			List<Usuario> usuarios = jpaql.getResultList();
			if(!usuarios.isEmpty()){
				usuario = usuarios.get(0);
			}
			this.getEm().close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}
	
	@Override
	public Usuario traerBandejaEntrada(Usuario usuario) throws Exception{
		try{
			TypedQuery<Usuario> jpaql = this.getEm().createQuery("select u from Usuario u join fetch u.bandejaEntrada where u.id = :id", Usuario.class);
			jpaql.setParameter("id", usuario.getId());
			List<Usuario> usuarios = jpaql.getResultList();
			if(!usuarios.isEmpty()){
				usuario = usuarios.get(0);
			}
			this.getEm().close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
				
		return usuario;
	}

}
