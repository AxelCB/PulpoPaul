package unlp.ttpsInfoPoolCBR.test;


public class Test7Evento {

//	private IUsuarioDao usuarioDao;
//	private IEventoDao eventoDao;
//	private IRecorridoDao recorridoDao;
//	
//	@BeforeClass(groups={"EventoTest"})
//	public void init(){
//		usuarioDao = new UsuarioDaoJPAImpl();
//		eventoDao = new EventoDaoJPAImpl();
//		recorridoDao = new RecorridoDaoJPAImpl();
//	}
//	
//	@Test(groups={"EventoTest"},dependsOnGroups="RecorridoTest")
//	public void shouldAddEvento(){
//		try {
//			Evento evento = new Evento(	"JAIIO 2014",
//										"ODIO LOS ORM",
//										(Date)Calendar.getInstance().getTime(),
//										new Time(12,0,0),
//										new Time(16,0,0));
//			
//			evento = eventoDao.guardar(evento);
//	
//			Assert.assertEquals(eventoDao.buscarPorNombre("JAIIO 2014"), evento);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}
//	
//	@Test(groups={"EventoTest"},dependsOnGroups="RecorridoTest",dependsOnMethods={"shouldAddEvento"})
//	public void shouldAddRecorridoToEvento(){
//		try{
//			Usuario usuarioUno = usuarioDao.buscarPorEmail("admin@admin");
//			Assert.assertNotNull(usuarioUno);
//
//			usuarioUno = usuarioDao.traerRecorridos(usuarioUno);
//
//			Recorrido recorrido = usuarioUno.getRecorridosMios().get(0);
//			//recorrido.setGoogleMapsRecorrido("otra url");
//			
//			Evento evento = eventoDao.buscarPorNombre("JAIIO 2014");
//			Assert.assertNotNull(evento);
//			
//			recorrido.setEvento(evento);
//			
//			recorrido = recorridoDao.guardar(recorrido);
//			
//			Assert.assertEquals(recorrido.getEvento(), evento);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
//	/*@Test
//	public void shouldDeleteEvento(){
//		try{
//			Evento evento = eventoDao.buscarPorNombre("JAIIO 2014");
//			Assert.assertNotNull(evento);
//			
//			eventoDao.borrar(evento.getId());
//			
//			Assert.assertNull(eventoDao.buscarPorNombre("JAIIO 2014"));
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			Assert.fail();
//		}
//	}*/
}
