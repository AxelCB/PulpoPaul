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

/**
 * @author Santiago
 */
public class Test4Denuncia {

	private IDenunciaDao denunciaDao;
	private IUsuarioDao usuarioDao;
	
	@BeforeClass
	public void init(){
		denunciaDao = new DenunciaDaoJPAImpl();
		usuarioDao = new UsuarioDaoJPAImpl();
	}
	
	@Test
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
			
			denuncia = denunciaDao.guardar(denuncia);
			
			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Assert.assertEquals(usuarioUno.getDenunciasHechas().get(0), denuncia);
			Assert.assertEquals(usuarioDos.getMisDenuncias().get(0), denuncia);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}	
}
