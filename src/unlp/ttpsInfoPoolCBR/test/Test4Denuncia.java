package unlp.ttpsInfoPoolCBR.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import unlp.ttpsInfoPoolCBR.dao.denuncia.DenunciaDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.denuncia.IDenunciaDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Denuncia;
import unlp.ttpsInfoPoolCBR.model.Usuario;

public class Test4Denuncia {

	private IDenunciaDao denunciaDao;
	private IUsuarioDao usuarioDao;
	
	@BeforeClass(groups = "TestAll" )
	public void init(){
		denunciaDao = new DenunciaDaoJPAImpl();
		usuarioDao = new UsuarioDaoJPAImpl();
	}
	
	@Test(groups = "TestAll" )
	public void shouldAddDenuncia(){
		try {
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Denuncia denuncia = new Denuncia(	"Conductor maligno",
												"El tipo no bajo de cuarta",
												usuarioUno,
												usuarioDos);
			
			denunciaDao.guardar(denuncia);
			
			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Assert.assertEquals(usuarioUno.getDenunciasHechas().get(0).getAsunto(), denuncia.getAsunto());
			Assert.assertEquals(usuarioDos.getMisDenuncias().get(0).getAsunto(), denuncia.getAsunto());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}	
}
