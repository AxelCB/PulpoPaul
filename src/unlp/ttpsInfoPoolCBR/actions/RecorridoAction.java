package unlp.ttpsInfoPoolCBR.actions;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.MensajeVo;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;



@Action(value = "recorrido")
public class RecorridoAction extends ActionSupport implements IMensajesVista{

    private static final long serialVersionUID = 1L;

    @Autowired
    IRecorridoDao recorridoDao;
    
    @Autowired
    IMensajeDao mensajeDao;
    
    @Autowired
    IUsuarioDao usuarioDao;
    
    @Autowired
    Gson gson;
    
    private String mensajeError="";
    private String mensajeOk="";
    private Integer idRecorrido;
    private Integer idMensaje;
    private Boolean aceptar;
    private Integer idUsuario;

    @Action(value="buscarRecorrido")
    public String buscar(){
    	EntityManager em=null;
    	try {
    		em = EntityManagerFactoryHolder.getEntityManager();
			RecorridoVo recorrido = recorridoDao.encontrar(em,idRecorrido);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
		    response.getWriter().write(this.getGson().toJson(recorrido));
		} catch (Exception e) {
			e.printStackTrace();
			this.setMensajeError(this.getText("default.defaultError"));
			return "error";
		}finally{
			em.close();
		}
    	return null;
    }
    
    @Action(value="aceptarParticipante",results={
            @Result(name = "exito", location = "misRecorridos", type = "chain"),
            @Result(name = "error", location = "misRecorridos", type = "chain"),
            @Result(name = "input", location = "bandejaEntrada", type = "chain"),
            @Result(name = "nologed", location = "index", type = "chain")})
    public String aceptarParticipante(){
		EntityManager em = null;
		if(SessionUtils.checkLogin()&&idMensaje!=null&&aceptar!=null){
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				MensajeVo solicitud = this.getMensajeDao().encontrar(em,idMensaje);
				MensajeVo respuesta = new MensajeVo();
				respuesta.setEmisor(SessionUtils.getUsuario());
				respuesta.setReceptor(solicitud.getEmisor());
				RecorridoVo recorridoVo = solicitud.getRecorrido();
				respuesta.setAsunto("Respuesta a solicitud de participación en " + recorridoVo.getNombre());
				if(recorridoVo.getPasajeros().contains(solicitud.getEmisor())){
					solicitud.setContenido(solicitud.getContenido()+" El viajero ya es participante del viaje.");
					solicitud.setRecorrido(null);
					this.getMensajeDao().modificar(em,solicitud);
					EntityManagerFactoryHolder.commitTransaction(em);
					this.setMensajeError("El pasajero ya es parte del recorrido.");
					this.setMensajeOk("");
					return "error";
				}
				if(recorridoVo.getPasajeros().size()+1>recorridoVo.getLugares()){
					solicitud.setContenido("No habia más lugar en el recorrido.");
					solicitud.setRecorrido(null);
					respuesta.setContenido("Su solicitud al recorrido "+recorridoVo.getNombre()+" ha sido rechazada (no habia más lugar).");
					this.getMensajeDao().guardar(em, respuesta);
					this.getMensajeDao().modificar(em,solicitud);
					EntityManagerFactoryHolder.commitTransaction(em);
					this.setMensajeError("No hay más lugares en el recorrido.");
					this.setMensajeOk("");
					return "error";
				}
				if(aceptar){
					solicitud.setContenido(solicitud.getContenido()+" Usted ha aceptado a este participante.");
					recorridoVo.getPasajeros().add(solicitud.getEmisor());
					solicitud.getEmisor().agregarRecorridoViajo(recorridoVo);
					this.getUsuarioDao().modificar(em,solicitud.getEmisor());
					this.getRecorridoDao().modificar(em,recorridoVo);
					respuesta.setContenido("Su solicitud al recorrido "+recorridoVo.getNombre()+" ha sido aceptada.");
					this.setMensajeOk("Participante aceptado correctamente");
				}else{
					solicitud.setContenido(solicitud.getContenido()+" Usted ha rechazado a este participante.");
					respuesta.setContenido("Su solicitud al recorrido "+recorridoVo.getNombre()+" ha sido rechazada.");
					this.setMensajeOk("Participante rechazado correctamente");
				}
				solicitud.setRecorrido(null);
				this.getMensajeDao().guardar(em, respuesta);
				this.getMensajeDao().modificar(em,solicitud);
				EntityManagerFactoryHolder.commitTransaction(em);
				return "exito";
			}catch(Exception ex){
				EntityManagerFactoryHolder.rollbackTransaction(em);
				ex.printStackTrace();
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
    
    @Action(value="participarEnRecorrido",results={
            @Result(name = "exito", location = "misRecorridos", type = "chain"),
            @Result(name = "error", location = "misRecorridos",type ="chain"),
            @Result(name = "input", location = "misRecorridos", type = "chain"),
            @Result(name = "nologed", location = "index", type = "chain")})
    public String participar(){
		EntityManager em = null;
		if(SessionUtils.checkLogin()&&idRecorrido!=null){
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				RecorridoVo recorridoVo = recorridoDao.encontrar(em, idRecorrido);
				MensajeVo mensajeVo = new MensajeVo();
				UsuarioVo usuarioVo = SessionUtils.getUsuario();
				if(recorridoVo.getPasajeros().contains(usuarioVo)){
					this.setMensajeError("Usted ya forma parte de este recorrido!");
					this.setMensajeOk("");
					return "error";
				}
				mensajeVo.setFecha(new Date(Calendar.getInstance().getTimeInMillis()));
				mensajeVo.setReceptor(recorridoVo.getPropietario());
				mensajeVo.setEmisor(usuarioVo);
				mensajeVo.setAsunto("Participacion en " + recorridoVo.getNombre());
				mensajeVo.setContenido(usuarioVo.getNombres()+" "+usuarioVo.getApellido()
						+" desea participar en su recorrido "+recorridoVo.getNombre()
						+". Si desea aceptarlo presione 'aceptar' sino 'rechazar'.");
				mensajeVo.setRecorrido(recorridoVo);
				this.getMensajeDao().guardar(em,mensajeVo);
				EntityManagerFactoryHolder.commitTransaction(em);
			}catch(Exception ex){
				EntityManagerFactoryHolder.rollbackTransaction(em);
				ex.printStackTrace();
				this.setMensajeError("Usted ya forma parte de este recorrido!");
				this.setMensajeOk("");
				return "error";
			}
		}else{
			this.setMensajeError(this.getText("default.noLoggedError"));
			this.setMensajeOk("");
			return "nologed";
		}
    	return "input";
    }
    
    @Action(value="borrarRecorrido", results={
    		@Result(name="exito", location="misRecorridos", type="chain"),
    		@Result(name="error", location="misRecorridos", type="chain"),
    		@Result(name="nologed", location="index", type="chain")
    })
    public String borrarRecorrido(){
    	if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				this.recorridoDao.borrar(em, idRecorrido);
				EntityManagerFactoryHolder.commitTransaction(em);
				this.setMensajeOk(this.getText("myTravels.deleteOK"));
				return "exito";
			}catch(Exception ex){
				EntityManagerFactoryHolder.rollbackTransaction(em);
				ex.printStackTrace();
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
    
    @Action(value="borrarViajero", results={
    		@Result(name="exito", location="misRecorridos", type="chain"),
    		@Result(name="error", location="misRecorridos", type="chain"),
    		@Result(name="nologed", location="index", type="chain")    		
    })
    public String borrarViajero(){
    	if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				RecorridoVo recorridoVo = this.recorridoDao.encontrar(em, idRecorrido);
				UsuarioVo usuarioVo = this.usuarioDao.encontrar(em, idUsuario);
				this.recorridoDao.eliminarPasajero(em, recorridoVo, usuarioVo);
				EntityManagerFactoryHolder.commitTransaction(em);
				this.setMensajeOk(this.getText("myTravels.passengerDeleteOK"));
				return "exito";
			}catch(Exception ex){
				EntityManagerFactoryHolder.rollbackTransaction(em);
				ex.printStackTrace();
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
    
    //Getters y Setters
	public IRecorridoDao getRecorridoDao() {
		return recorridoDao;
	}
	public void setRecorridoDao(IRecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
	}
	public Gson getGson() {
		return gson;
	}
	public void setGson(Gson gson) {
		this.gson = gson;
	}
	public Integer getIdRecorrido() {
		return idRecorrido;
	}
	public void setIdRecorrido(Integer idRecorrido) {
		this.idRecorrido = idRecorrido;
	}
	public Integer getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(Integer idMensaje) {
		this.idMensaje = idMensaje;
	}
	public Boolean getAceptar() {
		return aceptar;
	}
	public void setAceptar(Boolean aceptar) {
		this.aceptar = aceptar;
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
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
