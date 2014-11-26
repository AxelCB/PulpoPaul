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
    public void shouldAddUsuario(){
        try{
            Rol rol = rolDao.buscarPorNombre("Administrador");
            Assert.assertNotNull(rol);
            
            Usuario usuario = new Usuario(	"Santiago", 
            								"Ruta", 
            								"111222333444", 
            								"admin@admin", 
            								"admin",
            								rol, 
            								null);
            usuario = usuarioDao.guardar(usuario);
            usuario = new Usuario(	"Axel", 
									"Collard", 
									"999888777666", 
									"noadmin@noadmin", 
									"noadmin",
									rol,
									null);
            usuario = usuarioDao.guardar(usuario);
            usuario = new Usuario(	"Pepe", 
									"Rodriguez", 
									"111999222888", 
									"asd@asd", 
									"asd",
									rol,
									null);
			usuario = usuarioDao.guardar(usuario);
            List<Usuario> usuarioList = usuarioDao.listar();
            Assert.assertEquals(usuarioList.size(),3);
            Assert.assertEquals(usuario,usuarioList.get(2));
        }catch (Exception ex){
            ex.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test(dependsOnMethods = {"shouldAddUsuario"})
    public void shouldModifyUsuario(){
    	try {
			Usuario usuario = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuario);
			
			Integer usuarioId = usuario.getId();
			usuario.setNombres("Juan");
			usuario = usuarioDao.modificar(usuario);
			Assert.assertEquals(usuarioDao.encontrar(usuarioId), usuario);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
    	
    }
    
    @Test(dependsOnMethods = {"shouldAddUsuario"})
    public void shouldRemoveUsuario(){
    	Usuario usuario;
		try {
			usuario = usuarioDao.buscarPorEmail("asd@asd");
			Assert.assertNotNull(usuario);
	    	
			usuarioDao.borrar(usuario.getId());
	    	usuario = usuarioDao.buscarPorEmail("asd@asd");
			Assert.assertNull(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
    }

}
