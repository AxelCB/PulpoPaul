package unlp.ttpsInfoPoolCBR.actions;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "misRecorridos")
@Results({
	@Result(name = "exito",	location = "/viajero/misRecorridos.jsp"),
	@Result(name = "input",	location = "/viajero/misRecorridos.jsp"),
	@Result(name = "nologed", location = "index", type = "chain")
})
public class MisRecorridosAction extends ActionSupport implements IMensajesVista{

	private static final long serialVersionUID = 1L;

	@Autowired
	private IUsuarioDao usuarioDao;
	
	private List<RecorridoVo> recorridos = null;
	
	private String mensajeError="";
    private String mensajeOk="";
	
	@Override
	public String execute(){
		EntityManager em = null;
		if(SessionUtils.checkLogin()){
			UsuarioVo usuario = SessionUtils.getUsuario();
			try {
				em = EntityManagerFactoryHolder.getEntityManager();
				usuario = this.getUsuarioDao().traerMisRecorridos(em,usuario);				
				recorridos = usuario.getRecorridosMios();
			} catch (Exception e) {
				e.printStackTrace();
				this.setMensajeError("Ocurrió un error en el servidor. Intente nuevamente más tarde");
				this.setMensajeOk("");
				return "error";
			}finally{
				em.close();
			}
			return "exito";
		}
		else{
			this.setMensajeError("Autentiquese para utilizar la pagina");
			this.setMensajeOk("");
			return "nologed";
		}
	}

	public List<RecorridoVo> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<RecorridoVo> recorridos) {
		this.recorridos = recorridos;
	}

	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
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
