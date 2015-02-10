package unlp.ttpsInfoPoolCBR.dao.usuario;

import java.util.List;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Rol;
import unlp.ttpsInfoPoolCBR.model.Usuario;

/**
 * Created by Axel on 22/11/2014.
 */
public interface IUsuarioDao extends IGenericDao<Usuario,Usuario>{
	public Usuario buscarPorEmail(String email) throws Exception;
	public Usuario traerMensajes(Usuario usuario) throws Exception;
	public Usuario traerDenuncias(Usuario usuario) throws Exception;
	public Usuario traerCalificaciones(Usuario usuario) throws Exception;
	public Usuario traerRecorridos(Usuario usuario) throws Exception;
	public Usuario login(String email,String password) throws Exception;
	public Usuario traerMisRecorridos(Usuario usuario) throws Exception;
	public List<Usuario> listarDeRol(Rol rol) throws Exception;
}
