package unlp.ttpsInfoPoolCBR.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.rol.RolDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Rol;

import java.util.List;

/**
 * Created by Axel on 25/11/2014.
 */
public class TestRol {

    private IRolDao rolDao;

    @BeforeClass
    public void init(){
        rolDao = new RolDaoJPAImpl();
    }

    @Test
    public void shouldAddRol(){
        Rol rol = new Rol();
        rol.setNombre("Administrador");
        try {
            rol = rolDao.guardar(rol);
            rol = new Rol();
            rol.setNombre("Usuario");
            rol = rolDao.guardar(rol);
            List<Rol> roles = rolDao.listar();
            
            Assert.assertEquals(roles.size(), 2);
            Assert.assertEquals(rolDao.buscarPorNombre("Usuario").get(0),rol);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"shouldAddRol"})
    public void shouldModifyRol(){
        try {
            Rol rol = rolDao.buscarPorNombre("Usuario").get(0);
           
            Assert.assertNotNull(rol);
            
            Integer rolId = rol.getId();
            rol.setNombre("Visitante");
            rol = rolDao.modificar(rol);
            
            Assert.assertEquals(rolDao.encontrar(rolId),rol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   @Test(dependsOnMethods = {"shouldAddRol"})
    public void shouldRemoveRol(){        
        try {
        	Rol rol = rolDao.buscarPorNombre("Visitante").get(0);
            rolDao.borrar(rol);
            rol = rolDao.buscarPorNombre("Visitante").get(0);
            
            Assert.assertNull(rol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
