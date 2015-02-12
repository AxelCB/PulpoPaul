package unlp.ttpsInfoPoolCBR.dao.denuncia;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Denuncia;
import unlp.ttpsInfoPoolCBR.vo.DenunciaVo;

/**
 * Created by Axel on 23/11/2014.
 */
public class DenunciaDaoJPAImpl extends GenericDaoJPAImpl<Denuncia,DenunciaVo> implements IDenunciaDao {
    public DenunciaDaoJPAImpl() {
        super(Denuncia.class, DenunciaVo.class);
    }
    
    @Override
    public DenunciaVo guardar(EntityManager em,DenunciaVo objetoVO) throws Exception {
    	HttpSession session = ServletActionContext.getRequest().getSession(false);
		session.setAttribute("denuncia", objetoVO);
    	return super.guardar(em,objetoVO);
    }
}
