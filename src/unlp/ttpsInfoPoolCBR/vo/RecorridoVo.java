package unlp.ttpsInfoPoolCBR.vo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import unlp.ttpsInfoPoolCBR.model.TipoViaje;
import unlp.ttpsInfoPoolCBR.model.TramoViaje;

/**
 * Created by axel on 05/11/14.
 */
public class RecorridoVo extends AbstractVo{

    private static final long serialVersionUID = -7094909164595425984L;
    
    private String nombre;
    private EventoVo evento;
    private List<String> puntos = new ArrayList<String>();
    private String inicio;
    private String fin;
    private TramoViaje tramo;
    private Time horaSalida;
    private Time horaVuelta;
    private Integer lugares;
    private TipoViaje tipo;
    private Date puntual;
    private List<String> dias = new ArrayList<String>();
    private Double precio;
    private List<ViajeVo> viajes = new ArrayList<ViajeVo>();
    private UsuarioVo propietario;
    private List<UsuarioVo> pasajeros = new ArrayList<UsuarioVo>();
    private List<UsuarioVo> pasajerosHistorial = new ArrayList<UsuarioVo>();
    private List<CalificacionRecorridoVo> calificaciones= new ArrayList<CalificacionRecorridoVo>();

    public RecorridoVo(String nombre, EventoVo evento, List<String> puntos,
			String inicio, String fin, TramoViaje tramo, Time horaSalida,
			Time horaVuelta, Integer lugares, TipoViaje tipo, Date puntual,
			List<String> dias, Double precio, List<ViajeVo> viajes,
			UsuarioVo propietario, List<UsuarioVo> pasajeros,
			List<UsuarioVo> pasajerosHistorial) {
		super();
		this.nombre = nombre;
		this.evento = evento;
		this.puntos = puntos;
		this.inicio = inicio;
		this.fin = fin;
		this.tramo = tramo;
		this.horaSalida = horaSalida;
		this.horaVuelta = horaVuelta;
		this.lugares = lugares;
		this.tipo = tipo;
		this.puntual = puntual;
		this.dias = dias;
		this.precio = precio;
		this.viajes = viajes;
		this.propietario = propietario;
		this.pasajeros = pasajeros;
		this.pasajerosHistorial = pasajerosHistorial;
	}

	public RecorridoVo(){
    	super();
    }

    public UsuarioVo agregarPasajero(UsuarioVo usuario){
    	this.pasajeros.add(usuario);
    	return usuario;
    }
    
    public Boolean eliminarPasajero(UsuarioVo usuario){
    	return this.pasajeros.remove(usuario);
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

    public Date getPuntual() {
        return puntual;
    }

    public void setPuntual(Date puntual) {
        this.puntual = puntual;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
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

    public EventoVo getEvento() {
        return evento;
    }

    public void setEvento(EventoVo evento) {
        this.evento = evento;
    }

    public UsuarioVo getPropietario() {
        return propietario;
    }

    public void setPropietario(UsuarioVo propietario) {
        this.propietario = propietario;
    }

    public List<UsuarioVo> getPasajeros() {
        return pasajeros;
    }
    
    public void setPasajeros(List<UsuarioVo> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public List<String> getPuntos() {
		return puntos;
	}

	public void setPuntos(List<String> puntos) {
		this.puntos = puntos;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

    public List<ViajeVo> getViajes() {
        return viajes;
    }
	
	public void setViajes(List<ViajeVo> viajes) {
        this.viajes = viajes;
    }

	public List<UsuarioVo> getPasajerosHistorial() {
		return pasajerosHistorial;
	}

	public void setPasajerosHistorial(List<UsuarioVo> pasajerosHistorial) {
		this.pasajerosHistorial = pasajerosHistorial;
	}

	public TramoViaje getTramo() {
		return tramo;
	}

	public void setTramo(TramoViaje tramo) {
		this.tramo = tramo;
	}

	public List<CalificacionRecorridoVo> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<CalificacionRecorridoVo> calificaciones) {
		this.calificaciones = calificaciones;
	}

}
