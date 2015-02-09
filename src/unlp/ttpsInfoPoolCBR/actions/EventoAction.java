package unlp.ttpsInfoPoolCBR.actions;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.evento.IEventoDao;
import unlp.ttpsInfoPoolCBR.model.Evento;
import unlp.ttpsInfoPoolCBR.util.Utils;

import javax.servlet.http.HttpSession;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Axel on 19/12/2014.
 */

@Action(value = "eventos")
public class EventoAction extends ActionSupport{

    private static final long serialVersionUID = 1L;

    @Autowired
    IEventoDao eventoDao;

    private List<Evento> eventos = new ArrayList<Evento>();

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
            @Result(name = "nologed", location = "index", type = "chain")})
    public String guardarEvento(){
        if(Utils.checkLogin()){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            Date fecha;
			try {
				fecha = formatter.parse(this.getFecha());
			} catch (ParseException e1) {
				e1.printStackTrace();
				return "input";
			}
            Evento evento = new Evento();
            evento.setNombre(this.getNombre());
            evento.setDescripcion(this.getDescripcion());
            evento.setLugar(this.getLugar());
            evento.setFecha(fecha);
            evento.setHoraComienzo(Time.valueOf(this.getHoraComienzo()+":00"));
            evento.setHoraFin(Time.valueOf(this.getHoraFin()+":00"));
            evento.setLatLng(this.getLatLng());
            try {
				eventoDao.guardar(evento);
			} catch (Exception e) {
				e.printStackTrace();
				return "input";
			}

        return "exito";
        }
        else{
        	addFieldError("nologed", "Autentiquese para utilizar la pagina");
        	return "nologed";
        }
    }

    @Action(value="listarEventos", results={
            @Result(name="input", location="/admin/abmEventos.jsp"),
            @Result(name="exito", location="/admin/abmEventos.jsp"),
            @Result(name ="nologed",location = "index",type = "chain")})
    @SkipValidation
    public String listarEvento(){
        if(Utils.checkLogin()){
        	try {
				this.setEventos(eventoDao.listar());
			} catch (Exception e) {
				e.printStackTrace();
				return "input";
			}
        	return "exito";
        }
        else{
        	addFieldError("nologed", "Autentiquese para utilizar la pagina");
        	return "nologed";
        }
    }
    
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

    public List<Evento> getEventos() {
        return eventos;
    }
    public void setEventos(List<Evento> eventos) {
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
}
