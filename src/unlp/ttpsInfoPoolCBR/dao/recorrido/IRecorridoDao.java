package unlp.ttpsInfoPoolCBR.dao.recorrido;

import java.util.List;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IRecorridoDao extends IGenericDao<Recorrido,RecorridoVo> {
	
	public List<RecorridoVo> listarDisponibles() throws Exception;
	
}
