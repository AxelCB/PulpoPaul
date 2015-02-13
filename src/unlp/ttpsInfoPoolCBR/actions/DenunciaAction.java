package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.aop.GenericMailSender;
import unlp.ttpsInfoPoolCBR.dao.denuncia.IDenunciaDao;
import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.DenunciaVo;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.RolVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Axel on 09/02/2015.
 */

@Action(value = "denuncia")
public class DenunciaAction extends ActionSupport implements IMensajesVista{

	/**
	 * 
	 */
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
	
	@Autowired
	GenericMailSender mail ;

	private String mensajeError="";
    private String mensajeOk="";
	
	private List<DenunciaVo> denuncias = new ArrayList<DenunciaVo>();
	
    private Integer idDenunciado;
    private String motivo;
    private Integer idRecorrido;

    //TODO definir results para este action
    @Action(value="/nueva",results={
            @Result(name = "exito", location = "misRecorridos", type = "chain"),
            @Result(name = "nologed", location = "index", type = "chain")})
    public String denunciar(){
    	if(SessionUtils.checkLogin()){
    		EntityManager em = null;
    		try{
    			em = EntityManagerFactoryHolder.getEntityManager();
    			RolVo rolAdmin = this.getRolDao().buscarPorNombre(em, "administrador");
    			List<UsuarioVo> admins = this.getUsuarioDao().listarDeRol(em, rolAdmin);
    			UsuarioVo denunciante = SessionUtils.getUsuario();
    			DenunciaVo denunciaVo = new DenunciaVo();
    			denunciaVo.setDenunciante(denunciante);
    			if(this.getIdRecorrido()!=null){
    				RecorridoVo recorrido = this.getRecorridoDao().encontrar(em,idRecorrido);
    				denunciaVo.setContenido("El usuario "+denunciante.getNombres()+" "+denunciante.getApellido()
        					+"ha denunciado al recorrido "+recorrido.getNombre()+" de "+recorrido.getPropietario().getNombres()
        					+" "+recorrido.getPropietario().getApellido()+"por el siguiente motivo: "+this.getMotivo());
    				denunciaVo.setAsunto("Denuncia al recorrido "+recorrido.getNombre());
    			}else{
    				UsuarioVo denunciado = this.getUsuarioDao().encontrar(em,idDenunciado);
    				denunciaVo.setContenido("El usuario "+denunciante.getNombres()+" "+denunciante.getApellido()
    						+"ha denunciado a "+denunciado.getNombres()+" "+denunciado.getApellido()+"por el siguiente motivo: "+this.getMotivo());
    				denunciaVo.setAsunto("Denuncia al usuario "+denunciante.getNombres()+" "+denunciante.getApellido());
    			}
    			EntityManagerFactoryHolder.beginTransaction(em);
    			for (UsuarioVo adminVo : admins) {
    				denunciaVo.setDenunciado(adminVo);
    				this.getDenunciaDao().guardar(em, denunciaVo);
				}
    			EntityManagerFactoryHolder.commitTransaction(em);
    			mail.sendEmailAfterNewDenuncia();
    			this.setMensajeOk("Denuncia enviada correctamente.");
    			return "exito";
    		}catch(Exception e){
    			EntityManagerFactoryHolder.rollbackTransaction(em);
    			this.getLogger().error(e.getMessage(),e);
    			this.setMensajeError("Ocurrió un error en el servidor. Intente nuevamente más tarde");
    			this.setMensajeOk("");
    			return "error";
    		}
    	}else{
    		this.setMensajeError("Autentiquese para utilizar la pagina");
    		this.setMensajeOk("");
    		return "nologed";
    	}
    }
    
    //TODO definir results para este action
    @Action(value="listar",results={
    		@Result(name = "exito", location = "denuncias", type = "chain"),
            @Result(name = "nologed", location = "index", type = "chain")})
    public String listar(){
    	if(SessionUtils.checkLogin()){
    		EntityManager em = null;
    		try{
    			em = EntityManagerFactoryHolder.getEntityManager();
    			UsuarioVo loggedAdmin = SessionUtils.getUsuario();
    			denuncias = this.getDenunciaDao().listarDeAdmin(em,loggedAdmin);
    			return "exito";
    		}catch(Exception e){
    			this.getLogger().error(e.getMessage(),e);
    			this.setMensajeError("Ocurrió un error en el servidor. Intente nuevamente más tarde");
    			this.setMensajeOk("");
    			return "error";
    		}
    	}else{
    		this.setMensajeError("Autentiquese para utilizar la pagina");
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
}
