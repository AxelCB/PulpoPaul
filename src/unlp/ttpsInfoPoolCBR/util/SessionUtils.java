package unlp.ttpsInfoPoolCBR.util;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

public class SessionUtils{
	
	public static boolean checkLogin(){
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if(session == null || session.getAttribute("usuario") == null){
            return false;
        }
        return true;
	}
	
	
	public static UsuarioVo getUsuario(){
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		return((UsuarioVo)session.getAttribute("usuario"));
	}
}