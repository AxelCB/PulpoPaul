package unlp.ttpsInfoPoolCBR.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import unlp.ttpsInfoPoolCBR.util.SessionUtils;


@Action(value = "enConstruccion",results={
	@Result(name = "admin",location = "/admin/enConstruccion.jsp"),
	@Result(name = "viajero",location = "/viajero/enConstruccion.jsp"),
	@Result(name = "nologed", location = "index", type = "chain")
})
public class EnConstruccionAction implements IMensajesVista{
	
	private String mensajeError="";
    private String mensajeOk="";

	public String execute(){
		if(SessionUtils.checkLogin()){
			if(SessionUtils.getUsuario().getRol().getNombre().equals("administrador")){
				return "admin";
			}else{
				return "viajero";
			}
		}else{
			return "nologed";
		}
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
