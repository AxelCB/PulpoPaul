package unlp.ttpsInfoPoolCBR.vo;


/**
 * Created by axel on 05/11/14.
 */
public class RolVo extends AbstractVo{

    private static final long serialVersionUID = -1395059380114488905L;

    private String nombre;

    public RolVo(){
    	super();
    }
    
    public RolVo(String nombre) {
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
