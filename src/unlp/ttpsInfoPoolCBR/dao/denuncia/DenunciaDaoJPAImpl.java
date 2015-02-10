package unlp.ttpsInfoPoolCBR.dao.denuncia;

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
    public DenunciaVo guardar(DenunciaVo objetoVO) throws Exception {
    	//TODO poner la denuncia en la session (como agarro la sessión acá?)
    	return super.guardar(objetoVO);
    }
}
