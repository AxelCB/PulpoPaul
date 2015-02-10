package unlp.ttpsInfoPoolCBR.vo;


/**
 * Created by axel on 05/11/14.
 */
public class DenunciaVo extends AbstractVo {

    private static final long serialVersionUID = -7071893405560390254L;
    
    private String asunto;
    private String contenido;
    private UsuarioVo denunciante;
    private UsuarioVo denunciado;

    public DenunciaVo(){
    	super();
    }
    
    public DenunciaVo(String asunto, String contenido, UsuarioVo denunciante,
			UsuarioVo denunciado) {
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

    public UsuarioVo getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(UsuarioVo denunciante) {
        this.denunciante = denunciante;
    }

    public UsuarioVo getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(UsuarioVo denunciado) {
        this.denunciado = denunciado;
    }
}
