package unlp.ttpsInfoPoolCBR.vo;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by axel on 05/11/14.
 */
public class MensajeVo extends AbstractVo{

    private static final long serialVersionUID = -6523492302813042450L;
    
    private String asunto;
    private String contenido;
    private Boolean leido;
    private Date fecha;
    private RecorridoVo recorrido;
    private UsuarioVo emisor;
    private UsuarioVo receptor;

    public MensajeVo(){
    	super();
    }
    
	public MensajeVo(String asunto, String contenido, Boolean leido, 
			UsuarioVo emisor, UsuarioVo receptor) {
		super();
		this.asunto = asunto;
		this.contenido = contenido;
		this.leido = leido;
		this.fecha = new Date(Calendar.getInstance().getTimeInMillis());
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

    public UsuarioVo getEmisor() {
        return emisor;
    }

    public void setEmisor(UsuarioVo emisor) {
        this.emisor = emisor;
    }

    public UsuarioVo getReceptor() {
        return receptor;
    }

    public void setReceptor(UsuarioVo receptor) {
        this.receptor = receptor;
    }

	public Boolean getLeido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public RecorridoVo getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(RecorridoVo recorrido) {
		this.recorrido = recorrido;
	}
	
    
}
