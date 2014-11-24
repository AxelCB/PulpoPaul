package unlp.ttpsInfoPoolCBR.dao.recorrido;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Recorrido;

/**
 * Created by Axel on 23/11/2014.
 */
public class RecorridoDaoJPAImpl extends GenericDaoJPAImpl<Recorrido,Recorrido> implements IRecorridoDao {
    public RecorridoDaoJPAImpl() {
        super(Recorrido.class, Recorrido.class);
    }
}
