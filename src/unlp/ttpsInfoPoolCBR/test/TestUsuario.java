package unlp.ttpsInfoPoolCBR.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.rol.RolDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Rol;
import unlp.ttpsInfoPoolCBR.model.Usuario;

import java.util.List;

/**
 * Created by Axel on 25/11/2014.
 */
public class TestUsuario {

    private IUsuarioDao usuarioDao;
    private IRolDao rolDao;
    @BeforeClass
    public void init(){
        usuarioDao= new UsuarioDaoJPAImpl();
        rolDao = new RolDaoJPAImpl();
    }

    @Test
    public void addUsuario(){
        try{
            Rol rol = rolDao.encontrar(1);
            Usuario usuario = new Usuario("Santiago", "Ruta", "111222333444", "admin@admin", "admin",rol, null );
            usuario = usuarioDao.guardar(usuario);
            List<Usuario> usuarioList = usuarioDao.listar();

            Assert.assertEquals(usuarioList.size(),1);
            Assert.assertEquals(usuario,usuarioList.get(0));

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
