package unlp.ttpsInfoPoolCBR.dao.rol;

import javax.persistence.EntityManager;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Rol;
import unlp.ttpsInfoPoolCBR.vo.RolVo;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IRolDao extends IGenericDao<Rol,RolVo> {

    public RolVo buscarPorNombre(EntityManager em,String nombre)throws Exception;
}
