package unlp.ttpsInfoPoolCBR.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import unlp.ttpsInfoPoolCBR.dao.evento.IEventoDao;
import unlp.ttpsInfoPoolCBR.model.Evento;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Axel on 19/12/2014.
 */

@Action(value = "eventos")
public class EventoAction {

    private static final long serialVersionUID = 1L;

    /**
     * Evento DAO
     */
    @Autowired
    IEventoDao eventoDao;

    private List<Evento> eventos = new ArrayList<Evento>();
    private String operacion = "";

    //Entrada agregar usuario
    private String nombre;
    private String lugar;
    private String descripcion;
    private Date fecha;
    private Time horaComienzo;
    private Time horaFin;
    private String longitud;
    private String latitud;

    @Action(value="guardar", results={
            @Result(name="exito", location="/admin/abmEventos.jsp"),
            @Result(name="input", location="/admin/abmEventos.jsp")})
    public String guardarEvento(){
        try{
            Evento evento = new Evento();
            evento.setNombre(this.getNombre());
            evento.setDescripcion(this.getDescripcion());
            /*evento.setFecha(this.getFecha());
            evento.setHoraComienzo(this.getHoraComienzo());
            evento.setHoraFin(this.getHoraFin());*/
            evento.setLatitud(Double.parseDouble(this.getLatitud()));
            evento.setLongitud(Double.parseDouble(this.getLongitud()));

            eventoDao.guardar(evento);
        }catch(Exception e){
            e.printStackTrace();
            return "input";
        }
        return "";
    }

    @Action(value="listar", results={
            @Result(name="input", location="/admin/abmEventos.jsp"),
            @Result(name="exito", location="/admin/abmEventos.jsp")})
    public String listarEvento(){
        try {
//            if(this.getOperacion()==null || this.getOperacion()==""){
                this.setEventos(eventoDao.listar());
//            }
        } catch (Exception e) {
            e.printStackTrace();
            return "input";
        }
        return "exito";
    }
    public List<Evento> getEventos() {
        return eventos;
    }
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    public String getOperacion() {
        return operacion;
    }
    public void setOperacion(String operacion) {
        this.operacion = operacion;
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
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Time getHoraComienzo() {
        return horaComienzo;
    }
    public void setHoraComienzo(Time horaComienzo) {
        this.horaComienzo = horaComienzo;
    }
    public Time getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
}
