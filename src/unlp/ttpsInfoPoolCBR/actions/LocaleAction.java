package unlp.ttpsInfoPoolCBR.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


@Action(value="locale")
@Results({
	@Result(location="index",type="chain")
})
public class LocaleAction extends ActionSupport{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -2561897939611931507L;

	//business logic
	@Override
	public String execute() {
		return "SUCCESS";
	}
}