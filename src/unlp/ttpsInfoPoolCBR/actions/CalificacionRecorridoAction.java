package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.calificacionRecorrido.ICalificacionRecorridoDao;
import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.CalificacionRecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Axel on 11/04/2015.
 */

@Action(value = "calificacionRecorrido")
public class CalificacionRecorridoAction extends ActionSupport implements IMensajesVista{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1732315579501435521L;

	private Logger logger = LoggerFactory.getLogger(CalificacionRecorridoAction.class);
	
	private String mensajeError="";
    private String mensajeOk="";
	
	@Autowired
	private IRecorridoDao recorridoDao;
	
	@Autowired
	private ICalificacionRecorridoDao calificacionRecorridoDao;

	Integer calificacionId;
	
	Integer calificacion;
	Integer calificadoId;
	
	List<CalificacionRecorridoVo> calificacionesRecorrido = new ArrayList<CalificacionRecorridoVo>();
	
	@Action(value="listarCalificacionRecorridos",results={
		@Result(name = "exito", location = "/admin/abmRecorridos.jsp"),
        @Result(name = "error", location = "/admin/abmRecorridos.jsp"),
        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String listarRecorridos(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				calificacionesRecorrido=calificacionRecorridoDao.listar(em);
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
	
	@Action(value="borrarCalificacionRecorrido",results={
			@Result(name = "exito", location = "listarRecorridos", type = "chain"),
	        @Result(name = "error", location = "listarRecorridos",type="chain"),
	        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String borrarCalificacionRecorrido(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				this.getCalificacionRecorridoDao().borrar(em, calificacionId);
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
	@Action(value="nuevaCalificacionRecorrido",results={
			@Result(name = "exito", location = "listarRecorridos", type = "chain"),
	        @Result(name = "error", location = "listarRecorridos",type="chain"),
	        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String crearCalificacionRecorrido(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				RecorridoVo calificado = this.getRecorridoDao().encontrar(em, this.getCalificadoId());
				CalificacionRecorridoVo calificacionRecorridoVo = new CalificacionRecorridoVo(this.getCalificacion(),calificado,SessionUtils.getUsuario());
				this.getCalificacionRecorridoDao().guardar(em, calificacionRecorridoVo);
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

	public IRecorridoDao getRecorridoDao() {
		return recorridoDao;
	}

	public void setRecorridoDao(IRecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
	}

	public ICalificacionRecorridoDao getCalificacionRecorridoDao() {
		return calificacionRecorridoDao;
	}

	public void setCalificacionRecorridoDao(
			ICalificacionRecorridoDao calificacionRecorridoDao) {
		this.calificacionRecorridoDao = calificacionRecorridoDao;
	}

	public List<CalificacionRecorridoVo> getCalificacionesRecorrido() {
		return calificacionesRecorrido;
	}

	public void setCalificacionesRecorrido(
			List<CalificacionRecorridoVo> calificacionesRecorrido) {
		this.calificacionesRecorrido = calificacionesRecorrido;
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
