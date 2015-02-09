package unlp.ttpsInfoPoolCBR.dao.recorrido;

import java.util.List;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Recorrido;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IRecorridoDao extends IGenericDao<Recorrido,Recorrido> {
	
	public List<Recorrido> listarDisponibles() throws Exception;
	
}
