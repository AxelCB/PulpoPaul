package unlp.ttpsInfoPoolCBR.test;


/**
 * @author Santiago
 */
public class Test6Recorrido {

//	private IRecorridoDao recorridoDao;
//	private IUsuarioDao usuarioDao;
//	
//	@BeforeClass(groups = "RecorridoTest",dependsOnGroups="CalificacionUsuarioTest")
//	public void init(){
//		recorridoDao = new RecorridoDaoJPAImpl();
//		usuarioDao = new UsuarioDaoJPAImpl();
//	}
//	
//	@Test(groups = "RecorridoTest",dependsOnGroups="CalificacionUsuarioTest")
//	public void shouldAddRecorrido(){
//		try{
//			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//			
//			Recorrido recorrido = new Recorrido();
//			recorrido.setNombre("Vamos a la Facu");
//			recorrido.setHoraSalida(new Time(8,0,0));
//			recorrido.setHoraVuelta(new Time(14,0,0));
//			recorrido.setLugares(5);
//			recorrido.setPrecio(10.0);
//			recorrido.setTipo(TipoViaje.DIARIO);
//			//recorrido.setGoogleMapsRecorrido("una url");
//			recorrido.setPropietario(usuarioUno);
//			
//			recorrido = recorridoDao.guardar(recorrido);
//			
//			recorrido = new Recorrido();
//			recorrido.setNombre("Por 32");
//			recorrido.setHoraSalida(new Time(12,30,0));
//			recorrido.setHoraVuelta(new Time(16,30,0));
//			recorrido.setLugares(2);
//			recorrido.setPrecio(20.0);
//			recorrido.setTipo(TipoViaje.DIARIO);
//			//recorrido.setGoogleMapsRecorrido("una url");
//			recorrido.setPropietario(usuarioUno);
//			
//			recorrido = recorridoDao.guardar(recorrido);
//			
//			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//
//			usuarioUno = usuarioDao.traerRecorridos(usuarioUno);
//			
//			Assert.assertEquals(usuarioUno.getRecorridosMios().get(1), recorrido);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}
//	
//	@Test(dependsOnMethods = {"shouldAddRecorrido"},groups = "RecorridoTest",dependsOnGroups="CalificacionUsuarioTest")
//	public void shouldModifyRecorrido(){
//		try{
//			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//
//			usuarioUno = usuarioDao.traerRecorridos(usuarioUno);
//			
//			Recorrido recorrido = usuarioUno.getRecorridosMios().get(0);
//			//recorrido.setGoogleMapsRecorrido("otra url");
//			
//			recorridoDao.modificar(recorrido);
//			
//			Assert.assertEquals(usuarioUno.getRecorridosMios().get(0), recorrido);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}
//	
//	@Test(dependsOnMethods = {"shouldAddRecorrido"},groups = "RecorridoTest",dependsOnGroups="CalificacionUsuarioTest")
//	public void shouldAddPasajero(){
//		try{
//			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//			
//			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
//			Assert.assertNotNull(usuarioDos);
//
//			usuarioUno = usuarioDao.traerRecorridos(usuarioUno);
//			usuarioDos = usuarioDao.traerRecorridos(usuarioDos);
//
//			Recorrido recorrido = usuarioUno.getRecorridosMios().get(0);
//			
//			recorrido.agregarPasajero(usuarioDos);
//			recorrido = recorridoDao.modificar(recorrido);
//			
//			usuarioDos.agregarRecorridoViajo(recorrido);
//			usuarioDos = usuarioDao.modificar(usuarioDos);
//
//			Assert.assertEquals(usuarioDos.getRecorridosViajo().get(0), recorrido);
//			Assert.assertEquals(recorrido.getPasajeros().get(recorrido.getPasajeros().indexOf(usuarioDos)), usuarioDos);	
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}
//	
//	@Test(dependsOnMethods = {"shouldAddPasajero"},groups = "RecorridoTest",dependsOnGroups="CalificacionUsuarioTest")
//	public void shouldDeletePasajero(){
//		try{
//			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//			
//			Usuario usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
//			Assert.assertNotNull(usuarioDos);
//
//			usuarioUno = usuarioDao.traerRecorridos(usuarioUno);
//			usuarioDos = usuarioDao.traerRecorridos(usuarioDos);
//
//			Recorrido recorrido = usuarioUno.getRecorridosMios().get(0);
//			
//			recorrido.eliminarPasajero(usuarioDos);
//			recorrido = recorridoDao.modificar(recorrido);
//			
//			usuarioDos.eliminarRecorridoViajo(recorrido);
//			usuarioDos = usuarioDao.modificar(usuarioDos);
//			//usuarioDos = usuarioDao.buscarPorEmail("noadmin@noadmin");
//			
//			Assert.assertEquals(usuarioDos.getRecorridosViajo().size(), 0);
//			Assert.assertEquals(recorrido.getPasajeros().size(),0);
//			
//			/*Esto es para los test que siguen*/
//			recorrido.agregarPasajero(usuarioDos);
//			recorrido = recorridoDao.modificar(recorrido);
//			usuarioDos.agregarRecorridoViajo(recorrido);
//			usuarioDos = usuarioDao.modificar(usuarioDos);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}
//	
//	@Test(dependsOnMethods = {"shouldDeletePasajero"},groups = "RecorridoTest",dependsOnGroups="CalificacionUsuarioTest")
//	public void shouldDeleteRecorrido(){
//		try{
//			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//
//			usuarioUno = usuarioDao.traerRecorridos(usuarioUno);
//			
//			Recorrido recorrido = usuarioUno.getRecorridosMios().get(1);
//			
//			recorridoDao.borrar(recorrido.getId());
//			
//			usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			usuarioUno = usuarioDao.traerRecorridos(usuarioUno);
//			
//			Assert.assertEquals(usuarioUno.getRecorridosMios().size(),1);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}
}
