package unlp.ttpsInfoPoolCBR.dao.calificacionUsuario;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.CalificacionUsuario;

/**
 * Created by Axel on 23/11/2014.
 */
public class CalificacionUsuarioDaoJPAImpl extends GenericDaoJPAImpl<CalificacionUsuario,CalificacionUsuario> implements ICalificacionUsuarioDao {
    public CalificacionUsuarioDaoJPAImpl() {
        super(CalificacionUsuario.class, CalificacionUsuario.class);
    }
}
