package unlp.ttpsInfoPoolCBR.actions;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "buscarRecorridos")
@Results({
	@Result(name = "exito", location = "/viajero/buscarRecorridos.jsp"),
	@Result(name = "error", location = "/viajero/buscarRecorridos.jsp"),
	@Result(name = "nologed", location = "index", type = "chain")
})
public class BuscarRecorridosAction extends ActionSupport implements IMensajesVista{

	private static final long serialVersionUID = 1L;

	@Autowired
	private IRecorridoDao recorridoDao;
	
	//Variables
	private List<RecorridoVo> recorridos;
	
	private String mensajeError="";
    private String mensajeOk="";
	
	@Override
	public String execute(){
		EntityManager em = null;
		try {
			em = EntityManagerFactoryHolder.getEntityManager();		
			recorridos = this.getRecorridoDao().listarDisponibles(em,SessionUtils.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			this.setMensajeError(this.getText("default.defaultError"));
			this.setMensajeOk("");
			return "error";
		}finally{
			em.close();
		}
		return "exito";
	}

	public List<RecorridoVo> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<RecorridoVo> recorridos) {
		this.recorridos = recorridos;
	}

	public IRecorridoDao getRecorridoDao() {
		return recorridoDao;
	}

	public void setRecorridoDao(IRecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
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