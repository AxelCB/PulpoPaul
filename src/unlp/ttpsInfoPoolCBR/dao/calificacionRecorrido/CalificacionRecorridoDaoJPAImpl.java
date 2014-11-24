package unlp.ttpsInfoPoolCBR.dao.calificacionRecorrido;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.CalificacionRecorrido;

/**
 * Created by Axel on 23/11/2014.
 */
public class CalificacionRecorridoDaoJPAImpl extends GenericDaoJPAImpl<CalificacionRecorrido,CalificacionRecorrido> implements ICalificacionRecorridoDao {
    public CalificacionRecorridoDaoJPAImpl() {
        super(CalificacionRecorrido.class, CalificacionRecorrido.class);
    }
}
