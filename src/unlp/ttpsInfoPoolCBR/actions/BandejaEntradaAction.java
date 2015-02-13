package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.MensajeVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

@Action(value = "bandejaEntrada")
@Results({
	@Result(name = "exito", location = "/viajero/bandejaEntrada.jsp"),
	@Result(name = "input", location = "/viajero/bandejaEntrada.jsp"),
	@Result(name = "nologed", location = "index", type = "chain")
})
public class BandejaEntradaAction implements IMensajesVista{

	@Autowired
	IUsuarioDao usuarioDao;
	
	@Autowired
	IMensajeDao mensajeDao;
	
	private String mensajeError="";
    private String mensajeOk="";
	
	private List<MensajeVo> mensajes = new ArrayList<MensajeVo>();
	
	public String execute(){
		EntityManager em = null;
		if(SessionUtils.checkLogin()){
			em = EntityManagerFactoryHolder.getEntityManager();
			UsuarioVo usuario = SessionUtils.getUsuario();
			try{
				usuario = usuarioDao.traerBandejaEntrada(em,usuario);
				mensajes = usuario.getBandejaEntrada();
			}
			catch(Exception ex){
				ex.printStackTrace();
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

	public List<MensajeVo> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<MensajeVo> mensajes) {
		this.mensajes = mensajes;
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
