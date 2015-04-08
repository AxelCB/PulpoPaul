package unlp.ttpsInfoPoolCBR.actions;

import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.vo.RolVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "login")
@Results({
	@Result(name = "viajero",
			location = "misRecorridos",
			type = "redirect"),
	@Result(name = "administrador",
			location = "listarEventos",
			type = "redirect"),
	@Result(name = "input",
			location = "index",
			type = "redirect"),
	@Result(name = "error",
			location = "index",
			type = "chain")
})
public class LoginAction extends ActionSupport implements SessionAware,IMensajesVista{

	private static final long serialVersionUID = 1L;

	/**
	 * Usuario dao (inyectado)
	 */
	@Autowired
	IUsuarioDao usuarioDao;

	//ENTRADA
	private String usuario;
	private String clave;
	
	private UsuarioVo user = null;
	private SessionMap<String, Object> sessionMap;
	
	private String mensajeError="";
    private String mensajeOk="";
	
	@Override
	public String execute(){
		String resultado = "";
		
		LOG.error(this.getText("mensaje1"));
		LOG.error(this.getLocale().toString());
		
		EntityManager em = null;
		try {
			em = EntityManagerFactoryHolder.getEntityManager();
			if(this.getUsuario()==null || this.getUsuario().equals("")){
				this.setMensajeOk("");
				this.setMensajeError("Debe ingresar un nombre de usuario.");
				return "error";
			}
			if(this.getClave()==null || this.getClave().equals("")){
				this.setMensajeOk("");
				this.setMensajeError("Debe ingresar su clave.");
				return "error";
			}
			user = usuarioDao.login(em,usuario, clave);
			if(user==null){
				this.setMensajeOk("");
				this.setMensajeError("No existe el usuario/clave ingresado, intente nuevamente.");
				return "error";
			}
			sessionMap.put("usuario", user);
			
			RolVo rol = user.getRol();
			if(rol.getNombre().equals("administrador")){
				resultado = "administrador";
			}
			else{
				resultado = "viajero";
			}

			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
			this.setMensajeOk("");
			this.setMensajeError("Ocurrió un error en el servidor, intente nuevamente más tarde.");
			return "error";
		}finally{
			em.close();
		}
	}
	
	@Override
	public void validate(){
		//NINGUNO DE ESTOS ERRORES FUNCIONA PORQUE A DONDE SE VA
		//ES OTRO ACTION (index) Y ESTE NO LOS MUESTRA
		
//		if((getUsuario()==null)
//			|| (getUsuario().trim().equals(""))){
//			addFieldError("usuarioError","Campo obligatorio");
//		}
//		
//		if((getClave()==null)
//			|| (getClave().trim().equals(""))){
//			addFieldError("claveError","Campo obligatorio");
//		}
//		
//		if(user == null){
//			addFieldError("loginError", "Usuario o clave incorrectos");
//		}
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}
	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	@Override
	public String getMensajeError() {
		return mensajeError;
	}
	@Override
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	@Override
	public String getMensajeOk() {
		return mensajeOk;
	}
	@Override
	public void setMensajeOk(String mensajeOk) {
		this.mensajeOk = mensajeOk;
	}
}
