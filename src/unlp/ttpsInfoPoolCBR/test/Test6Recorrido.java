package unlp.ttpsInfoPoolCBR.test;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.dao.recorrido.RecorridoDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Recorrido;
import unlp.ttpsInfoPoolCBR.model.TipoViaje;
import unlp.ttpsInfoPoolCBR.model.Usuario;

/**
 * @author Santiago
 */
public class Test6Recorrido {

	private IRecorridoDao recorridoDao;
	private IUsuarioDao usuarioDao;
	
	@BeforeClass
	public void init(){
		recorridoDao = new RecorridoDaoJPAImpl();
		usuarioDao = new UsuarioDaoJPAImpl();
	}
	
	@Test
	public void shouldAddRecorrido(){
		try{
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Recorrido recorrido = new Recorrido();
			recorrido.setNombre("Vamos a la Facu");
			recorrido.setHoraSalida(new Time(8,0,0));
			recorrido.setHoraVuelta(new Time(14,0,0));
			recorrido.setLugares(5);
			recorrido.setPrecio(10.0);
			recorrido.setTipo(TipoViaje.DIARIO);
			recorrido.setGoogleMapsRecorrido("una url");
			recorrido.setPropietario(usuarioUno);
			
			recorrido = recorridoDao.guardar(recorrido);
			
			recorrido = new Recorrido();
			recorrido.setNombre("Por 32");
			recorrido.setHoraSalida(new Time(12,30,0));
			recorrido.setHoraVuelta(new Time(16,30,0));
			recorrido.setLugares(2);
			recorrido.setPrecio(20.0);
			recorrido.setTipo(TipoViaje.DIARIO);
			recorrido.setGoogleMapsRecorrido("una url");
			recorrido.setPropietario(usuarioUno);
			
			recorrido = recorridoDao.guardar(recorrido);
			
			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Assert.assertEquals(usuarioUno.getRecorridosMios().get(1), recorrido);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"shouldAddRecorrido"})
	public void shouldModifyRecorrido(){
		try{
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Recorrido recorrido = usuarioUno.getRecorridosMios().get(0);
			recorrido.setGoogleMapsRecorrido("otra url");
			
			recorridoDao.modificar(recorrido);
			
			Assert.assertEquals(usuarioUno.getRecorridosMios().get(0), recorrido);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"shouldAddRecorrido"})
	public void shouldAddPasajero(){
		try{
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Recorrido recorrido = usuarioUno.getRecorridosMios().get(0);
			
			usuarioDos.agregarRecorridoViajo(recorrido);
			
			usuarioDos = usuarioDao.modificar(usuarioDos);
			
			Assert.assertEquals(usuarioDos.getRecorridosViajo().get(0), recorrido);
			Assert.assertEquals(recorrido.getPasajeros().get(recorrido.getPasajeros().indexOf(usuarioDos)), usuarioDos);	
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"shouldAddPasajero"})
	public void shouldDeletePasajero(){
		try{
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			Assert.assertNotNull(usuarioDos);
			
			Recorrido recorrido = usuarioUno.getRecorridosMios().get(0);
			
			recorrido.eliminarPasajero(usuarioDos);
			
			/*ESTO NO BORRA LA TABLA Usuario_Recorrido_Viajo*/
			recorrido = recorridoDao.modificar(recorrido);
			
			usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
			
			Assert.assertNull(usuarioDos.getRecorridosViajo());
			Assert.assertNull(recorrido.getPasajeros());			
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"shouldAddRecorrido"})
	public void shouldDeleteRecorrido(){
		try{
			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			Assert.assertNotNull(usuarioUno);
			
			Recorrido recorrido = usuarioUno.getRecorridosMios().get(1);
			
			recorridoDao.borrar(recorrido.getId());
			
			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
			
			Assert.assertEquals(usuarioUno.getRecorridosMios().size(),1);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
}
