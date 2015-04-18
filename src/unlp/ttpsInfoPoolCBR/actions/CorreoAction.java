package unlp.ttpsInfoPoolCBR.actions;

import java.sql.Date;
import java.util.Calendar;
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


public class CorreoAction extends ActionSupport implements IMensajesVista{

	private static final long serialVersionUID = -3825377338533388055L;
	
	@Autowired
	private IMensajeDao mensajeDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Integer idRemitente;
	private String mensaje;
	private String asunto;
	private List<UsuarioVo> usuarios;
	
	private String mensajeError="";
    private String mensajeOk="";
	
    @Action(value="redactarMensaje", results={
    		@Result(name="exito", location="/viajero/enviarMensaje.jsp"),
    		@Result(name="error", location="/viajero/enviarMensaje.jsp"),
    		@Result(name="nologed", location="index", type="chain")
    })
    public String Redactar(){
    	EntityManager em = null;
    	if(SessionUtils.checkLogin()){
    		em = EntityManagerFactoryHolder.getEntityManager();
    		try {
				usuarios = usuarioDao.listar(em);
				return "exito";
			} 
    		catch (Exception e) {
    			this.setMensajeError(this.getText("default.defaultError"));
    			this.setMensajeOk("");
    			return "error";
			}
    		finally{
    			em.close();
    		}
    	}
    	else{
    		this.setMensajeError(this.getText("default.noLoggedError"));
    		this.setMensajeOk("");
    		return "nologed";
    	}
    }
    
    
    @Action(value="enviarMensaje", results={
    		@Result(name="exito", location="/viajero/bandejaSalida.jsp", type=""),
    		@Result(name="error", location="/viajero/enviarMensaje.jsp", type=""),
    		@Result(name="nologed", location="index", type="chain")
    })
    public String Enviar(){
    	EntityManager em = null;
    	if(SessionUtils.checkLogin()){
    		em = EntityManagerFactoryHolder.getEntityManager();
    		UsuarioVo remitente;
			try {
				EntityManagerFactoryHolder.beginTransaction(em);
				remitente = usuarioDao.encontrar(em, idRemitente);
				MensajeVo msj = new MensajeVo();
	    		msj.setReceptor(remitente);
	    		msj.setEmisor(SessionUtils.getUsuario());
	    		msj.setAsunto(asunto);
	    		msj.setContenido(mensaje);
	    		msj.setFecha(new Date(Calendar.getInstance().getTimeInMillis()));
	    		mensajeDao.guardar(em, msj);
	    		this.setMensajeOk("El mensaje se envio correctamente");
				EntityManagerFactoryHolder.commitTransaction(em);
	    		return "exito";
			} 
			catch (Exception e) {
				EntityManagerFactoryHolder.rollbackTransaction(em);
				e.printStackTrace();
				this.setMensajeError(this.getText("default.defaultError"));
				this.setMensajeOk("");
				return "error";
			}
			finally{
				em.close();
			}
    	}
    	else{
    		this.setMensajeError(this.getText("default.noLoggedError"));
    		this.setMensajeOk("");
    		return "nologed";
    	}
    }
    
	public IMensajeDao getMensajeDao() {
		return mensajeDao;
	}

	public void setMensajeDao(IMensajeDao mensajeDao) {
		this.mensajeDao = mensajeDao;
	}

	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Integer getIdRemitente() {
		return idRemitente;
	}

	public void setIdRemitente(Integer idRemitente) {
		this.idRemitente = idRemitente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public List<UsuarioVo> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioVo> usuarios) {
		this.usuarios = usuarios;
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
