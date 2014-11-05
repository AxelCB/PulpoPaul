package unlp.ttpsInfoPoolCBR.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 05/11/14.
 */
public class Usuario {

    private Long id;
    private String nombres;
    private String apellido;
    private String telefono;
    private String email;
    private String clave;
    //private File foto; ???

    private Rol rol;
    private List<CalificacionUsuario> misCalificaciones = new ArrayList<CalificacionUsuario>();
    private List<CalificacionUsuario> calificacionesHechas = new ArrayList<CalificacionUsuario>();
    private List<Denuncia> misDenuncias = new ArrayList<Denuncia>();
    private List<Denuncia> denunciasHechas = new ArrayList<Denuncia>();
    private List<Mensaje> bandejaEntrada = new ArrayList<Mensaje>();
    private List<Mensaje> bandejaSalida = new ArrayList<Mensaje>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (id != null ? !id.equals(usuario.id) : usuario.id != null) return false;

        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
}
