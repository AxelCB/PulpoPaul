package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 05/11/14.
 */
@Entity
@Table
public class Usuario extends AbstractEntity{

    private static final long serialVersionUID = 6080622647831511977L;

    @Column(nullable = false)
    private String nombres;
    
    @Column(nullable = false)
    private String apellido;
    
    @Column
    private Integer telefono;
    
    @Column(nullable = false,
    		unique = true)
    private String email;
    
    @Column(nullable = false)
    private String clave;
    
    @Lob
    @Column(length = 16777215)
    private byte [] foto=null;

    @ManyToOne(optional = false)
    private Rol rol;
    
    @OneToMany(mappedBy = "calificado")
    private List<CalificacionUsuario> misCalificaciones = new ArrayList<CalificacionUsuario>();
    
    @OneToMany(mappedBy = "calificador")
    private List<CalificacionUsuario> calificacionesHechas = new ArrayList<CalificacionUsuario>();
    
    @OneToMany(mappedBy="calificador")
    private List<CalificacionRecorrido> recorridosCalificados = new ArrayList<CalificacionRecorrido>();
    
    @OneToMany(mappedBy="denunciado")
    private List<Denuncia> misDenuncias = new ArrayList<Denuncia>();
    
    @OneToMany(mappedBy="denunciante")
    private List<Denuncia> denunciasHechas = new ArrayList<Denuncia>();
    
    @OneToMany(mappedBy="receptor")
    private List<Mensaje> bandejaEntrada = new ArrayList<Mensaje>();
    
    @OneToMany(mappedBy="emisor")
    private List<Mensaje> bandejaSalida = new ArrayList<Mensaje>();

    @OneToMany(mappedBy="propietario")
    private List<Recorrido> recorridosMios = new ArrayList<Recorrido>();
    
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable( name="Usuario_Recorrido_Viajo",
    			joinColumns={@JoinColumn(name="usuario_id", nullable=false)},
    			inverseJoinColumns={@JoinColumn(name="recorrido_id", nullable=false)})
    private List<Recorrido> recorridosViajo = new ArrayList<Recorrido>();
    
    @ManyToMany
    @JoinTable( name="Usuario_Recorrido_Historial",
				joinColumns={@JoinColumn(name="usuario_id", nullable=false)},
				inverseJoinColumns={@JoinColumn(name="recorrido_id", nullable=false)})
    private List<Recorrido> historial = new ArrayList<Recorrido>();
    
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable( name="Usuario_Recorrido_Viajes",
				joinColumns={@JoinColumn(name="usuario_id", nullable=false)},
				inverseJoinColumns={@JoinColumn(name="viaje_id", nullable=false)})
    private List<Viaje> misViajes = new ArrayList<Viaje>();

    public Usuario(){
        super();
    }

    public Usuario(String nombres, String apellido, Integer telefono, String email, String clave, Rol rol, byte [] foto) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        this.rol = rol;
        this.foto = foto;
    }

    public Recorrido agregarRecorridoViajo(Recorrido recorrido){
    	this.recorridosViajo.add(recorrido);
    	return recorrido;
    }
    
    public Boolean eliminarRecorridoViajo(Recorrido recorrido){
    	return this.recorridosViajo.remove(recorrido);
    }
    
    public Viaje agregarViaje(Viaje viaje){
    	this.misViajes.add(viaje);
    	return(viaje);
    }
    
    public Boolean eliminarViaje(Viaje viaje){
    	return this.misViajes.remove(viaje);
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<CalificacionUsuario> getMisCalificaciones() {
        return misCalificaciones;
    }

    public void setMisCalificaciones(List<CalificacionUsuario> misCalificaciones) {
        this.misCalificaciones = misCalificaciones;
    }

    public List<CalificacionUsuario> getCalificacionesHechas() {
        return calificacionesHechas;
    }

    public void setCalificacionesHechas(List<CalificacionUsuario> calificacionesHechas) {
        this.calificacionesHechas = calificacionesHechas;
    }

    public List<Denuncia> getMisDenuncias() {
        return misDenuncias;
    }

    public void setMisDenuncias(List<Denuncia> misDenuncias) {
        this.misDenuncias = misDenuncias;
    }

    public List<Denuncia> getDenunciasHechas() {
        return denunciasHechas;
    }

    public void setDenunciasHechas(List<Denuncia> denunciasHechas) {
        this.denunciasHechas = denunciasHechas;
    }

    public List<Mensaje> getBandejaEntrada() {
        return bandejaEntrada;
    }

    public void setBandejaEntrada(List<Mensaje> bandejaEntrada) {
        this.bandejaEntrada = bandejaEntrada;
    }

    public List<Mensaje> getBandejaSalida() {
        return bandejaSalida;
    }

    public void setBandejaSalida(List<Mensaje> bandejaSalida) {
        this.bandejaSalida = bandejaSalida;
    }

    public byte [] getFoto() {
        return foto;
    }

    public void setFoto(byte [] foto) {
        this.foto = foto;
    }

    public List<CalificacionRecorrido> getRecorridosCalificados(){
        return recorridosCalificados;
    }
    public void setRecorridosCalificados(List<CalificacionRecorrido> recorridosCalificados){
        this.recorridosCalificados=recorridosCalificados;
    }

    public List<Viaje> getMisViajes(){
        return misViajes;
    }
    public void setMisViajes(List<Viaje> misViajes){
        this.misViajes = misViajes;
    }

    public List<Recorrido> getRecorridosMios(){
        return recorridosMios;
    }
    public void setRecorridosMios(List<Recorrido> recorridosMios){
        this.recorridosMios = recorridosMios;
    }

    public List<Recorrido> getRecorridosViajo(){
        return recorridosViajo;
    }
    public void setRecorridosViajo(List<Recorrido> recorridosViajo){
        this.recorridosViajo = recorridosViajo;
    }

    public List<Recorrido> getHistorial(){
        return historial;
    }
    public void setHistorial(List<Recorrido> historial){
        this.historial = historial;
    }
}
