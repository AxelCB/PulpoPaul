package unlp.ttpsInfoPoolCBR.dao.evento;

import java.util.List;

import javax.persistence.EntityManager;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Evento;
import unlp.ttpsInfoPoolCBR.vo.EventoVo;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IEventoDao extends IGenericDao<Evento,EventoVo> {
	public EventoVo buscarPorNombre(EntityManager em,String nombre) throws Exception;
	public List<EventoVo> getAll(EntityManager em) throws Exception;
	public EventoVo cargarRecorridos(EntityManager em,EventoVo eventoVo) throws Exception;
}
