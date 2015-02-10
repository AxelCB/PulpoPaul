package unlp.ttpsInfoPoolCBR.dao.viaje;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Viaje;
import unlp.ttpsInfoPoolCBR.vo.ViajeVo;

/**
 * Created by Axel on 23/11/2014.
 */
public class ViajeDaoJPAImpl extends GenericDaoJPAImpl<Viaje,ViajeVo> implements IViajeDao {
    public ViajeDaoJPAImpl() {
        super(Viaje.class, ViajeVo.class);
    }
}
