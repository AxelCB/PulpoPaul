package unlp.ttpsInfoPoolCBR.dao.evento;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Evento;

import javax.persistence.TypedQuery;

import java.sql.Date;
import java.util.Calendar;
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
    
    @Override
    public List<Evento> getAll() throws Exception{
    	List<Evento> eventos = null;
    	try{
    		String query = "select e "
    					+ "		from Evento e "
    					+ "	where "
    					+ "		e.fecha >= :hoy"
    					+ "		and e.borrado = 0";
    		TypedQuery jpaql = this.getEm().createQuery(query, Evento.class);
    		
    		Calendar cal = Calendar.getInstance();
    		jpaql.setParameter("hoy", new Date(cal.getTimeInMillis()));
    		eventos = jpaql.getResultList();
    		this.getEm().close();
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    	return eventos;
    }
    
    @Override
    public Evento cargarRecorridos(Evento evento) throws Exception{
    	this.getEm();
    	evento.getRecorridos();
    	this.getEm().close();
    	return evento;
    }
}
