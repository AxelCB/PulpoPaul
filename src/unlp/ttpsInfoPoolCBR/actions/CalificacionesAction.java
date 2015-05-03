package unlp.ttpsInfoPoolCBR.actions;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.CalificacionUsuarioVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;

@Action(value="listarCalificaciones", results={
	@Result(name="exito", location="/admin/calificaciones.jsp"),
	@Result(name="error", location="/admin/calificaciones.jsp"),
	@Result(name="nologed", location="index", type="chain"),
})
public class CalificacionesAction extends ActionSupport implements IMensajesVista{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUsuarioDao usuarioDao;
	
	private Integer calificadoId;
	private UsuarioVo usuario;
	private List<CalificacionUsuarioVo> calificaciones;
	
	private String mensajeError="";
    private String mensajeOk="";
    
    @Override
	public String execute(){
    	if(SessionUtils.checkLogin()){
    		EntityManager em = null;
    		try{
    			em = EntityManagerFactoryHolder.getEntityManager();
    			this.setUsuario(usuarioDao.encontrar(em, this.getCalificadoId()));
    			this.setCalificaciones(usuarioDao.traerCalificaciones(em, this.getUsuario()).getMisCalificaciones());
    			return "exito";
    		}catch(Exception e){
    			e.printStackTrace();
    			this.setMensajeError(this.getText("default.defaultError"));
    			this.setMensajeOk("");
    			return "error";
    		}finally{
    			em.close();
    		}
    	}else{
    		this.setMensajeError(this.getText("default.noLoggedError"));
    		return "nologed";
    	}
    }
    
	public Integer getCalificadoId() {
		return calificadoId;
	}

	public void setCalificadoId(Integer calificadoId) {
		this.calificadoId = calificadoId;
	}

	public UsuarioVo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVo usuarioVo) {
		this.usuario = usuarioVo;
	}

	public List<CalificacionUsuarioVo> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<CalificacionUsuarioVo> list) {
		this.calificaciones = list;
	}

	@Override
	public String getMensajeError() {
		return this.mensajeError;
	}

	@Override
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	@Override
	public String getMensajeOk() {
		return this.mensajeOk;
	}

	@Override
	public void setMensajeOk(String mensajeOk) {
		this.mensajeOk = mensajeOk;		
	}
	
}