package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.denuncia.IDenunciaDao;
import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.DenunciaVo;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Axel on 09/02/2015.
 */

@Action(value = "denuncia")
public class DenunciaAction extends ActionSupport implements IMensajesVista{

	private static final long serialVersionUID = -2653654270018155961L;
	
	private Logger logger = LoggerFactory.getLogger(DenunciaAction.class);
	
	@Autowired
	IDenunciaDao denunciaDao;
	
	@Autowired
	IUsuarioDao usuarioDao;
	
	@Autowired
	IRolDao rolDao;
	
	@Autowired
	IRecorridoDao recorridoDao;
	
	private String mensajeError="";
    private String mensajeOk="";
	
	private List<DenunciaVo> denuncias = new ArrayList<DenunciaVo>();
	
    private Integer idDenunciado;
    private String motivo="";
    private Integer idRecorrido;
    private String referer="";
    private UsuarioVo usuario;

    @Action(value="nuevaDenuncia",results={
            @Result(name = "exito", location = "misRecorridos", type = "chain"),
            @Result(name = "error", location = "misRecorridos",type="chain"),
            @Result(name = "nologed", location = "index", type = "chain")})
    public String denunciar(){
    	if(SessionUtils.checkLogin()){
    		EntityManager em = null;
    		HttpServletRequest request = ServletActionContext.getRequest();
    		this.setReferer(request.getHeader("referer"));
    		try{
    			em = EntityManagerFactoryHolder.getEntityManager();
    			UsuarioVo denunciante = SessionUtils.getUsuario();
    			DenunciaVo denunciaVo = new DenunciaVo();
    			denunciaVo.setDenunciante(denunciante);
    			if(this.getIdRecorrido()!=null){
    				RecorridoVo recorrido = this.getRecorridoDao().encontrar(em,idRecorrido);
    				denunciaVo.setContenido("El usuario "+denunciante.getNombres()+" "+denunciante.getApellido()
        					+"ha denunciado al recorrido "+recorrido.getNombre()+" de "+recorrido.getPropietario().getNombres()
        					+" "+recorrido.getPropietario().getApellido()+" por el siguiente motivo: "+this.getMotivo());
    				denunciaVo.setAsunto("Denuncia al recorrido "+recorrido.getNombre());
    				denunciaVo.setDenunciado(recorrido.getPropietario());
    			}else{
    				UsuarioVo denunciado = this.getUsuarioDao().encontrar(em,idDenunciado);
    				denunciaVo.setContenido("El usuario "+denunciante.getNombres()+" "+denunciante.getApellido()
    						+"ha denunciado a "+denunciado.getNombres()+" "+denunciado.getApellido()+" por el siguiente motivo: "+this.getMotivo());
    				denunciaVo.setAsunto("Denuncia al usuario "+denunciante.getNombres()+" "+denunciante.getApellido());
    				denunciaVo.setDenunciado(denunciado);
    			}
    			EntityManagerFactoryHolder.beginTransaction(em);
    			this.getDenunciaDao().guardar(em, denunciaVo);
    			EntityManagerFactoryHolder.commitTransaction(em);
    			this.setMensajeOk("Denuncia enviada correctamente.");
    			return "exito";
    		}catch(Exception e){
    			EntityManagerFactoryHolder.rollbackTransaction(em);
    			this.getLogger().error(e.getMessage(),e);
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
    
    //TODO definir results para este action
    @Action(value="listarDenuncias", results={
    		@Result(name = "exito", location = "/admin/denuncias.jsp"),
    		@Result(name = "error", location = "/admin/denuncias.jsp"),
            @Result(name = "nologed", location = "index", type = "chain")})
    public String listar(){
    	if(SessionUtils.checkLogin()){
    		EntityManager em = null;
    		try{
    			em = EntityManagerFactoryHolder.getEntityManager();
    			if(null == idDenunciado){
    				denuncias = this.getDenunciaDao().listar(em);
    			}
    			else{
    				usuario = usuarioDao.encontrar(em, idDenunciado);
    				usuario = usuarioDao.traerDenuncias(em, usuario);
    				denuncias = usuario.getMisDenuncias();
    			}
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
    		this.setMensajeOk("");
    		return "nologed";
    	}
    }
    
	public IDenunciaDao getDenunciaDao() {
		return denunciaDao;
	}
	public void setDenunciaDao(IDenunciaDao denunciaDao) {
		this.denunciaDao = denunciaDao;
	}
	public List<DenunciaVo> getDenuncias() {
		return denuncias;
	}
	public void setDenuncias(List<DenunciaVo> denuncias) {
		this.denuncias = denuncias;
	}
	public Integer getIdDenunciado() {
		return idDenunciado;
	}
	public void setIdDenunciado(Integer idDenunciado) {
		this.idDenunciado = idDenunciado;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Integer getIdRecorrido() {
		return idRecorrido;
	}
	public void setIdRecorrido(Integer idRecorrido) {
		this.idRecorrido = idRecorrido;
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
	public IRecorridoDao getRecorridoDao() {
		return recorridoDao;
	}
	public void setRecorridoDao(IRecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
	}
	public IRolDao getRolDao() {
		return rolDao;
	}
	public void setRolDao(IRolDao rolDao) {
		this.rolDao = rolDao;
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

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}
	
	public UsuarioVo getUsuario(){
		return usuario;
	}
	
	public void setUsuario(UsuarioVo usuario){
		this.usuario = usuario;
	}
	
}
