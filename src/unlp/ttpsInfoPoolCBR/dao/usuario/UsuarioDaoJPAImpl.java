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
    public List<Usuario> buscarPorEmail(String email) throws Exception{
    	EntityManager em = null;
    	List<Usuario> listaUsuario = new ArrayList<Usuario>();
    	try{
	    	em = EntityManagerFactoryHolder.getEntityManager();
	    	TypedQuery jpaql = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
	    	jpaql.setParameter("email", email);
	    	listaUsuario = jpaql.getResultList();
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    	
    	return listaUsuario;
    }
}
