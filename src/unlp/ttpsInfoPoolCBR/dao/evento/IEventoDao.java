package unlp.ttpsInfoPoolCBR.dao.evento;

import java.util.List;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Evento;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IEventoDao extends IGenericDao<Evento,Evento> {
	public Evento buscarPorNombre(String nombre) throws Exception;
	public List<Evento> getAll() throws Exception;
}
