package unlp.ttpsInfoPoolCBR.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "administrador")
@Result(name = "exito",
		location = "/admin/homeAdmin.jsp")
public class AdministradorAction {

	public String execute(){
		return "exito";
	}
	
}
