package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by axel on 05/11/14.
 */
@Entity
@Table
public class Evento extends AbstractEntity{

    private static final long serialVersionUID = 8431112769010964265L;

    @Column(nullable = false)
    private String nombre;
    
    @Column(length = 1023)
    private String descripcion;

    @Column(length = 1023)
    private String lugar;
    
    @Column(nullable = false)
    private Date fecha = new Date();
    
    @Column
    private Time horaComienzo;
    
    @Column
    private Time horaFin;
    
    @Column(nullable = false)
    private String latLng;

    @OneToMany(	mappedBy="evento",
    			cascade = CascadeType.ALL)
    private List<Recorrido> recorridos = new ArrayList<Recorrido>();

    public Evento(){
    	super();
    }
    
    public Evento(String nombre, String descripcion, Date fecha,
			Time horaComienzo, Time horaFin) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaFin;
	}
    
    public Recorrido agregarRecorrido(Recorrido recorrido){
    	this.recorridos.add(recorrido);
    	return recorrido;
    }
    
    public Boolean eliminarRecorrido(Recorrido recorrido){
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

    public List<Recorrido> getRecorridos() {
        return recorridos;
    }

    public void setRecorridos(List<Recorrido> recorridos) {
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
