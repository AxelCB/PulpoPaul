package unlp.ttpsInfoPoolCBR.test;


/**
 * @author Santiago
 */
public class Test3Mensaje {

//	private IMensajeDao mensajeDao;
//	private IUsuarioDao usuarioDao;
//	
//	@BeforeClass(groups = "MensajeTest" ,dependsOnGroups="UsuarioTest")
//	public void init(){
//		mensajeDao = new MensajeDaoJPAImpl();
//		usuarioDao = new UsuarioDaoJPAImpl();
//	}
//	
//	@Test(groups = "MensajeTest" ,dependsOnGroups="UsuarioTest")
//	public void shouldAddMessage(){
//		try {
//			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//			
//			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
//			Assert.assertNotNull(usuarioDos);
//			
//			Mensaje mensaje = new Mensaje();
////											"Probando",
////											"Que lindo dia",
////											usuarioUno,
////											usuarioDos);
//			
//			mensaje = mensajeDao.guardar(mensaje);
//			
//			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//			
//			usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
//			Assert.assertNotNull(usuarioDos);
//			
//			usuarioUno = usuarioDao.traerMensajes(usuarioUno);
//			usuarioDos = usuarioDao.traerMensajes(usuarioDos);
//			
//			Assert.assertEquals(usuarioUno.getBandejaSalida().get(0),mensaje);
//			Assert.assertEquals(usuarioDos.getBandejaEntrada().get(0),mensaje);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}
}
