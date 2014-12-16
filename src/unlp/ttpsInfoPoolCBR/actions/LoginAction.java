package unlp.ttpsInfoPoolCBR.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Rol;
import unlp.ttpsInfoPoolCBR.model.Usuario;

@Action(value = "login")
@Results({
	@Result(name = "viajero",
			location = "viajero",
			type = "redirect"),
	@Result(name = "administrador",
			location = "administrador",
			type = "redirect"),
	@Result(name = "input",
			location = "index",
			type = "redirect")
})

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	//ENTRADA
	private String usuario;
	private String clave;
	
	private Usuario user = null;
	
	public String execute(){
		String resultado = "";
		
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
		if((getUsuario()==null)
			|| (getUsuario().equals(""))){
			addFieldError("usuarioError","Campo obligatorio");
		}
		
		if((getClave()==null)
			|| (getClave().equals(""))){
			addFieldError("claveError","Campo obligatorio");
		}
		
		//Validacion de exisitencia
		IUsuarioDao usuarioDao = new UsuarioDaoJPAImpl();
		try {
			user = usuarioDao.login(usuario, clave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(usuario == null){
			addFieldError("loginError", "Usuario o clave incorrectos");
		}
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
