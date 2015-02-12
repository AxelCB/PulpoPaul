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
	@Result(name = "nologed", location = "index", type = "chain")
})
public class BuscarRecorridosAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Autowired
	private IRecorridoDao recorridoDao;
	
	//Variables
	private List<RecorridoVo> recorridos;
	
	@Override
	public String execute(){
		EntityManager em = null;
		try {
			em = EntityManagerFactoryHolder.getEntityManager();		
			recorridos = recorridoDao.listarDisponibles(em,SessionUtils.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
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
	
}