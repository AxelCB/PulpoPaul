package unlp.ttpsInfoPoolCBR.actions;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.evento.IEventoDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.EventoVo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Axel on 19/12/2014.
 */

@Action(value = "eventos")
public class EventoAction extends ActionSupport implements IMensajesVista{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1521336176503501255L;

	private Logger logger = LoggerFactory.getLogger(EventoAction.class);

    @Autowired
    IEventoDao eventoDao;
    
    Integer eventoId;
    
    private String mensajeError="";
    private String mensajeOk="";

    private List<EventoVo> eventos = new ArrayList<EventoVo>();

    //Entrada agregar evento
    private String nombre;
    private String lugar;
    private String descripcion;
    private String fecha;
    private String horaComienzo;
    private String horaFin;
    private String latLng;

    @Action(value="nuevoEvento", results={
            @Result(name="exito", location="listarEventos", type="chain"),
            @Result(name="input", location="listarEventos", type="chain"),
            @Result(name = "error", location = "listarEventos",type="chain"),
            @Result(name = "nologed", location = "index", type = "chain")})
    public String guardarEvento(){
    	EntityManager em = null;
        if(SessionUtils.checkLogin()){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            Date fecha;
			try {
				fecha = formatter.parse(this.getFecha());
			} catch (ParseException e1) {
				e1.printStackTrace();
				this.setMensajeError(this.getText("default.defaultError"));
				this.setMensajeOk("");
				return "error";
			}
            EventoVo evento = new EventoVo();
            evento.setNombre(this.getNombre());
            evento.setDescripcion(this.getDescripcion());
            evento.setLugar(this.getLugar());
            evento.setFecha(fecha);
            evento.setHoraComienzo(Time.valueOf(this.getHoraComienzo()+":00"));
            evento.setHoraFin(Time.valueOf(this.getHoraFin()+":00"));
            evento.setLatLng(this.getLatLng());
            try {
            	em = EntityManagerFactoryHolder.getEntityManager();
            	EntityManagerFactoryHolder.beginTransaction(em);
            	eventoDao.guardar(em,evento);
            	EntityManagerFactoryHolder.commitTransaction(em);
			} catch (Exception e) {
				EntityManagerFactoryHolder.rollbackTransaction(em);
				e.printStackTrace();
				this.setMensajeError(this.getText("default.defaultError"));
				this.setMensajeOk("");
				return "error";
			}
        this.setMensajeOk("Evento creado exitosamente");
        return "exito";
        }
        else{
        	this.setMensajeError(this.getText("default.noLoggedError"));
        	this.setMensajeOk("");
        	return "nologed";
        }
    }

    @Action(value="listarEventos", results={
            @Result(name="input", location="/admin/abmEventos.jsp"),
            @Result(name="exito", location="/admin/abmEventos.jsp"),
            @Result(name = "error", location = "/admin/abmEventos.jsp"),
            @Result(name ="nologed",location = "index",type = "chain")})
    @SkipValidation
    public String listarEvento(){
    	EntityManager em = null;
        if(SessionUtils.checkLogin()){
        	try {
        		em = EntityManagerFactoryHolder.getEntityManager();
				this.setEventos(eventoDao.listar(em));
			} catch (Exception e) {
				e.printStackTrace();
				this.setMensajeError(this.getText("default.defaultError"));
				this.setMensajeOk("");
				return "error";
			}finally{
    			em.close();
    		}
        	return "exito";
        }
        else{
        	this.setMensajeError(this.getText("default.noLoggedError"));
        	this.setMensajeOk("");
        	return "nologed";
        }
    }
    
	@Action(value="/borrar",results={
			@Result(name = "exito", location = "??", type = "chain"),
	        @Result(name = "error", location = "??",type="chain"),
	        @Result(name = "nologed", location = "index", type = "chain")}
	)
	public String borrarUsuario(){
		if(SessionUtils.checkLogin()){
			EntityManager em = null;
			try{
				em = EntityManagerFactoryHolder.getEntityManager();
				EntityManagerFactoryHolder.beginTransaction(em);
				this.eventoDao.borrar(em, eventoId);
				EntityManagerFactoryHolder.commitTransaction(em);
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
	public void validate(){
    	
    	System.out.println("nombre: " + this.getNombre());
    	System.out.println("lugar: " + this.getLugar());
    	System.out.println("descripcion: " + this.getDescripcion());
    	System.out.println("fecha: " + this.getFecha());
    	System.out.println("hora comienzo: " + this.getHoraComienzo());
    	System.out.println("hora fin: " + this.getHoraFin());
    	System.out.println("latLng: " + this.getLatLng());
    	
        if((this.getNombre()==null)
                || (getNombre().equals(""))){
            addFieldError("nombreError","Campo obligatorio");
        }
        if((this.getLugar()==null)
                || (this.getLugar().equals(""))){
            addFieldError("lugarError","Campo obligatorio");
        }
        if((this.getDescripcion()==null)
                || (this.getDescripcion().equals(""))){
            addFieldError("descripcionError", "Campo Obligatorio");
        }
        if((this.getFecha()==null)||(this.getFecha().equals(""))){
            addFieldError("fechaError","Campo obligatorio. Elija una fecha valida");
        }
        try{
            if((this.getHoraComienzo()==null)|| (this.getHoraComienzo().equals("")||Time.valueOf(this.getHoraComienzo()+":00")==null)){
                addFieldError("horaComienzoError","Campo obligatorio. Elija una hora valida");
            }
        }catch (Exception e){
            e.printStackTrace();
            addFieldError("horaComienzoError","Campo obligatorio. Elija una hora valida");
        }
        try{
            if((this.getHoraFin()==null)|| (this.getHoraFin().equals(""))||Time.valueOf(this.getHoraFin()+":00")==null){
                addFieldError("horaFinError","Campo obligatorio. Elija una hora valida (HH:MM)");
            }
        }catch (Exception e){
            e.printStackTrace();
            addFieldError("horaFinError","Campo obligatorio. Elija una hora valida(HH:MM)");
        }

        if((this.getLatLng()==null)
                || (this.getLatLng().equals(""))){
            addFieldError("latLngError", "Campo Obligatorio");
        }
    }

    public List<EventoVo> getEventos() {
        return eventos;
    }
    public void setEventos(List<EventoVo> eventos) {
        this.eventos = eventos;
    }
    public IEventoDao getEventoDao() {
        return eventoDao;
    }
    public void setEventoDao(IEventoDao eventoDao) {
        this.eventoDao = eventoDao;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHoraComienzo() {
        return horaComienzo;
    }
    public void setHoraComienzo(String horaComienzo) {
        this.horaComienzo = horaComienzo;
    }
    public String getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    public String getLatLng() {
        return latLng;
    }
    public void setLatLng(String latLng) {
        this.latLng = latLng;
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
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public Integer getEventoId() {
		return eventoId;
	}
	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}
}
