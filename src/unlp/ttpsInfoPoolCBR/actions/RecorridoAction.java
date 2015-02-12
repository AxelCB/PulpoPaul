package unlp.ttpsInfoPoolCBR.actions;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.MensajeVo;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;



@Action(value = "recorrido")
public class RecorridoAction extends ActionSupport{

    private static final long serialVersionUID = 1L;

    @Autowired
    IRecorridoDao recorridoDao;
    
    @Autowired
    IMensajeDao mensajeDao; 
    
    @Autowired
    Gson gson;
    
    private Integer idRecorrido;
    private Integer idMensaje;
    private Boolean aceptar;

    @Action(value="buscar")
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
		}finally{
			em.close();
		}
    	return null;
    }
    
    @Action(value="aceptarParticipante",results={
            @Result(name = "exito", location = "bandejaEntrada", type = "chain"),
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
				respuesta.setAsunto("Respuesta a solicitud de participación");
				RecorridoVo recorridoVo = solicitud.getRecorrido();
				if(aceptar){
					solicitud.setContenido(solicitud.getContenido()+" Usted ha aceptado a este participante.");
					recorridoVo.getPasajeros().add(solicitud.getEmisor());
					this.getRecorridoDao().modificar(em,recorridoVo);
					respuesta.setContenido("Su solicitud al recorrido "+recorridoVo.getNombre()+" ha sido aceptada.");
				}else{
					solicitud.setContenido(solicitud.getContenido()+" Usted ha rechazado a este participante.");
					respuesta.setContenido("Su solicitud al recorrido "+recorridoVo.getNombre()+" ha sido rechazada.");
				}
				solicitud.setRecorrido(null);
				this.getMensajeDao().guardar(em, respuesta);
				this.getMensajeDao().modificar(em,solicitud);
				EntityManagerFactoryHolder.commitTransaction(em);
				return "exito";
			}catch(Exception ex){
				EntityManagerFactoryHolder.rollbackTransaction(em);
				ex.printStackTrace();
				return "input";
			}
		}else{
			return "nologed";
		}
    }
    
    @Action(value="participar",results={
            @Result(name = "exito", location = "misRecorridos", type = "chain"),
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
				return "input";
			}
		}else{
			return "nologed";
		}
    	return "input";
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
}
