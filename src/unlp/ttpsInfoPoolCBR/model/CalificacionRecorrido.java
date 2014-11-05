package unlp.ttpsInfoPoolCBR.model;

/**
 * Created by axel on 05/11/14.
 */
public class CalificacionRecorrido {

    private Long id;
    private Integer calificacion;

    private Recorrido calificado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalificacionRecorrido)) return false;

        CalificacionRecorrido that = (CalificacionRecorrido) o;

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

    public Recorrido getCalificado() {
        return calificado;
    }

    public void setCalificado(Recorrido calificado) {
        this.calificado = calificado;
    }
}
