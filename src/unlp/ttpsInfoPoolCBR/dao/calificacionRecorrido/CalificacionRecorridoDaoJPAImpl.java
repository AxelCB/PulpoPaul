package unlp.ttpsInfoPoolCBR.dao.calificacionRecorrido;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.CalificacionRecorrido;
import unlp.ttpsInfoPoolCBR.vo.CalificacionRecorridoVo;

/**
 * Created by Axel on 23/11/2014.
 */
public class CalificacionRecorridoDaoJPAImpl extends GenericDaoJPAImpl<CalificacionRecorrido,CalificacionRecorridoVo> implements ICalificacionRecorridoDao {
    public CalificacionRecorridoDaoJPAImpl() {
        super(CalificacionRecorrido.class, CalificacionRecorridoVo.class);
    }
}
