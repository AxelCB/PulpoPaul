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
    public Rol buscarPorNombre(String nombre) throws Exception {
        EntityManager em = null;
        Rol rol = null;
        try{
            em = EntityManagerFactoryHolder.getEntityManager();
            TypedQuery jpaql = em.createQuery("select r from Rol r where r.nombre = :nombre",Rol.class);
            jpaql.setParameter("nombre",nombre);
            
            List<Rol> listaRol = jpaql.getResultList();
            if(!listaRol.isEmpty()){
            	rol = listaRol.get(0);
            }
        }catch(Exception ex){
            throw ex;
        }
        return rol;
    }
}
