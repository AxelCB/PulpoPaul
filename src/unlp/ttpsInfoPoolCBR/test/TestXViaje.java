package unlp.ttpsInfoPoolCBR.test;

import java.sql.Date;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.viaje.IViajeDao;
import unlp.ttpsInfoPoolCBR.dao.viaje.ViajeDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.model.Viaje;

public class TestXViaje {

	private IUsuarioDao usuarioDao;
	private IViajeDao viajeDao;
	
	@BeforeClass
	public void init(){
		usuarioDao = new UsuarioDaoJPAImpl();
		viajeDao = new ViajeDaoJPAImpl();
	}
	
	@Test
	public void shouldAddViaje(){
		try{
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Recorrido recorrido = usuarioUno.getRecorridosMios().get(0);
			Assert.assertNotNull(recorrido);
			
			Calendar calendario = Calendar.getInstance();
			
			Viaje viaje = new Viaje(recorrido,
									"Un recorrido mas",
									(Date) calendario.getTime());
			
			viaje = viajeDao.guardar(viaje);
			
			usuarioDos.agregarViaje(viaje);
			usuarioDos = usuarioDao.modificar(usuarioDos);
			
			Assert.assertEquals(usuarioDos.getMisViajes().get(0), viaje);
			Assert.assertEquals(viaje.getRecorrido(), recorrido);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
		
//		@Test
//		public void shouldRemoveViaje
	}
}
