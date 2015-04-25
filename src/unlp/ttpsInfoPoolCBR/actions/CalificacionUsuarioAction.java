package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.calificacionUsuario.ICalificacionUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.CalificacionUsuarioVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Axel on 11/04/2015.
 */

@Action(value = "calificacionUsuario")
public class CalificacionUsuarioAction extends ActionSupport implements IMensajesVista{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1732315579501435521L;

	private Logger logger = LoggerFactory.getLogger(CalificacionUsuarioAction.class);
	
	private String mensajeError="";
    private String mensajeOk="";
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private ICalificacionUsuarioDao calificacionUsuarioDao;

	Integer calificacionId;
	
	Integer calificacion;
	Integer calificadoId;
	
	List<CalificacionUsuarioVo> calificacionesUsuario = new ArrayList<CalificacionUsuarioVo>();
	
	@Action(value="listarCalificacionUsuarios",results={
		@Result(name = "exito", location = "/admin/abmUsuarios.jsp"),
        @Result(name = "error", location = "/admin/abmUsuarios.jsp"),
        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String listarUsuarios(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				calificacionesUsuario=calificacionUsuarioDao.listar(em);
				return "exito";
			}catch(Exception ex){
				this.getLogger().error(ex.getMessage(),ex);
    			this.setMensajeError(this.getText("default.defaultError"));
    			this.setMensajeOk("");
    			return "error";
			}finally{
				em.close();
			}
		}else{
    		this.setMensajeError(this.getText("default.noLoggedError"));
    		this.setMensajeOk("");
    		return "nologed";
    	}
	}
	
	@Action(value="borrarCalificacionUsuario",results={
			@Result(name = "exito", location = "listarUsuarios", type = "chain"),
	        @Result(name = "error", location = "listarUsuarios",type="chain"),
	        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String borrarCalificacionUsuario(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				this.getCalificacionUsuarioDao().borrar(em, calificacionId);
				EntityManagerFactoryHolder.commitTransaction(em);
				this.setMensajeOk(this.getText("user.deleteOK"));
				return "exito";
			}catch(Exception ex){
				EntityManagerFactoryHolder.rollbackTransaction(em);
				this.getLogger().error(ex.getMessage(),ex);
    			this.setMensajeError(this.getText("default.defaultError"));
    			this.setMensajeOk("");
    			return "error";
			}
		}else{
    		this.setMensajeError(this.getText("default.noLoggedError"));
    		this.setMensajeOk("");
    		return "nologed";
    	}
	}
	@Action(value="nuevaCalificacionUsuario",results={
			@Result(name = "exito", location = "listarUsuarios", type = "chain"),
	        @Result(name = "error", location = "listarUsuarios",type="chain"),
	        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String crearCalificacionUsuario(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				UsuarioVo calificado = this.getUsuarioDao().encontrar(em, this.getCalificadoId());
				CalificacionUsuarioVo calificacionUsuarioVo = new CalificacionUsuarioVo(this.getCalificacion(), SessionUtils.getUsuario(), calificado);
				this.getCalificacionUsuarioDao().guardar(em, calificacionUsuarioVo);
				EntityManagerFactoryHolder.commitTransaction(em);
				this.setMensajeOk(this.getText("user.deleteOK"));
				return "exito";
			}catch(Exception ex){
				EntityManagerFactoryHolder.rollbackTransaction(em);
				this.getLogger().error(ex.getMessage(),ex);
    			this.setMensajeError(this.getText("default.defaultError"));
    			this.setMensajeOk("");
    			return "error";
			}
		}else{
    		this.setMensajeError(this.getText("default.noLoggedError"));
    		this.setMensajeOk("");
    		return "nologed";
    	}
	}
    
	@Override
	public String getMensajeError() {
		return mensajeError;
	}
	@Override
	public void setMensajeError(String mensajeError) {
		this.mensajeError=mensajeError;
	}
	@Override
	public String getMensajeOk() {
		return mensajeOk;
	}
	@Override
	public void setMensajeOk(String mensajeOk) {
		this.mensajeOk=mensajeOk;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public ICalificacionUsuarioDao getCalificacionUsuarioDao() {
		return calificacionUsuarioDao;
	}

	public void setCalificacionUsuarioDao(
			ICalificacionUsuarioDao calificacionUsuarioDao) {
		this.calificacionUsuarioDao = calificacionUsuarioDao;
	}

	public List<CalificacionUsuarioVo> getCalificacionesUsuario() {
		return calificacionesUsuario;
	}

	public void setCalificacionesUsuario(
			List<CalificacionUsuarioVo> calificacionesUsuario) {
		this.calificacionesUsuario = calificacionesUsuario;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Integer getCalificadoId() {
		return calificadoId;
	}

	public void setCalificadoId(Integer calificadoId) {
		this.calificadoId = calificadoId;
	}
	
}
