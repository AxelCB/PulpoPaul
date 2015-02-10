package unlp.ttpsInfoPoolCBR.test;


/**
 * Created by Axel on 25/11/2014.
 */
public class Test1Rol {

//    private IRolDao rolDao;
//
//    @BeforeClass(groups = "RolTest",dependsOnGroups="DropTest" )
//    public void init(){
//        rolDao = new RolDaoJPAImpl();
//    }
//
//    @Test(groups = "RolTest",dependsOnGroups="DropTest")
//    public void shouldAddRol(){
//        Rol rol = new Rol();
//        rol.setNombre("Administrador");
//        try {
//            rol = rolDao.guardar(rol);
//            rol = new Rol();
//            rol.setNombre("Usuario");
//            rol = rolDao.guardar(rol);
//            List<Rol> roles = rolDao.listar();
//            
//            Assert.assertEquals(roles.size(), 2);
//            Assert.assertEquals(rolDao.buscarPorNombre("Usuario"),rol);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
//
//    @Test(dependsOnMethods = {"shouldAddRol"},groups = "RolTest",dependsOnGroups="DropTest")
//    public void shouldModifyRol(){
//        try {
//            Rol rol = rolDao.buscarPorNombre("Usuario");
//           
//            Assert.assertNotNull(rol);
//            
//            Integer rolId = rol.getId();
//            rol.setNombre("Visitante");
//            rol = rolDao.modificar(rol);
//            
//            Assert.assertEquals(rolDao.encontrar(rolId),rol);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
//
//   @Test(dependsOnMethods = {"shouldAddRol"},groups = "RolTest",dependsOnGroups="DropTest")
//    public void shouldRemoveRol(){        
//        try {
//        	Rol rol = rolDao.buscarPorNombre("Visitante");
//            rolDao.borrar(rol.getId());
//            rol = rolDao.buscarPorNombre("Visitante");
//            
//            Assert.assertNull(rol);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }

}
