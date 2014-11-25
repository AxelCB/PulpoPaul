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
public class Denuncia extends AbstractEntity {

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false,
    		length = 1023)
    private String contenido;

    @ManyToOne(optional = false)
    private Usuario denunciante;
    
    @ManyToOne(optional = false)
    private Usuario denunciado;

    public Denuncia(){
    	super();
    }
    
    public Denuncia(String asunto, String contenido, Usuario denunciante,
			Usuario denunciado) {
		super();
		this.asunto = asunto;
		this.contenido = contenido;
		this.denunciante = denunciante;
		this.denunciado = denunciado;
	}

	public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Usuario denunciante) {
        this.denunciante = denunciante;
    }

    public Usuario getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(Usuario denunciado) {
        this.denunciado = denunciado;
    }
}
