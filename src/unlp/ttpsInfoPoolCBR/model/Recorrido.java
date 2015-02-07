package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 05/11/14.
 */
@Entity
@Table
public class Recorrido extends AbstractEntity{

    private static final long serialVersionUID = -7094909164595425984L;

    @Column(nullable = false,
    		unique = true)
    private String nombre;
    
    @ManyToOne(optional = true)
    private Evento evento;
    
    @ElementCollection
    @CollectionTable
    private List<String> puntos = new ArrayList<String>();
    
    @Column
    private String inicio;
    
    @Column
    private String fin;
    
    @Column(nullable = false)
    private TramoViaje tramo;
    
    @Column
    private Time horaSalida;
    
    @Column
    private Time horaVuelta;
    
    @Column(nullable = false)
    private Integer lugares;
    
    @Column(nullable = false)
    private TipoViaje tipo;
    
    @Column
    private Date puntual;

    @ElementCollection
    @CollectionTable
    private List<String> dias = new ArrayList<String>();
    
    @Column(nullable = false)
    private Double precio;
    
    @OneToMany(mappedBy="recorrido"/*, cascade=CascadeType.ALL*/)
    private List<Viaje> viajes = new ArrayList<Viaje>();
    
    @ManyToOne(optional = false)
    private Usuario propietario;
    
    @ManyToMany(mappedBy="recorridosViajo",
    			fetch = FetchType.EAGER,
    			cascade={CascadeType.PERSIST,CascadeType.MERGE})
    private List<Usuario> pasajeros = new ArrayList<Usuario>();
    
    @ManyToMany(mappedBy="historial")
    		//,
    			//fetch = FetchType.EAGER)
    private List<Usuario> pasajerosHistorial = new ArrayList<Usuario>();

    public Recorrido(String nombre, Evento evento, List<String> puntos,
			String inicio, String fin, TramoViaje tramo, Time horaSalida,
			Time horaVuelta, Integer lugares, TipoViaje tipo, Date puntual,
			List<String> dias, Double precio, List<Viaje> viajes,
			Usuario propietario, List<Usuario> pasajeros,
			List<Usuario> pasajerosHistorial) {
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

	public Recorrido(){
    	super();
    }

    public Usuario agregarPasajero(Usuario usuario){
    	this.pasajeros.add(usuario);
    	return usuario;
    }
    
    public Boolean eliminarPasajero(Usuario usuario){
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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

    public List<Viaje> getViajes() {
        return viajes;
    }
	
	public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

	public List<Usuario> getPasajerosHistorial() {
		return pasajerosHistorial;
	}

	public void setPasajerosHistorial(List<Usuario> pasajerosHistorial) {
		this.pasajerosHistorial = pasajerosHistorial;
	}
    

}
