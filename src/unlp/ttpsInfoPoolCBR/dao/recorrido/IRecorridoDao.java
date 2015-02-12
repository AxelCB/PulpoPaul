package unlp.ttpsInfoPoolCBR.dao.recorrido;

import java.util.List;

import javax.persistence.EntityManager;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IRecorridoDao extends IGenericDao<Recorrido,RecorridoVo> {
	
	public List<RecorridoVo> listarDisponibles(EntityManager em,UsuarioVo usuario) throws Exception;
	
}
