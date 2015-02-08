package unlp.ttpsInfoPoolCBR.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.model.Rol;
import unlp.ttpsInfoPoolCBR.model.Usuario;

import java.util.Map;

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
			type = "redirect")
})
public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;

	/**
	 * Usuario dao (inyectado)
	 */
	@Autowired
	IUsuarioDao usuarioDao;

	//ENTRADA
	private String usuario;
	private String clave;
	
	private Usuario user = null;
	private SessionMap<String, Object> sessionMap;
	
	public String execute(){
		String resultado = "";
		
		sessionMap.put("usuario", user);
		
		Rol rol = user.getRol();
		if(rol.getNombre().equals("administrador")){
			resultado = "administrador";
		}
		else{
			resultado = "viajero";
		}

		return resultado;
	}
	
	public void validate(){
		//NINGUNO DE ESTOS ERRORES FUNCIONA PORQUE A DONDE SE VA
		//ES OTRO ACTION (index) Y ESTE NO LOS MUESTRA
		
		if((getUsuario()==null)
			|| (getUsuario().trim().equals(""))){
			addFieldError("usuarioError","Campo obligatorio");
		}
		
		if((getClave()==null)
			|| (getClave().trim().equals(""))){
			addFieldError("claveError","Campo obligatorio");
		}
		
		//Validacion de exisitencia

		try {
			user = usuarioDao.login(usuario, clave);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(user == null){
			addFieldError("loginError", "Usuario o clave incorrectos");
		}
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
}
