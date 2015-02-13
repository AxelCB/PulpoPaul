package unlp.ttpsInfoPoolCBR.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "historial")
@Results({
	@Result(name = "exito", location = "/viajero/historial.jsp"),
	@Result(name = "nologed", location = "index", type = "chain")
})
public class HistorialAction extends ActionSupport implements IMensajesVista{

	private static final long serialVersionUID = 1L;

	@Autowired
	private IRecorridoDao recorridoDao;
	
	//Variables
	private List<RecorridoVo> recorridos;
	
	private String mensajeError="";
	private String mensajeOk="";
	
	@Override
	public String execute(){
		try {
			if(SessionUtils.checkLogin()){
				//TODO Refresh user
				recorridos = SessionUtils.getUsuario().getRecorridosViajo();
				return "exito";
			}else{
				this.setMensajeError("Autentiquese para utilizar la pagina");
	        	this.setMensajeOk("");
				return "nologed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setMensajeError("Ocurrió un error en el servidor. Intente nuevamente más tarde");
			this.setMensajeOk("");
			return "error";
		}
	}

	public List<RecorridoVo> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<RecorridoVo> recorridos) {
		this.recorridos = recorridos;
	}

	@Override
	public String getMensajeError() {
		return mensajeError;
	}

	@Override
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	@Override
	public String getMensajeOk() {
		return mensajeOk;
	}

	@Override
	public void setMensajeOk(String mensajeOk) {
		this.mensajeOk = mensajeOk;
	}
	
}