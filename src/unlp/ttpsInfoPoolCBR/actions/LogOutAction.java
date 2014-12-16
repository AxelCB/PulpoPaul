package unlp.ttpsInfoPoolCBR.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "logout")
@Result(name = "exito",
		location = "index",
		type = "redirect")
public class LogOutAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;

	private SessionMap<String, Object> sessionMap;
	
	public String execute(){
		if(sessionMap != null){
			sessionMap.invalidate();
		}
		
		return "exito";
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}

}
