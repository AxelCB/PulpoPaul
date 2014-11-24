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

//    private Long id;
    @Column(nullable = false)
    private String asunto;
    @Column(length = 1023,
    		nullable = false)
    private String contenido;

    @ManyToOne(optional = false)
    private Usuario emisor;
    @ManyToOne(optional = false)
    private Usuario receptor;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Mensaje)) return false;
//
//        Mensaje denuncia = (Mensaje) o;
//
//        if (id != null ? !id.equals(denuncia.id) : denuncia.id != null) return false;
//
//        return true;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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
