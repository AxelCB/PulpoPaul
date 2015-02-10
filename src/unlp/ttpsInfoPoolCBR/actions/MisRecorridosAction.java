package unlp.ttpsInfoPoolCBR.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.Utils;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

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
	
	private List<RecorridoVo> recorridos = null;
	
	@Override
	public String execute(){
		if(Utils.checkLogin()){
			UsuarioVo usuario = Utils.getUsuario();
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

	public List<RecorridoVo> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<RecorridoVo> recorridos) {
		this.recorridos = recorridos;
	}	
	
}
