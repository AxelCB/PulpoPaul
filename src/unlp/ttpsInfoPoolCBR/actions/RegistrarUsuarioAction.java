package unlp.ttpsInfoPoolCBR.actions;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.rol.RolDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Usuario;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

@Action(value = "registrarUsuario")
@Results({
		@Result(name = "exito", 
				location = "misRecorridos",
				type = "chain"),
		//si hay algun error en el validate() se busca el result input para ir
		@Result(name = "input",
				location = "/viajero/registrar.jsp")
})

public class RegistrarUsuarioAction extends ActionSupport implements SessionAware{

	//http://www.javatpoint.com/struts-2-SessionAware-interface-example
	
	private static final long serialVersionUID = 1L;
	
	private SessionMap<String, Object> sessionMap;
	
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
		
		IRolDao rolDao = new RolDaoJPAImpl();
		try {
			usuario.setRol(rolDao.buscarPorNombre("viajero"));
			if(foto != null){
				usuario.setFoto(IOUtils.toByteArray(new FileInputStream(foto)));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return "input";
		}
		
		IUsuarioDao usuarioDao = new UsuarioDaoJPAImpl();
		
		try {
			//Vemos si no se repite el email
			if(usuarioDao.buscarPorEmail(usuario.getEmail()) == null){
				usuario = usuarioDao.guardar(usuario);
			}
			else{
				addFieldError("repetidoError", "El mail ingresado ya existe");
				return "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
		
		sessionMap.put("usuario", usuario);
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
	
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap)map;
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
