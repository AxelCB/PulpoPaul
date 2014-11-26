package unlp.ttpsInfoPoolCBR.dao.usuario;

import java.util.List;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Usuario;

/**
 * Created by Axel on 22/11/2014.
 */
public interface IUsuarioDao extends IGenericDao<Usuario,Usuario>{
	public List<Usuario> buscarPorEmail(String email) throws Exception;
}
