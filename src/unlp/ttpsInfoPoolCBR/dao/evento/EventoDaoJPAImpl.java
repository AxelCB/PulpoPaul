package unlp.ttpsInfoPoolCBR.dao.evento;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Evento;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Axel on 23/11/2014.
 */
public class EventoDaoJPAImpl extends GenericDaoJPAImpl<Evento,Evento> implements IEventoDao {
    public EventoDaoJPAImpl() {
        super(Evento.class, Evento.class);
    }
    
    @Override
    public Evento buscarPorNombre(String nombre) throws Exception{
    	Evento evento = null;
    	try{
	    	TypedQuery jpaql = this.getEm().createQuery("select e from Evento e where e.nombre = :nombre", Evento.class);
	    	jpaql.setParameter("nombre", nombre);
	    	List<Evento> listaEvento = jpaql.getResultList();
	    	if(!listaEvento.isEmpty()){
	    		evento = listaEvento.get(0);
	    	}
	    	this.getEm().close();
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    	return evento;
    }
}
