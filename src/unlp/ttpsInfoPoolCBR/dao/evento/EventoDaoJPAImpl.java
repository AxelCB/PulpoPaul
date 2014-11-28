package unlp.ttpsInfoPoolCBR.dao.evento;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Evento;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;

/**
 * Created by Axel on 23/11/2014.
 */
public class EventoDaoJPAImpl extends GenericDaoJPAImpl<Evento,Evento> implements IEventoDao {
    public EventoDaoJPAImpl() {
        super(Evento.class, Evento.class);
    }
    
    @Override
    public Evento buscarPorNombre(String nombre) throws Exception{
    	EntityManager em = null;
    	Evento evento = null;
    	try{
	    	em = EntityManagerFactoryHolder.getEntityManager();
	    	TypedQuery jpaql = em.createQuery("select e from Evento e where e.nombre = :nombre", Evento.class);
	    	jpaql.setParameter("nombre", nombre);
	    	List<Evento> listaEvento = jpaql.getResultList();
	    	if(!listaEvento.isEmpty()){
	    		evento = listaEvento.get(0);
	    	}
	    	em.close();
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    	return evento;
    }
}
