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

@Action(value = "misRecorridos")
@Results({
	@Result(name = "exito",
			location = "/viajero/misRecorridos.jsp"),
	@Result(name = "nologed",
			location = "index",
			type = "redirect")
})

public class MisRecorridosAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;

	private SessionMap<String, Object> sessionMap;
	
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession(false);  
		if(session==null || session.getAttribute("usuario")==null){  
			return "nologed";
		}
		
		return "exito";
	}
	
	public void validate(){

	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap)map;
	}
	
}
