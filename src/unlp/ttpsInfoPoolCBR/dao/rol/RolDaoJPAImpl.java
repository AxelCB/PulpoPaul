package unlp.ttpsInfoPoolCBR.dao.rol;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Rol;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axel on 23/11/2014.
 */
public class RolDaoJPAImpl extends GenericDaoJPAImpl<Rol,Rol> implements IRolDao {
    public RolDaoJPAImpl() {
        super(Rol.class, Rol.class);
    }


    @Override
    public List<Rol> buscarPorNombre(String nombre) throws Exception {
        EntityManager em = null;
        List<Rol> listaRol = new ArrayList<Rol>();
        try{
            em = EntityManagerFactoryHolder.getEntityManager();
            TypedQuery jpaql = em.createQuery("select r from Rol r where r.nombre = :nombre",Rol.class);
            jpaql.setParameter("nombre",nombre);
            listaRol = jpaql.getResultList();

        }catch(Exception ex){
            throw ex;
        }
        return listaRol;
    }
}
