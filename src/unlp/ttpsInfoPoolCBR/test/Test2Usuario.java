package unlp.ttpsInfoPoolCBR.test;


/**
 * @author Santiago
 */
public class Test2Usuario {

//    private IUsuarioDao usuarioDao;
//    private IRolDao rolDao;
//    
//    @BeforeClass(groups = "UsuarioTest",dependsOnGroups="RolTest" )
//    public void init(){
//        usuarioDao= new UsuarioDaoJPAImpl();
//        rolDao = new RolDaoJPAImpl();
//    }
//
//    @Test(groups = "UsuarioTest",dependsOnGroups="RolTest"  )
//    public void shouldAddUsuario(){
//        try{
//            Rol rol = rolDao.buscarPorNombre("Administrador");
//            Assert.assertNotNull(rol);
//            
//            Usuario usuario = new Usuario(	"Santiago", 
//            								"Ruta", 
//            								111222, 
//            								"admin@admin", 
//            								"admin",
//            								rol, 
//            								null);
//            usuario = usuarioDao.guardar(usuario);
//            usuario = new Usuario(	"Axel", 
//									"Collard", 
//									999888, 
//									"noadmin@noadmin", 
//									"noadmin",
//									rol,
//									null);
//            usuario = usuarioDao.guardar(usuario);
//            usuario = new Usuario(	"Pepe", 
//									"Rodriguez", 
//									111999, 
//									"asd@asd", 
//									"asd",
//									rol,
//									null);
//			usuario = usuarioDao.guardar(usuario);
//            List<Usuario> usuarioList = usuarioDao.listar();
//            Assert.assertEquals(usuarioList.size(),3);
//            Assert.assertEquals(usuario,usuarioList.get(2));
//        }catch (Exception ex){
//            ex.printStackTrace();
//            Assert.fail();
//        }
//    }
//    
//    @Test(dependsOnMethods = {"shouldAddUsuario"},groups = "UsuarioTest" )
//    public void shouldModifyUsuario(){
//    	try {
//			Usuario usuario = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuario);
//			
//			Integer usuarioId = usuario.getId();
//			usuario.setNombres("Juan");
//			usuario = usuarioDao.modificar(usuario);
//			Assert.assertEquals(usuarioDao.encontrar(usuarioId), usuario);
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail();
//		}
//    	
//    }
//    
//    @Test(dependsOnMethods = {"shouldAddUsuario"},groups = "UsuarioTest" )
//    public void shouldRemoveUsuario(){
//    	Usuario usuario;
//		try {
//			usuario = usuarioDao.buscarPorEmail("asd@asd");
//			Assert.assertNotNull(usuario);
//	    	
//			usuarioDao.borrar(usuario.getId());
//	    	usuario = usuarioDao.buscarPorEmail("asd@asd");
//			Assert.assertNull(usuario);
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail();
//		}
//    }

}
