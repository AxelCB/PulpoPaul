package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.MensajeVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;

@Action(value="bandejaSalida", results={
		@Result(name="exito", location="/viajero/bandejaSalida.jsp"),
		@Result(name="error", location="/viajero/bandejaSalida.jsp"),
		@Result(name="nologed", location="index", type="chain")
})
public class BandejaSalidaAction extends ActionSupport implements IMensajesVista {

	private static final long serialVersionUID = 2057644981596801689L;
	
	@Autowired
	IUsuarioDao usuarioDao;
	
	@Autowired
	IMensajeDao mensajeDao;
	
	private String mensajeError = "";
	private String mensajeOk = "";
	
	private List<MensajeVo> mensajes = new ArrayList<MensajeVo>();

	@Override
	public String execute(){
		EntityManager em = null;
		if(SessionUtils.checkLogin()){
			em = EntityManagerFactoryHolder.getEntityManager();
			UsuarioVo usuario = SessionUtils.getUsuario();
			try{
				usuario = usuarioDao.traerMensajes(em, usuario);
				mensajes = usuario.getBandejaSalida();
				//usuario = usuarioDao.traerBandejaEntrada(em, usuario); //TODO
				//mensajes = usuario.getBandejaEntrada(); //TODO
			}
			catch(Exception ex){
				ex.printStackTrace();
				this.setMensajeError(this.getText("default.defaultError"));
				this.setMensajeOk("");
				return "error";
			}finally{
				em.close();
			}
			return "exito";
		}
		else{
			this.setMensajeError(this.getText("default.noLoggedError"));
			this.setMensajeOk("");
			return "nologed";
		}
	}
	
	
	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}
	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	public IMensajeDao getMensajeDao() {
		return mensajeDao;
	}
	public void setMensajeDao(IMensajeDao mensajeDao) {
		this.mensajeDao = mensajeDao;
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
	public void setMensajeOk(String mensajeOK) {
		this.mensajeOk = mensajeOK;
	}

}
