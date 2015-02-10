package unlp.ttpsInfoPoolCBR.dao.calificacionUsuario;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.CalificacionUsuario;
import unlp.ttpsInfoPoolCBR.vo.CalificacionUsuarioVo;

/**
 * Created by Axel on 23/11/2014.
 */
public class CalificacionUsuarioDaoJPAImpl extends GenericDaoJPAImpl<CalificacionUsuario,CalificacionUsuarioVo> implements ICalificacionUsuarioDao {
    public CalificacionUsuarioDaoJPAImpl() {
        super(CalificacionUsuario.class, CalificacionUsuarioVo.class);
    }
}
