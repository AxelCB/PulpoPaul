package unlp.ttpsInfoPoolCBR.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 05/11/14.
 */
public class Recorrido {

    private Long id;
    private String nombre;
    private Time horaSalida;
    private Time horaVuelta;
    private Integer lugares;
    private Boolean idaYVuelta;
    private Date puntual;
    private List<Integer> dias = new ArrayList<Integer>();
    private Double precio;
    private TipoViaje tipo;

    private Punto llegada;
    private Punto salida;
    private Evento evento;
    private List<CalificacionRecorrido> calificaciones = new ArrayList<CalificacionRecorrido>();
    private Usuario propietario;
    private List<Usuario> pasajeros = new ArrayList<Usuario>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recorrido)) return false;

        Recorrido recorrido = (Recorrido) o;

        if (id != null ? !id.equals(recorrido.id) : recorrido.id != null) return false;

        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Boolean getIdaYVuelta() {
        return idaYVuelta;
    }

    public void setIdaYVuelta(Boolean idaYVuelta) {
        this.idaYVuelta = idaYVuelta;
    }

    public Date getPuntual() {
        return puntual;
    }

    public void setPuntual(Date puntual) {
        this.puntual = puntual;
    }

    public List<Integer> getDias() {
        return dias;
    }

    public void setDias(List<Integer> dias) {
        this.dias = dias;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoViaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoViaje tipo) {
        this.tipo = tipo;
    }

    public Punto getLlegada() {
        return llegada;
    }

    public void setLlegada(Punto llegada) {
        this.llegada = llegada;
    }

    public Punto getSalida() {
        return salida;
    }

    public void setSalida(Punto salida) {
        this.salida = salida;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<CalificacionRecorrido> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionRecorrido> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public List<Usuario> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Usuario> pasajeros) {
        this.pasajeros = pasajeros;
    }
}
