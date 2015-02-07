package unlp.ttpsInfoPoolCBR.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.model.Recorrido;

@Action(value = "buscarRecorridos")
@Results({
	@Result(name = "exito", location = "/viajero/buscarRecorridos.jsp"),
	@Result(name = "nologed", location = "index", type = "chain")
})
public class BuscarRecorridosAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Autowired
	private IRecorridoDao recorridoDao;
	
	//Variables
	private List<Recorrido> recorridos;
	
	public String execute(){
		
		try {
			recorridos = recorridoDao.listarDisponibles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exito";
	}

	public List<Recorrido> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}
	
}