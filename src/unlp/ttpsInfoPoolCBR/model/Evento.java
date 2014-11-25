package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 05/11/14.
 */
@Entity
@Table
public class Evento extends AbstractEntity{

    @Column(nullable = false)
    private String nombre;
    
    @Column(length = 1023)
    private String descripcion;
    
    @Column(nullable = false)
    private Date fecha;
    
    @Column
    private Time horaComienzo;
    
    @Column
    private Time horaFin;

    @OneToMany(mappedBy="evento")
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
}