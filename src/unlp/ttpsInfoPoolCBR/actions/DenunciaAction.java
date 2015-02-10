package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.denuncia.IDenunciaDao;
import unlp.ttpsInfoPoolCBR.model.Denuncia;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Axel on 09/02/2015.
 */

@Action(value = "denuncia")
public class DenunciaAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2653654270018155961L;
	
	@Autowired
	IDenunciaDao denunciaDao;
	
	private List<Denuncia> denuncias = new ArrayList<Denuncia>();
	
    private String asunto;
    private String contenido;
    private Integer idDenunciado;
    
    

}
