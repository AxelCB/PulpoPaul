package unlp.ttpsInfoPoolCBR.dao.usuario;

import java.util.List;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.vo.RolVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

/**
 * Created by Axel on 22/11/2014.
 */
public interface IUsuarioDao extends IGenericDao<Usuario,UsuarioVo>{
	public UsuarioVo buscarPorEmail(String email) throws Exception;
	public UsuarioVo traerMensajes(UsuarioVo usuario) throws Exception;
	public UsuarioVo traerDenuncias(UsuarioVo usuario) throws Exception;
	public UsuarioVo traerCalificaciones(UsuarioVo usuario) throws Exception;
	public UsuarioVo traerRecorridos(UsuarioVo usuario) throws Exception;
	public UsuarioVo login(String email,String password) throws Exception;
	public UsuarioVo traerMisRecorridos(UsuarioVo usuario) throws Exception;
	public List<UsuarioVo> listarDeRol(RolVo rol) throws Exception;
	public UsuarioVo traerBandejaEntrada(UsuarioVo usuario) throws Exception;
}
