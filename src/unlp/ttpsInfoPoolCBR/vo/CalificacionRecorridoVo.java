package unlp.ttpsInfoPoolCBR.vo;

/**
 * Created by axel on 05/11/14.
 */
public class CalificacionRecorridoVo extends AbstractVo {
	
	private static final long serialVersionUID = 1844169114833294874L;
	
	private Integer calificacion;
    private ViajeVo calificado;
    private UsuarioVo calificador;

    public CalificacionRecorridoVo(){
    	super();
    }

    public CalificacionRecorridoVo(Integer calificacion, ViajeVo calificado,
			UsuarioVo calificador) {
		super();
		this.calificacion = calificacion;
		this.calificado = calificado;
		this.calificador = calificador;
	}

	public UsuarioVo getCalificador() {
        return calificador;
    }

    public void setCalificador(UsuarioVo calificador) {
        this.calificador = calificador;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public ViajeVo getCalificado() {
        return calificado;
    }

    public void setCalificado(ViajeVo calificado) {
        this.calificado = calificado;
    }
}
