package unlp.ttpsInfoPoolCBR.dao.mensaje;


import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Mensaje;
import unlp.ttpsInfoPoolCBR.vo.MensajeVo;

/**
 * Created by Axel on 23/11/2014.
 */
public class MensajeDaoJPAImpl extends GenericDaoJPAImpl<Mensaje,MensajeVo> implements IMensajeDao {
    public MensajeDaoJPAImpl() {
        super(Mensaje.class, MensajeVo.class);
    }
}
