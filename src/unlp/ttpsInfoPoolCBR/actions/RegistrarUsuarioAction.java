package unlp.ttpsInfoPoolCBR.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.model.Usuario;

import java.io.File;
import java.io.FileInputStream;

@Action(value = "registrarUsuario")
@Results({
		@Result(name = "exito", 
				location = "/viajero/misRecorridos.jsp"),
		//si hay algun error se busca el result input para ir
		@Result(name = "input",
				location = "/viajero/registrar.jsp")
})

public class RegistrarUsuarioAction extends ActionSupport{

	//http://www.javatpoint.com/struts-2-SessionAware-interface-example
	
	private static final long serialVersionUID = 1L;

	/**
	 * Usuario DAO
	 */
	@Autowired
	IUsuarioDao usuarioDao;

	/**
	 * Rol DAO
	 */
	@Autowired
	IRolDao rolDao;
	
	//ENTRADA
	private String nombre;
	private String apellido;
	private Integer telefono;
	private String email;
	private String clave;
	private String repetirClave;
	private File foto;
	
	public String execute(){
		Usuario usuario = new Usuario();
		
		usuario.setNombres(this.getNombre());
		usuario.setApellido(this.getApellido());
		usuario.setTelefono(this.getTelefono());
		usuario.setEmail(this.getEmail());
		usuario.setClave(this.getClave());

		try {
			usuario.setRol(rolDao.buscarPorNombre("viajero"));
			
			if(this.getFoto()!=null){
				//Se pasa a un array de bytes
				usuario.setFoto(IOUtils.toByteArray(new FileInputStream(this.getFoto())));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			return "input";
		}
		
		try {
			usuarioDao.guardar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
		
		return "exito";
	}
	
	public void validate(){
		if((getNombre()==null)
			|| (getNombre().equals(""))){
			addFieldError("nombreError","Campo obligatorio");
		}
		
		if((getApellido()==null)
			|| (getApellido().equals(""))){
			addFieldError("apellidoError","Campo obligatorio");
		}
		
		if(getTelefono()==null){
			addFieldError("telefonoError", "Ingrese valores permitidos");
		}
		
		if((getEmail()==null)
			|| (getEmail().equals(""))){
			addFieldError("emailError","Campo obligatorio");
		}
		
		if((getClave()==null)
			|| (getClave().equals(""))){
			addFieldError("claveError","Campo obligatorio");
		}
		
		if((getRepetirClave()==null)
			|| (getRepetirClave().equals(""))){
			addFieldError("repetirClaveError","Campo obligatorio");
		}
		
		if(
			(getClave()!=null) 
			&& (!getClave().equals(""))
			&& (getRepetirClave()!=null) 
			&& (!getRepetirClave().equals(""))
			&& (!getClave().equals(getRepetirClave()))
			){
			addFieldError("repetirClaveError2","Las claves deben coincidir");
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getRepetirClave() {
		return repetirClave;
	}
	public void setRepetirClave(String repetirClave) {
		this.repetirClave = repetirClave;
	}
	public File getFoto() {
		return foto;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}
	
}
