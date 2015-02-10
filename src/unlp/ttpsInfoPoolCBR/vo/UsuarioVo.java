package unlp.ttpsInfoPoolCBR.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 10/02/15.
 */
public class UsuarioVo extends AbstractVo{

	private static final long serialVersionUID = -546176547448337929L;
	
	private String nombres;
    private String apellido;
    private Integer telefono;
    private String email;
    private String clave;
    private byte [] foto=null;
    private RolVo rol;
    private List<CalificacionUsuarioVo> misCalificaciones = new ArrayList<CalificacionUsuarioVo>();
    private List<CalificacionUsuarioVo> calificacionesHechas = new ArrayList<CalificacionUsuarioVo>();
    private List<CalificacionRecorridoVo> recorridosCalificados = new ArrayList<CalificacionRecorridoVo>();
    private List<DenunciaVo> misDenuncias = new ArrayList<DenunciaVo>();
    private List<DenunciaVo> denunciasHechas = new ArrayList<DenunciaVo>();
    private List<MensajeVo> bandejaEntrada = new ArrayList<MensajeVo>();
    private List<MensajeVo> bandejaSalida = new ArrayList<MensajeVo>();
    private List<RecorridoVo> recorridosMios = new ArrayList<RecorridoVo>();
    private List<RecorridoVo> recorridosViajo = new ArrayList<RecorridoVo>();
    private List<RecorridoVo> historial = new ArrayList<RecorridoVo>();
    private List<ViajeVo> misViajes = new ArrayList<ViajeVo>();

    public UsuarioVo(){
        super();
    }

    public UsuarioVo(String nombres, String apellido, Integer telefono, String email, String clave, RolVo rol, byte [] foto) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        this.rol = rol;
        this.foto = foto;
    }

    public RecorridoVo agregarRecorridoViajo(RecorridoVo recorrido){
    	this.recorridosViajo.add(recorrido);
    	return recorrido;
    }
    
    public Boolean eliminarRecorridoViajo(RecorridoVo recorrido){
    	return this.recorridosViajo.remove(recorrido);
    }
    
    public ViajeVo agregarViaje(ViajeVo viaje){
    	this.misViajes.add(viaje);
    	return(viaje);
    }
    
    public Boolean eliminarViaje(ViajeVo viaje){
    	return this.misViajes.remove(viaje);
    }
    
    public RecorridoVo agregarRecorridosMios(RecorridoVo recorrido){
    	this.getRecorridosMios().add(recorrido);
    	return recorrido;
    }
    
    public MensajeVo agregarBandejaEntrada(MensajeVo mensaje){
    	this.getBandejaEntrada().add(mensaje);
    	return mensaje;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public RolVo getRol() {
        return rol;
    }

    public void setRol(RolVo rol) {
        this.rol = rol;
    }

    public List<CalificacionUsuarioVo> getMisCalificaciones() {
        return misCalificaciones;
    }

    public void setMisCalificaciones(List<CalificacionUsuarioVo> misCalificaciones) {
        this.misCalificaciones = misCalificaciones;
    }

    public List<CalificacionUsuarioVo> getCalificacionesHechas() {
        return calificacionesHechas;
    }

    public void setCalificacionesHechas(List<CalificacionUsuarioVo> calificacionesHechas) {
        this.calificacionesHechas = calificacionesHechas;
    }

    public List<DenunciaVo> getMisDenuncias() {
        return misDenuncias;
    }

    public void setMisDenuncias(List<DenunciaVo> misDenuncias) {
        this.misDenuncias = misDenuncias;
    }

    public List<DenunciaVo> getDenunciasHechas() {
        return denunciasHechas;
    }

    public void setDenunciasHechas(List<DenunciaVo> denunciasHechas) {
        this.denunciasHechas = denunciasHechas;
    }

    public List<MensajeVo> getBandejaEntrada() {
        return bandejaEntrada;
    }

    public void setBandejaEntrada(List<MensajeVo> bandejaEntrada) {
        this.bandejaEntrada = bandejaEntrada;
    }

    public List<MensajeVo> getBandejaSalida() {
        return bandejaSalida;
    }

    public void setBandejaSalida(List<MensajeVo> bandejaSalida) {
        this.bandejaSalida = bandejaSalida;
    }

    public byte [] getFoto() {
        return foto;
    }

    public void setFoto(byte [] foto) {
        this.foto = foto;
    }

    public List<CalificacionRecorridoVo> getRecorridosCalificados(){
        return recorridosCalificados;
    }
    public void setRecorridosCalificados(List<CalificacionRecorridoVo> recorridosCalificados){
        this.recorridosCalificados=recorridosCalificados;
    }

    public List<ViajeVo> getMisViajes(){
        return misViajes;
    }
    public void setMisViajes(List<ViajeVo> misViajes){
        this.misViajes = misViajes;
    }

    public List<RecorridoVo> getRecorridosMios(){
        return recorridosMios;
    }
    public void setRecorridosMios(List<RecorridoVo> recorridosMios){
        this.recorridosMios = recorridosMios;
    }

    public List<RecorridoVo> getRecorridosViajo(){
        return recorridosViajo;
    }
    public void setRecorridosViajo(List<RecorridoVo> recorridosViajo){
        this.recorridosViajo = recorridosViajo;
    }

    public List<RecorridoVo> getHistorial(){
        return historial;
    }
    public void setHistorial(List<RecorridoVo> historial){
        this.historial = historial;
    }
}
