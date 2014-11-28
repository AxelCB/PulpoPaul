package unlp.ttpsInfoPoolCBR.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import unlp.ttpsInfoPoolCBR.dao.calificacionUsuario.CalificacionUsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.calificacionUsuario.ICalificacionUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.CalificacionUsuario;
import unlp.ttpsInfoPoolCBR.model.Usuario;

/**
 * @author Santiago
 */
public class Test5CalificacionUsuario {

	private ICalificacionUsuarioDao califUsuarioDao;
	private IUsuarioDao usuarioDao;
	
	@BeforeTest(groups = "CalificacionUsuarioTest" ,dependsOnGroups="DenunciaTest")
	public void init(){
		califUsuarioDao = new CalificacionUsuarioDaoJPAImpl();
		usuarioDao = new UsuarioDaoJPAImpl();
	}
	
	@Test(groups = "CalificacionUsuarioTest" ,dependsOnGroups="DenunciaTest")
	public void shoulAddCalificacionUsuario(){
		try{
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			CalificacionUsuario califUsuario = new CalificacionUsuario(1, usuarioUno, usuarioDos);
			
			califUsuario = califUsuarioDao.guardar(califUsuario);
			
			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Assert.assertEquals(usuarioUno.getCalificacionesHechas().get(0), califUsuario);
			Assert.assertEquals(usuarioDos.getMisCalificaciones().get(0), califUsuario);
			
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
}
