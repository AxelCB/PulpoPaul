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
	@Result(name = "input",
			location = "index",
			type = "redirect")
})

public class AdministradorAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;

	private SessionMap<String, Object> sessionMap;
	
	public String execute(){
		return "exito";
	}
	
	public void validate(){
		HttpSession session = ServletActionContext.getRequest().getSession(false);  
		if(session==null || session.getAttribute("usuario")==null){  
			addFieldError("logeadoError", "Debe loguearse para poder acceder al sitio");  
		}  
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap)map;		
	}
	
}
