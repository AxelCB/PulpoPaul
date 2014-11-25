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
public class CalificacionUsuario extends AbstractEntity {

    @Column(nullable = false)
    private Integer calificacion;

    @ManyToOne(optional = false)
    private Usuario calificador;

    @ManyToOne(optional = false)
    private Usuario calificado;

    public CalificacionUsuario(){
    	super();
    }
    
    public CalificacionUsuario(Integer calificacion, Usuario calificador,
			Usuario calificado) {
		super();
		this.calificacion = calificacion;
		this.calificador = calificador;
		this.calificado = calificado;
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
