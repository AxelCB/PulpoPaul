package unlp.ttpsInfoPoolCBR.model;

/**
 * Created by axel on 05/11/14.
 */
public class CalificacionUsuario {

    private Long id;
    private Integer calificacion;

    private Usuario calificador;
    private Usuario calificado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalificacionUsuario)) return false;

        CalificacionUsuario that = (CalificacionUsuario) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getCalificador() {
        return calificador;
    }

    public void setCalificador(Usuario calificador) {
        this.calificador = calificador;
    }

    public Usuario getCalificado() {
        return calificado;
    }

    public void setCalificado(Usuario calificado) {
        this.calificado = calificado;
    }
}
