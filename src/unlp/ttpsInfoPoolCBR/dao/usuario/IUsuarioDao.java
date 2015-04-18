package unlp.ttpsInfoPoolCBR.dao.usuario;

import java.util.List;

import javax.persistence.EntityManager;

import unlp.ttpsInfoPoolCBR.dao.IGenericDao;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.vo.RolVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

/**
 * Created by Axel on 22/11/2014.
 */
public interface IUsuarioDao extends IGenericDao<Usuario,UsuarioVo>{
	public UsuarioVo buscarPorEmail(EntityManager em,String email) throws Exception;
	public UsuarioVo traerMensajes(EntityManager em,UsuarioVo usuario) throws Exception;
	public UsuarioVo traerDenuncias(EntityManager em,UsuarioVo usuario) throws Exception;
	public UsuarioVo traerCalificaciones(EntityManager em,UsuarioVo usuario) throws Exception;
	public UsuarioVo traerRecorridos(EntityManager em,UsuarioVo usuario) throws Exception;
	public UsuarioVo login(EntityManager em,String email,String password) throws Exception;
	public UsuarioVo traerMisRecorridos(EntityManager em,UsuarioVo usuario) throws Exception;
	public List<UsuarioVo> listarDeRol(EntityManager em,RolVo rol) throws Exception;
	public UsuarioVo traerBandejaEntrada(EntityManager em,UsuarioVo usuario) throws Exception;
	
	public List<UsuarioVo> listarExceptoUno(EntityManager em,Integer idUsuario) throws Exception;
}
