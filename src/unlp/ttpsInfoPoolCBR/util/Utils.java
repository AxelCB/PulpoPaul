package unlp.ttpsInfoPoolCBR.util;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class Utils{
	
	public static boolean checkLogin(){
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if(session == null || session.getAttribute("usuario") == null){
            return false;
        }
        return true;
	}
	
}