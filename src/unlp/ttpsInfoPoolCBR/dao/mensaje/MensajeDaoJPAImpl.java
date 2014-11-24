package unlp.ttpsInfoPoolCBR.dao.mensaje;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Mensaje;

/**
 * Created by Axel on 23/11/2014.
 */
public class MensajeDaoJPAImpl extends GenericDaoJPAImpl<Mensaje,Mensaje> implements IMensajeDao {
    public MensajeDaoJPAImpl() {
        super(Mensaje.class, Mensaje.class);
    }
}
