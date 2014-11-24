package unlp.ttpsInfoPoolCBR.dao.rol;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Rol;

/**
 * Created by Axel on 23/11/2014.
 */
public class RolDaoJPAImpl extends GenericDaoJPAImpl<Rol,Rol> implements IRolDao {
    public RolDaoJPAImpl() {
        super(Rol.class, Rol.class);
    }
}
