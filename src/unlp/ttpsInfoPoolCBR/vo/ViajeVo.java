package unlp.ttpsInfoPoolCBR.vo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axel on 22/11/2014.
 */
public class ViajeVo extends AbstractVo{

    private static final long serialVersionUID = 6117161171462567210L;

    private String nombre;
    private String descripcion;
    private Time horaSalida;
    private Time horaVuelta;
    private Integer lugares;
    private Date dia;
    private RecorridoVo recorrido;
    private List<CalificacionRecorridoVo> calificaciones= new ArrayList<CalificacionRecorridoVo>();
    private List<UsuarioVo> viajeros = new ArrayList<UsuarioVo>();

    public ViajeVo(){
    	super();
    }
    
    public ViajeVo(RecorridoVo recorrido, String descripcion, Date dia){
    	super();
    	this.setDescripcion(descripcion);
        this.setNombre(recorrido.getNombre());
        this.setHoraSalida(recorrido.getHoraSalida());
        this.setHoraVuelta(recorrido.getHoraVuelta());
        this.setLugares(recorrido.getLugares());
        this.setDia(dia);
//        this.setViajeros(recorrido.getPasajeros());
        this.setRecorrido(recorrido);
    }
    
    public ViajeVo(String nombre, String descripcion, Time horaSalida,
			Integer lugares, Date dia, RecorridoVo recorrido,
			List<UsuarioVo> viajeros) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horaSalida = horaSalida;
		this.lugares = lugares;
		this.dia = dia;
		this.recorrido = recorrido;
		this.viajeros = viajeros;
	}

	public RecorridoVo getRecorrido() {
        return recorrido;
    }
    public void setRecorrido(RecorridoVo recorrido) {
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
    public List<CalificacionRecorridoVo> getCalificaciones() {
        return calificaciones;
    }
    public void setCalificaciones(List<CalificacionRecorridoVo> calificaciones) {
        this.calificaciones = calificaciones;
    }
    public List<UsuarioVo> getViajeros() {
        return viajeros;
    }
    public void setViajeros(List<UsuarioVo> viajeros) {
        this.viajeros = viajeros;
    }

}
