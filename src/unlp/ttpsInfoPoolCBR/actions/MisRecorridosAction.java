package unlp.ttpsInfoPoolCBR.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.util.Utils;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "misRecorridos")
@Results({
	@Result(name = "exito",	location = "/viajero/misRecorridos.jsp"),
	@Result(name = "input",	location = "/viajero/misRecorridos.jsp"),
	@Result(name = "nologed", location = "index", type = "chain")
})
public class MisRecorridosAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Autowired
	private IUsuarioDao usuarioDao;
	
	private List<Recorrido> recorridos = null;
	
	public String execute(){
		if(Utils.checkLogin()){
			Usuario usuario = Utils.getUsuario();
			try {
				usuario = usuarioDao.traerMisRecorridos(usuario);				
				recorridos = usuario.getRecorridosMios();
			} catch (Exception e) {
				e.printStackTrace();
				return "input";
			}

			return "exito";
		}
		else{
			return "nologed";
		}
	}

	public List<Recorrido> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}	
	
}
