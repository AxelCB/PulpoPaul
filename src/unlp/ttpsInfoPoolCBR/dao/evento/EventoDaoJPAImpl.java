package unlp.ttpsInfoPoolCBR.dao.evento;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.TypedQuery;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Evento;
import unlp.ttpsInfoPoolCBR.util.MapperUtils;
import unlp.ttpsInfoPoolCBR.vo.EventoVo;

/**
 * Created by Axel on 23/11/2014.
 */
public class EventoDaoJPAImpl extends GenericDaoJPAImpl<Evento,EventoVo> implements IEventoDao {
    public EventoDaoJPAImpl() {
        super(Evento.class, EventoVo.class);
    }
    
    @Override
    public EventoVo buscarPorNombre(String nombre) throws Exception{
    	EventoVo eventoVo = null;
    	try{
	    	TypedQuery<Evento> jpaql = this.getEm().createQuery("select e from Evento e where e.nombre = :nombre", Evento.class);
	    	jpaql.setParameter("nombre", nombre);
	    	List<Evento> listaEvento = jpaql.getResultList();
	    	if(!listaEvento.isEmpty()){
	    		eventoVo = MapperUtils.map(listaEvento.get(0),EventoVo.class);
	    	}
    	}
    	catch(Exception ex){
    		throw ex;
    	}finally{
        	this.getEm().close();
        }
    	return eventoVo;
    }
    
    @Override
    public List<EventoVo> getAll() throws Exception{
    	List<EventoVo> eventos = null;
    	try{
    		String query = "select e "
    					+ "		from Evento e "
    					+ "	where "
    					+ "		e.fecha >= :hoy"
    					+ "		and e.borrado = 0";
    		TypedQuery<Evento> jpaql = this.getEm().createQuery(query, Evento.class);
    		
    		Calendar cal = Calendar.getInstance();
    		jpaql.setParameter("hoy", new Date(cal.getTimeInMillis()));
    		eventos = MapperUtils.map(jpaql.getResultList(),EventoVo.class);
    	}
    	catch(Exception ex){
    		throw ex;
    	}finally{
        	this.getEm().close();
        }
    	return eventos;
    }
    
    @Override
    public EventoVo cargarRecorridos(EventoVo eventoVo) throws Exception{
    	Evento evento = MapperUtils.map(eventoVo,Evento.class);
    	try{
    		this.getEm();
    		evento.getRecorridos();
    		eventoVo = MapperUtils.map(evento,EventoVo.class);
    	}catch(Exception ex){
    		throw ex;
    	}finally{
        	this.getEm().close();
        }
    	return eventoVo;
    }
}
