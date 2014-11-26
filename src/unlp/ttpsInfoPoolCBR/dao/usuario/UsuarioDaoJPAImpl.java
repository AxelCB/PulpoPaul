package unlp.ttpsInfoPoolCBR.dao.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;

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
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    	return usuario;
    }
}
