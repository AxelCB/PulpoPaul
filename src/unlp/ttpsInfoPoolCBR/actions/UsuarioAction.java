package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Axel on 11/04/2015.
 */

@Action(value = "usuario")
public class UsuarioAction extends ActionSupport implements IMensajesVista{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8804049155091206367L;
	
	private Logger logger = LoggerFactory.getLogger(UsuarioAction.class);
	
	private String mensajeError="";
    private String mensajeOk="";
	
	@Autowired
	IUsuarioDao usuarioDao;
	
	@Autowired
	IRolDao rolDao;
	
	Integer usuarioId;
	
	List<UsuarioVo> usuarios = new ArrayList<UsuarioVo>();
	
	@Action(value="listarUsuarios",results={
		@Result(name = "exito", location = "/admin/abmUsuarios.jsp"),
        @Result(name = "error", location = "/admin/abmUsuarios.jsp"),
        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String listarUsuarios(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				usuarios=usuarioDao.listar(em);
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
	
	@Action(value="borrarUsuario",results={
			@Result(name = "exito", location = "usuario/listar", type = "chain"),
	        @Result(name = "error", location = "usuario/listar",type="chain"),
	        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String borrarUsuario(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				this.usuarioDao.borrar(em, usuarioId);
				EntityManagerFactoryHolder.commitTransaction(em);
				this.setMensajeOk("El usuario se elimino correctamente");
				return "exito";
			}catch(Exception ex){
				EntityManagerFactoryHolder.rollbackTransaction(em);
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
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public List<UsuarioVo> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioVo> usuarios) {
		this.usuarios = usuarios;
	}
}
