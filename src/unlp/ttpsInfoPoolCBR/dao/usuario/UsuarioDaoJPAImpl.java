package unlp.ttpsInfoPoolCBR.dao.usuario;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Usuario;

/**
 * Created by Axel on 22/11/2014.
 */
public class UsuarioDaoJPAImpl extends GenericDaoJPAImpl<Usuario,Usuario> implements IUsuarioDao{
    public UsuarioDaoJPAImpl() {
        super(Usuario.class, Usuario.class);
    }
}
