package unlp.ttpsInfoPoolCBR.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.mensaje.MensajeDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Mensaje;
import unlp.ttpsInfoPoolCBR.model.Usuario;

public class Test3Mensaje {

	private IMensajeDao mensajeDao;
	private IUsuarioDao usuarioDao;
	
	@BeforeClass
	public void init(){
		mensajeDao = new MensajeDaoJPAImpl();
		usuarioDao = new UsuarioDaoJPAImpl();
	}
	
	@Test
	public void shouldAddMessage(){
		try {
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Mensaje mensaje = new Mensaje(	"Probando",
											"Que lindo dia",
											usuarioUno,
											usuarioDos);
			mensajeDao.guardar(mensaje);
			
			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Assert.assertEquals(usuarioUno.getBandejaSalida().get(0).getAsunto(),mensaje.getAsunto());
			Assert.assertEquals(usuarioDos.getBandejaEntrada().get(0).getAsunto(), mensaje.getAsunto());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
