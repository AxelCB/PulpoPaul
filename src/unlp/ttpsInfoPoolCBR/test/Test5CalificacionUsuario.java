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

public class Test5CalificacionUsuario {

	private ICalificacionUsuarioDao califUsuarioDao;
	private IUsuarioDao usuarioDao;
	
	@BeforeTest(groups = "TestAll" )
	public void init(){
		califUsuarioDao = new CalificacionUsuarioDaoJPAImpl();
		usuarioDao = new UsuarioDaoJPAImpl();
	}
	
	@Test(groups = "TestAll" )
	public void shoulAddCalificacionUsuario(){
		try{
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			CalificacionUsuario califUsuario = new CalificacionUsuario(1, usuarioUno, usuarioDos);
			
			califUsuarioDao.guardar(califUsuario);
			
			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Assert.assertEquals(usuarioUno.getCalificacionesHechas().get(0).getCalificacion(), califUsuario.getCalificacion());
			Assert.assertEquals(usuarioDos.getMisCalificaciones().get(0).getCalificacion(), califUsuario.getCalificacion());
			
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
}
