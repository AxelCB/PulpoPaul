package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by axel on 05/11/14.
 */
@Entity
@Table
public class CalificacionRecorrido extends AbstractEntity {

//    private Long id;
    @Column(nullable = false)
    private Integer calificacion;

    @ManyToOne(optional = false)
    private Viaje calificado;

    @ManyToOne(optional = false)
    private Usuario calificador;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof CalificacionRecorrido)) return false;
//
//        CalificacionRecorrido that = (CalificacionRecorrido) o;
//
//        if (id != null ? !id.equals(that.id) : that.id != null) return false;
//
//        return true;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


    public Usuario getCalificador() {
        return calificador;
    }

    public void setCalificador(Usuario calificador) {
        this.calificador = calificador;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Viaje getCalificado() {
        return calificado;
    }

    public void setCalificado(Viaje calificado) {
        this.calificado = calificado;
    }
}
