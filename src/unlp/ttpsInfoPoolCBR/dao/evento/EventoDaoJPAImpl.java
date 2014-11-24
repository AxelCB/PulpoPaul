package unlp.ttpsInfoPoolCBR.dao.evento;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Evento;

/**
 * Created by Axel on 23/11/2014.
 */
public class EventoDaoJPAImpl extends GenericDaoJPAImpl<Evento,Evento> implements IEventoDao {
    public EventoDaoJPAImpl() {
        super(Evento.class, Evento.class);
    }
}
