package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axel on 22/11/2014.
 */
@Entity
@Table
public class Viaje extends AbstractEntity{

//    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(length = 1023)
    private String descripcion;
    @Column(nullable = false)
    private Time horaSalida;
    @Column
    private Time horaVuelta;
    @Column(nullable = false)
    private Integer lugares;
    @Column
    private Date dia;
    @ManyToOne(optional = false)
    private Recorrido recorrido;

    @OneToMany(mappedBy="calificado")
    private List<CalificacionRecorrido> calificaciones= new ArrayList<CalificacionRecorrido>();
    @ManyToMany
    private List<Usuario> viajeros = new ArrayList<Usuario>();

//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
    public Recorrido getRecorrido() {
        return recorrido;
    }
    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
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
    public Time getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }
    public Time getHoraVuelta() {
        return horaVuelta;
    }
    public void setHoraVuelta(Time horaVuelta) {
        this.horaVuelta = horaVuelta;
    }
    public Integer getLugares() {
        return lugares;
    }
    public void setLugares(Integer lugares) {
        this.lugares = lugares;
    }
    public Date getDia() {
        return dia;
    }
    public void setDia(Date dia) {
        this.dia = dia;
    }
    public List<CalificacionRecorrido> getCalificaciones() {
        return calificaciones;
    }
    public void setCalificaciones(List<CalificacionRecorrido> calificaciones) {
        this.calificaciones = calificaciones;
    }
    public List<Usuario> getViajeros() {
        return viajeros;
    }
    public void setViajeros(List<Usuario> viajeros) {
        this.viajeros = viajeros;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Viaje)) return false;
//
//        Viaje viaje = (Viaje) o;
//
//        if (id != null ? !id.equals(viaje.id) : viaje.id != null) return false;
//
//        return true;
//    }
}
