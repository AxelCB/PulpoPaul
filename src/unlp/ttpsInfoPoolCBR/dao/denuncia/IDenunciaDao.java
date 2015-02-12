package unlp.ttpsInfoPoolCBR.dao.denuncia;

import java.util.List;

import javax.persistence.EntityManager;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Denuncia;
import unlp.ttpsInfoPoolCBR.vo.DenunciaVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

/**
 * Created by Axel on 23/11/2014.
 */
public interface IDenunciaDao extends IGenericDao<Denuncia,DenunciaVo> {
	
	public List<DenunciaVo> listarDeAdmin(EntityManager em,UsuarioVo admin) throws Exception;
}
