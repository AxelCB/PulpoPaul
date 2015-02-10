package unlp.ttpsInfoPoolCBR.vo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by axel on 05/11/14.
 */
public class EventoVo extends AbstractVo{

    private static final long serialVersionUID = 8431112769010964265L;
    
    private String nombre;
    private String descripcion;
    private String lugar;
    private Date fecha = new Date();
    private Time horaComienzo;
    private Time horaFin;
    private String latLng;
    private List<RecorridoVo> recorridos = new ArrayList<RecorridoVo>();

    public EventoVo(){
    	super();
    }
    
    public EventoVo(String nombre, String descripcion, Date fecha,
			Time horaComienzo, Time horaFin) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaFin;
	}
    
    public RecorridoVo agregarRecorrido(RecorridoVo recorrido){
    	this.recorridos.add(recorrido);
    	return recorrido;
    }
    
    public Boolean eliminarRecorrido(RecorridoVo recorrido){
    	return this.recorridos.remove(recorrido);
    }

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<RecorridoVo> getRecorridos() {
        return recorridos;
    }

    public void setRecorridos(List<RecorridoVo> recorridos) {
        this.recorridos = recorridos;
    }

    public String getLatLng() {
		return latLng;
	}

	public void setLatLng(String latLng) {
		this.latLng = latLng;
	}

	public String getLugar() {return lugar;}

    public void setLugar(String lugar) {this.lugar = lugar;}
}
