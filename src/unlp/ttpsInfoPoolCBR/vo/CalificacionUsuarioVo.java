package unlp.ttpsInfoPoolCBR.vo;

/**
 * Created by axel on 10/02/15.
 */
public class CalificacionUsuarioVo extends AbstractVo {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3658878861655640002L;
	private Integer calificacion;
    private UsuarioVo calificador;
    private UsuarioVo calificado;

    public CalificacionUsuarioVo(){
    	super();
    }
    
    public CalificacionUsuarioVo(Integer calificacion, UsuarioVo calificador,
			UsuarioVo calificado) {
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

    public UsuarioVo getCalificador() {
        return calificador;
    }

    public void setCalificador(UsuarioVo calificador) {
        this.calificador = calificador;
    }

    public UsuarioVo getCalificado() {
        return calificado;
    }

    public void setCalificado(UsuarioVo calificado) {
        this.calificado = calificado;
    }
}
