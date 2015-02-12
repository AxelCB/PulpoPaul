package unlp.ttpsInfoPoolCBR.actions;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "administrador")
@Results({
	@Result(name = "exito",
			location = "/admin/homeAdmin.jsp"),
	@Result(name = "nologed",
			location = "index",
			type = "chain")
})

public class AdministradorAction extends ActionSupport implements SessionAware,IMensajesVista{

	private static final long serialVersionUID = 1L;

	private SessionMap<String, Object> sessionMap;
	
	private String mensajeError;
    private String mensajeOk;
	
	@Override
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession(false);  
		if(session==null || session.getAttribute("usuario")==null){  
			addFieldError("nologed", "Autentiquese para utilizar la pagina");
			return "nologed";
		}  
		
		return "exito";
	}
	
	@Override
	public void validate(){
		
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap)map;		
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
