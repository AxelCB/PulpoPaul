package unlp.ttpsInfoPoolCBR.actions;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.util.Utils;

import com.opensymphony.xwork2.ActionSupport;



@Action(value = "recorridoNuevo")
public class RecorridoNuevoAction extends ActionSupport{

    private static final long serialVersionUID = 1L;

    @Autowired
    IRecorridoDao recorridoDao;

    //Variables entrada
    private String nombre;
    private String destino;
    private Integer evento;
    private String frecuencia;
    private List<String> dias;
    private String fecha;
    private String idaOVuelta;
    private String partida;
    private String regreso;
    private Integer asientos;
    private Double precio;
    
    private String start;
    private String end;
    private List<String> waypoints;
    
    //Variables
    private Date fechaActual;

    @Action(value="recorridoNuevoInit", results={
            @Result(name="exito", location="/viajero/nuevoRecorrido.jsp"),
            @Result(name = "nologed",location = "index",type = "chain")})
    @SkipValidation
    public String guardarEvento(){
    	if(Utils.checkLogin()){
    		Calendar cal = Calendar.getInstance();
    		//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    		//this.fechaActual = dateFormat.format(cal.getTime());
    		this.fechaActual = new Date(cal.getTimeInMillis());
    		return "exito";
    	}
    	else{
    		addFieldError("nologed", "Autentiquese para utilizar la pagina");
    		return "nologed";
    	}
    }

    @Action(value="recorridoNuevoAgregar", results={
            @Result(name="input", location="/viajero/nuevoRecorrido.jsp"),
            @Result(name="exito", location="/viajero/misRecorridos.jsp"),
            @Result(name ="nologed",location = "index",type = "chain")})
    public String listarEvento(){
        if(Utils.checkLogin()){
        
        	return "exito";
        }
        else{
    		addFieldError("nologed", "Autentiquese para utilizar la pagina");
    		return "nologed";        	
        }
    }
    
    public void validate(){
        System.out.println("nombre: " + this.getNombre());
        System.out.println("destino: " + this.getDestino());
        System.out.println("evento: " + this.getEvento());
        System.out.println("frecuencia: " + this.getFrecuencia());
        System.out.println("dias: " + this.getDias());
        System.out.println("fecha: " + this.getFecha());
        System.out.println("idaovuelta: " + this.getIdaOVuelta());
        System.out.println("partida: " + this.getPartida());
        System.out.println("regreso: " + this.getRegreso());
        System.out.println("asientos: " + this.getAsientos());
        System.out.println("precio: " + this.getPrecio());
        
        System.out.println("start: " + this.getStart());
        System.out.println("end: " + this.getEnd());
        System.out.println("waypoints: " + this.getWaypoints());
        addFieldError("as", "as");
    }

    //Getters y Setters
	public IRecorridoDao getRecorridoDao() {
		return recorridoDao;
	}

	public void setRecorridoDao(IRecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getEvento() {
		return evento;
	}

	public void setEvento(Integer evento) {
		this.evento = evento;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public List<String> getDias() {
		return dias;
	}

	public void setDias(List<String> dias) {
		this.dias = dias;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdaOVuelta() {
		return idaOVuelta;
	}

	public void setIdaOVuelta(String idaOVuelta) {
		this.idaOVuelta = idaOVuelta;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getRegreso() {
		return regreso;
	}

	public void setRegreso(String regreso) {
		this.regreso = regreso;
	}

	public Integer getAsientos() {
		return asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<String> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<String> waypoints) {
		this.waypoints = waypoints;
	}

}
