package unlp.ttpsInfoPoolCBR.actions;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.evento.IEventoDao;
import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.model.TipoViaje;
import unlp.ttpsInfoPoolCBR.model.TramoViaje;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.SessionUtils;
import unlp.ttpsInfoPoolCBR.vo.EventoVo;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;



@Action(value = "recorridoNuevo")
public class RecorridoNuevoAction extends ActionSupport{

    private static final long serialVersionUID = 1L;

    @Autowired
    private IRecorridoDao recorridoDao;    
    
    @Autowired
    private IEventoDao eventoDao;
    
     @Autowired
     private IUsuarioDao usuarioDao;

    //Variables entrada
    private String nombre;
    private String destino;
    private Integer evento;
    private String frecuencia;
    private List<String> dias = new ArrayList<String>();
    private String fecha;
    private String idaOVuelta;
    private String partida;
    private String regreso;
    private Integer asientos;
    private Double precio;
    
    private String start;
    private String end;
    private List<String> waypoints = new ArrayList<String>();
    
    //Variables
    private Date fechaActual;
    private List<EventoVo> eventos = new ArrayList<EventoVo>();

    @Action(value="recorridoNuevoInit", results={
            @Result(name = "exito", location="/viajero/nuevoRecorrido.jsp"),
            @Result(name = "nologed", location = "index", type = "chain")})
    @SkipValidation
    public String recorridoNuevoInit(){
    	EntityManager em = null;
    	if(SessionUtils.checkLogin()){
    		Calendar cal = Calendar.getInstance();
    		this.fechaActual = new Date(cal.getTimeInMillis());
    		
    		eventos = null;
    		try {
    			em = EntityManagerFactoryHolder.getEntityManager();
				eventos = eventoDao.getAll(em);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				em.close();
			}
    		return "exito";
    	}
    	else{
    		addFieldError("nologed", "Autentiquese para utilizar la pagina");
    		return "nologed";
    	}
    }

    @Action(value="recorridoNuevoAgregar", results={
            @Result(name = "input", location = "recorridoNuevoInit", type = "chain"),
            @Result(name = "exito", location = "misRecorridos", type = "chain"),
            @Result(name = "nologed", location = "index", type = "chain")})
    public String recorridoNuevoAgregar(){
    	EntityManager em = null;
        if(SessionUtils.checkLogin()){
        	EventoVo evento = null;
        	if(this.getDestino().equals("facultad")){
        		this.setEvento(0);
        	}
        	else{
        		//es "evento"
        		try {
        			em = EntityManagerFactoryHolder.getEntityManager();
					evento = eventoDao.encontrar(em,this.getEvento());
				} catch (Exception e) {
					e.printStackTrace();
					em.close();
					return "input";
				}
        	}
        	
        	TipoViaje tipoViaje = null;
        	List<String> dias = null;
        	java.sql.Date fecha = null;
        	if(evento == null){
            	switch(this.getFrecuencia()){
        		case "periodico":
        			tipoViaje = TipoViaje.PERIODICO;
        			dias = this.getDias();
        			break;
        			
        		case "puntual":
        			tipoViaje = TipoViaje.PUNTUAL;
        			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					try {
						java.util.Date aux = formatter.parse(this.getFecha()); 
						fecha = new java.sql.Date(aux.getTime());
					} catch (ParseException e) {
						e.printStackTrace();
						return "input";
					}
        			break;
        			
        		case "diario":
        			tipoViaje = TipoViaje.DIARIO;
        			break;
            	}
        	}
        	else{
        		tipoViaje = TipoViaje.PUNTUAL;
        		java.util.Date aux = evento.getFecha();
        		fecha = new java.sql.Date(aux.getTime());
        	}
        	
        	TramoViaje tramoViaje = null;
        	Time partida = null;
        	Time regreso = null;
        	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        	switch(this.getIdaOVuelta()){
        		case "ida":
        			tramoViaje = TramoViaje.IDA;
					try {
						partida = new Time(formatter.parse(this.getPartida()).getTime());
					} catch (ParseException e) {
						e.printStackTrace();
						return "input";
					}
        			break;

        		case "vuelta":
					try {
						regreso = new Time(formatter.parse(this.getRegreso()).getTime());
					} catch (ParseException e) {
						e.printStackTrace();
						return "input";
					}
        			tramoViaje = TramoViaje.VUELTA;
        			break;
        		
        		case "idaYVuelta":
					try {
						partida = new Time(formatter.parse(this.getPartida()).getTime());
						regreso = new Time(formatter.parse(this.getRegreso()).getTime());
					} catch (ParseException e) {
						e.printStackTrace();
						return "input";
					}
        			tramoViaje = TramoViaje.IDAYVUELTA;
        			break;
        	}
        	
        	HttpSession session = ServletActionContext.getRequest().getSession(false);
        	UsuarioVo usuario = (UsuarioVo) session.getAttribute("usuario");
        	
        	RecorridoVo recorrido = new RecorridoVo(
        							this.getNombre(), 
        							evento, 
        							this.getWaypoints(), 
        							this.getStart(),
        							this.getEnd(), 
        							tramoViaje, 
        							partida,
        							regreso,
        							this.getAsientos(),
        							tipoViaje,
        							fecha,
        							dias,
        							this.getPrecio(),
        							null,
        							usuario,
        							null,
        							null);
        	try {
        		EntityManagerFactoryHolder.beginTransaction(em);
				recorrido = recorridoDao.guardar(em,recorrido);
				EntityManagerFactoryHolder.commitTransaction(em);
			} catch (Exception e) {
				EntityManagerFactoryHolder.rollbackTransaction(em);
				e.printStackTrace();
				return "input";
			}
        	
        	/*try{
        		usuario = usuarioDao.traerMisRecorridos(usuario);
        		usuario.agregarRecorridosMios(recorrido);
        		usuario = usuarioDao.guardar(usuario);
        	}
        	catch(Exception e){
        		e.printStackTrace();
        		return "input";
        	}*/
        	/*if(evento != null){
        		try {
        			evento = eventoDao.cargarRecorridos(evento);
        			evento.agregarRecorrido(recorrido);
					eventoDao.guardar(evento);
				} catch (Exception e) {
					e.printStackTrace();
					return "input";
				}
        	}*/
        	
        	return "exito";
        }
        else{
    		addFieldError("nologed", "Autentiquese para utilizar la pagina");
    		return "nologed";        	
        }
    }
    
    @Override
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

	public List<EventoVo> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoVo> eventos) {
		this.eventos = eventos;
	}

}
