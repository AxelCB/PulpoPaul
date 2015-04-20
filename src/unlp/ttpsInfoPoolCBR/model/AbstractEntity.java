package unlp.ttpsInfoPoolCBR.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Axel on 22/11/2014.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -8117348638460210536L;

    @Id
    @GeneratedValue
    private Integer id;
    
    private Boolean borrado = false;
    
    public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this!=null&&o!=null){
            if(this.getId().equals(((AbstractEntity)o).getId())){
                return true;
            }
        }
        return false;
    }


}
