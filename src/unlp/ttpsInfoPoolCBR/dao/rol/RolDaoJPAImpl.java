package unlp.ttpsInfoPoolCBR.dao.rol;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Rol;

import javax.persistence.TypedQuery;
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
        Rol rol = null;
        try{
            TypedQuery jpaql = this.getEm().createQuery("select r from Rol r where r.nombre = :nombre", Rol.class);
            jpaql.setParameter("nombre",nombre);
            
            List<Rol> listaRol = jpaql.getResultList();
            if(!listaRol.isEmpty()){
            	rol = listaRol.get(0);
            }
            this.getEm().close();
        }catch(Exception ex){
            throw ex;
        }
        return rol;
    }
}
