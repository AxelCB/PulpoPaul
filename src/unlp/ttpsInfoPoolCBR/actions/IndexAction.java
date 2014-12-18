package unlp.ttpsInfoPoolCBR.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


@Action(value = "index")
@Result(name = "exito", location = "/index.jsp")
public class IndexAction {

	public String execute(){
		return "exito";
	}
}
