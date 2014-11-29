package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by axel on 05/11/14.
 */
@Entity
@Table
public class Rol extends AbstractEntity{

    private static final long serialVersionUID = -1395059380114488905L;

    @Column(nullable = false)
    private String nombre;

    public Rol(){
    	super();
    }
    
    public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
