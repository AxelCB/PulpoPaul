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

    private static final long serialVersionUID = 3242152665834722886L;

    @Column(nullable = false)
    private Integer calificacion;

    @ManyToOne(optional = false)
//    @JoinColumn(name="calificado_id")
    private Recorrido calificado;

    @ManyToOne(optional = false)
//    @JoinColumn(name="calificador_id")
    private Usuario calificador;

    public CalificacionRecorrido(){
    	super();
    }

    public CalificacionRecorrido(Integer calificacion, Recorrido calificado,
			Usuario calificador) {
		super();
		this.calificacion = calificacion;
		this.calificado = calificado;
		this.calificador = calificador;
	}

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

    public Recorrido getCalificado() {
        return calificado;
    }

    public void setCalificado(Recorrido calificado) {
        this.calificado = calificado;
    }
}
