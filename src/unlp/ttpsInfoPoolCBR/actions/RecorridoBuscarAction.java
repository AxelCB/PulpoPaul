package unlp.ttpsInfoPoolCBR.actions;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.model.Evento;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
import unlp.ttpsInfoPoolCBR.model.TipoViaje;
import unlp.ttpsInfoPoolCBR.model.TramoViaje;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.util.Utils;

import com.opensymphony.xwork2.ActionSupport;



@Action(value = "buscarRecorrido")
public class RecorridoBuscarAction extends ActionSupport{

//    private static final long serialVersionUID = 1L;
//
//    @Autowired
//    IRecorridoDao recorridoDao;    
//    
//    private Integer idRecorrido;
//
//    //Variables
//    private Date fechaActual;
//    private List<Evento> eventos;
//
//    @Action(value="recorridoNuevoInit", results={
//            @Result(name = "exito", location="/viajero/nuevoRecorrido.jsp"),
//            @Result(name = "nologed", location = "index", type = "chain")})
//    @SkipValidation
//    public String recorridoNuevoInit(){
//    	if(Utils.checkLogin()){
//    		Calendar cal = Calendar.getInstance();
//    		this.fechaActual = new Date(cal.getTimeInMillis());
//    		
//    		eventos = null;
//    		try {
////				eventos = eventoDao.getAll();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//    		
//    		
//    		return "exito";
//    	}
//    	else{
//    		addFieldError("nologed", "Autentiquese para utilizar la pagina");
//    		return "nologed";
//    	}
//    }
//
//    @Action(value="recorridoNuevoAgregar", results={
//            @Result(name = "input", location = "recorridoNuevoInit", type = "chain"),
//            @Result(name = "exito", location = "/viajero/misRecorridos.jsp"),
//            @Result(name = "nologed", location = "index", type = "chain")})
//    public String recorridoNuevoAgregar(){
//        if(Utils.checkLogin()){
//        	
//        	Evento evento = null;
//        	if(this.getDestino().equals("facultad")){
//        		this.setEvento(0);
//        	}
//        	else{
//        		//es "evento"
//        		try {
//					evento = eventoDao.encontrar(this.getEvento());
//				} catch (Exception e) {
//					e.printStackTrace();
//					return "input";
//				}
//        	}
//        	
//        	TipoViaje tipoViaje = null;
//        	List<String> dias = null;
//        	java.sql.Date fecha = null;
//        	if(evento == null){
//            	switch(this.getFrecuencia()){
//        		case "periodico":
//        			tipoViaje = TipoViaje.PERIODICO;
//        			dias = this.getDias();
//        			break;
//        			
//        		case "puntual":
//        			tipoViaje = TipoViaje.PUNTUAL;
//        			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//					try {
//						java.util.Date aux = (java.util.Date) formatter.parse(this.getFecha()); 
//						fecha = new java.sql.Date(aux.getTime());
//					} catch (ParseException e) {
//						e.printStackTrace();
//						return "input";
//					}
//        			break;
//        			
//        		case "diario":
//        			tipoViaje = TipoViaje.DIARIO;
//        			break;
//            	}
//        	}
//        	else{
//        		tipoViaje = TipoViaje.PUNTUAL;
//        		fecha = (Date) evento.getFecha();
//        	}
//        	
//        	TramoViaje tramoViaje = null;
//        	Time partida = null;
//        	Time regreso = null;
//        	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
//        	switch(this.getIdaOVuelta()){
//        		case "ida":
//        			tramoViaje = TramoViaje.IDA;
//					try {
//						partida = new Time(formatter.parse(this.getPartida()).getTime());
//					} catch (ParseException e) {
//						e.printStackTrace();
//						return "input";
//					}
//        			break;
//
//        		case "vuelta":
//					try {
//						regreso = new Time(formatter.parse(this.getRegreso()).getTime());
//					} catch (ParseException e) {
//						e.printStackTrace();
//						return "input";
//					}
//        			tramoViaje = TramoViaje.VUELTA;
//        			break;
//        		
//        		case "idaYVuelta":
//					try {
//						partida = new Time(formatter.parse(this.getPartida()).getTime());
//						regreso = new Time(formatter.parse(this.getRegreso()).getTime());
//					} catch (ParseException e) {
//						e.printStackTrace();
//						return "input";
//					}
//        			tramoViaje = TramoViaje.IDAYVUELTA;
//        			break;
//        	}
//        	
//        	HttpSession session = ServletActionContext.getRequest().getSession(false);
//        	Usuario usuario = (Usuario) session.getAttribute("usuario");
//        	
//        	Recorrido recorrido = new Recorrido(
//        							this.getNombre(), 
//        							evento, 
//        							this.getWaypoints(), 
//        							this.getStart(),
//        							this.getEnd(), 
//        							tramoViaje, 
//        							partida,
//        							regreso,
//        							this.getAsientos(),
//        							tipoViaje,
//        							fecha,
//        							dias,
//        							this.getPrecio(),
//        							null,
//        							usuario,
//        							null,
//        							null);
//	        
//        	try {
//				recorrido = recorridoDao.guardar(recorrido);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return "input";
//			}
//        	if(evento != null){
//        		evento.agregarRecorrido(recorrido);
//        		try {
//					eventoDao.guardar(evento);
//				} catch (Exception e) {
//					e.printStackTrace();
//					return "input";
//				}
//        	}
//        	
//        	return "exito";
//        }
//        else{
//    		addFieldError("nologed", "Autentiquese para utilizar la pagina");
//    		return "nologed";        	
//        }
//    }
//    
//    public void validate(){
//        System.out.println("nombre: " + this.getNombre());
//        
//        System.out.println("destino: " + this.getDestino());
//		System.out.println("evento: " + this.getEvento());
//		
//        System.out.println("frecuencia: " + this.getFrecuencia());
//        System.out.println("dias: " + this.getDias());
//        System.out.println("fecha: " + this.getFecha());
//        
//        System.out.println("idaovuelta: " + this.getIdaOVuelta());
//        System.out.println("partida: " + this.getPartida());
//        System.out.println("regreso: " + this.getRegreso());
//        
//        System.out.println("asientos: " + this.getAsientos());
//        
//        System.out.println("precio: " + this.getPrecio());
//        
//        System.out.println("start: " + this.getStart());
//        System.out.println("end: " + this.getEnd());
//        System.out.println("waypoints: " + this.getWaypoints());
//    }
//
//    //Getters y Setters
//	public IRecorridoDao getRecorridoDao() {
//		return recorridoDao;
//	}
//
//	public void setRecorridoDao(IRecorridoDao recorridoDao) {
//		this.recorridoDao = recorridoDao;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public String getDestino() {
//		return destino;
//	}
//
//	public void setDestino(String destino) {
//		this.destino = destino;
//	}
//
//	public Integer getEvento() {
//		return evento;
//	}
//
//	public void setEvento(Integer evento) {
//		this.evento = evento;
//	}
//
//	public String getFrecuencia() {
//		return frecuencia;
//	}
//
//	public void setFrecuencia(String frecuencia) {
//		this.frecuencia = frecuencia;
//	}
//
//	public List<String> getDias() {
//		return dias;
//	}
//
//	public void setDias(List<String> dias) {
//		this.dias = dias;
//	}
//
//	public String getFecha() {
//		return fecha;
//	}
//
//	public void setFecha(String fecha) {
//		this.fecha = fecha;
//	}
//
//	public String getIdaOVuelta() {
//		return idaOVuelta;
//	}
//
//	public void setIdaOVuelta(String idaOVuelta) {
//		this.idaOVuelta = idaOVuelta;
//	}
//
//	public String getPartida() {
//		return partida;
//	}
//
//	public void setPartida(String partida) {
//		this.partida = partida;
//	}
//
//	public String getRegreso() {
//		return regreso;
//	}
//
//	public void setRegreso(String regreso) {
//		this.regreso = regreso;
//	}
//
//	public Integer getAsientos() {
//		return asientos;
//	}
//
//	public void setAsientos(Integer asientos) {
//		this.asientos = asientos;
//	}
//
//	public Double getPrecio() {
//		return precio;
//	}
//
//	public void setPrecio(Double precio) {
//		this.precio = precio;
//	}
//
//	public Date getFechaActual() {
//		return fechaActual;
//	}
//
//	public void setFechaActual(Date fechaActual) {
//		this.fechaActual = fechaActual;
//	}
//
//	public String getStart() {
//		return start;
//	}
//
//	public void setStart(String start) {
//		this.start = start;
//	}
//
//	public String getEnd() {
//		return end;
//	}
//
//	public void setEnd(String end) {
//		this.end = end;
//	}
//
//	public List<String> getWaypoints() {
//		return waypoints;
//	}
//
//	public void setWaypoints(List<String> waypoints) {
//		this.waypoints = waypoints;
//	}
//
//	public List<Evento> getEventos() {
//		return eventos;
//	}
//
//	public void setEventos(List<Evento> eventos) {
//		this.eventos = eventos;
//	}

}
