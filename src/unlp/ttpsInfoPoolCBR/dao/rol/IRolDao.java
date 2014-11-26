package unlp.ttpsInfoPoolCBR.dao.rol;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Rol;

import java.util.List;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IRolDao extends IGenericDao<Rol,Rol> {

    public Rol buscarPorNombre(String nombre)throws Exception;
}
