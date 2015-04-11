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
	
	List<UsuarioVo> usuarios = new ArrayList<UsuarioVo>();
	
	@Action(value="/listar",results={
		@Result(name = "exito", location = "??", type = "chain"),
        @Result(name = "error", location = "??",type="chain"),
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
}
