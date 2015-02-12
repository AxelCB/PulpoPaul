package unlp.ttpsInfoPoolCBR.dao.denuncia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Denuncia;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.util.MapperUtils;
import unlp.ttpsInfoPoolCBR.vo.DenunciaVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

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

	@Override
	public List<DenunciaVo> listarDeAdmin(EntityManager em, UsuarioVo adminVo)
			throws Exception {
		List<Denuncia> listaM = new ArrayList<Denuncia>();
        try{
        	Usuario admin = em.find(Usuario.class, adminVo.getId());
            TypedQuery<Denuncia> jpaql = em.createQuery("select d from Denuncia d INNER JOIN d.denunciado WHERE d.denunciado = :denunciado" 
            		,persistentClass);
            jpaql.setParameter("denunciado", admin);
            listaM = jpaql.getResultList();
            return MapperUtils.map(listaM, this.getVoClass());
        }catch(Exception ex){
            throw ex;
        }
	}
}
