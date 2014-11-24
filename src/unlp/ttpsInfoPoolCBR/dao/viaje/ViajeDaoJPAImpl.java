package unlp.ttpsInfoPoolCBR.dao.viaje;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Viaje;

/**
 * Created by Axel on 23/11/2014.
 */
public class ViajeDaoJPAImpl extends GenericDaoJPAImpl<Viaje,Viaje> implements IViajeDao {
    public ViajeDaoJPAImpl() {
        super(Viaje.class, Viaje.class);
    }
}
