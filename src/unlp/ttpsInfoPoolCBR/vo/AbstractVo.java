package unlp.ttpsInfoPoolCBR.vo;

import java.io.Serializable;

/**
 * Created by Axel on 22/11/2014.
 */
public abstract class AbstractVo implements Serializable {
	
	private static final long serialVersionUID = -820091937049974736L;

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
            if(this.getId().equals(((AbstractVo)o).getId())){
                return true;
            }
        }
        return false;
    }


}
