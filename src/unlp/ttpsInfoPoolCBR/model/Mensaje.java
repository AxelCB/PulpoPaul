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
public class Mensaje extends AbstractEntity{

    private static final long serialVersionUID = -6523492302813042450L;

    @Column(nullable = false)
    private String asunto;

    @Column(length = 1023,
    		nullable = false)
    private String contenido;

    @ManyToOne(optional = false)
    private Usuario emisor;
    
    @ManyToOne(optional = false)
    private Usuario receptor;

    public Mensaje(){
    	super();
    }
    
    public Mensaje(String asunto, String contenido, Usuario emisor,
			Usuario receptor) {
		super();
		this.asunto = asunto;
		this.contenido = contenido;
		this.emisor = emisor;
		this.receptor = receptor;
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

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }
}
