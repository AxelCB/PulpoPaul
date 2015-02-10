package unlp.ttpsInfoPoolCBR.dao.evento;

import java.util.List;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Evento;
import unlp.ttpsInfoPoolCBR.vo.EventoVo;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IEventoDao extends IGenericDao<Evento,EventoVo> {
	public EventoVo buscarPorNombre(String nombre) throws Exception;
	public List<EventoVo> getAll() throws Exception;
	public EventoVo cargarRecorridos(EventoVo eventoVo) throws Exception;
}
