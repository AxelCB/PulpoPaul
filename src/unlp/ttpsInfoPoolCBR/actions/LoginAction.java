package unlp.ttpsInfoPoolCBR.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

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
	@Result(name = "error",
			location = "index",
			type = "redirect")
})

public class LoginAction {

	//ENTRADA
	private String usuario;
	private String clave;
	
	public String execute(){
		String resultado = "error";
		
		IUsuarioDao usuarioDao = new UsuarioDaoJPAImpl();
		Usuario user = null;
		try {
			user = usuarioDao.login(usuario, clave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user != null){
			
			Rol rol = user.getRol();
			if(rol.getNombre().equals("Administrador")){
				resultado = "administrador";
			}
			else{
				resultado = "viajero";
			}
		}
		
		return resultado;
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
