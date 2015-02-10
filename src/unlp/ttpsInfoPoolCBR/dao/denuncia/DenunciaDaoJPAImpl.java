package unlp.ttpsInfoPoolCBR.dao.denuncia;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Denuncia;

/**
 * Created by Axel on 23/11/2014.
 */
public class DenunciaDaoJPAImpl extends GenericDaoJPAImpl<Denuncia,Denuncia> implements IDenunciaDao {
    public DenunciaDaoJPAImpl() {
        super(Denuncia.class, Denuncia.class);
    }
    
    @Override
    public Denuncia guardar(Denuncia objetoVO) throws Exception {
    	//TODO poner la denuncia en la session (como agarro la sessión acá?)
    	return super.guardar(objetoVO);
    }
}
