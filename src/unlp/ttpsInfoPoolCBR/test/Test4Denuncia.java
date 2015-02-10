package unlp.ttpsInfoPoolCBR.test;


/**
 * @author Santiago
 */
public class Test4Denuncia {

//	private IDenunciaDao denunciaDao;
//	private IUsuarioDao usuarioDao;
//	
//	@BeforeClass(groups = "DenunciaTest" ,dependsOnGroups="MensajeTest")
//	public void init(){
//		denunciaDao = new DenunciaDaoJPAImpl();
//		usuarioDao = new UsuarioDaoJPAImpl();
//	}
//	
//	@Test(groups = "DenunciaTest" ,dependsOnGroups="MensajeTest")
//	public void shouldAddDenuncia(){
//		try {
//			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//			
//			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
//			Assert.assertNotNull(usuarioDos);
//			
//			Denuncia denuncia = new Denuncia(	"Conductor maligno",
//												"El tipo no bajo de cuarta",
//												usuarioUno,
//												usuarioDos);
//			
//			denuncia = denunciaDao.guardar(denuncia);
//			
//			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//			
//			usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
//			Assert.assertNotNull(usuarioDos);
//
//			usuarioUno = usuarioDao.traerDenuncias(usuarioUno);
//			usuarioDos = usuarioDao.traerDenuncias(usuarioDos);
//			
//			Assert.assertEquals(usuarioUno.getDenunciasHechas().get(0), denuncia);
//			Assert.assertEquals(usuarioDos.getMisDenuncias().get(0), denuncia);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}	
}
