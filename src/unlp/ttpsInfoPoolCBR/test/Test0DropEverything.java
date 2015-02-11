package unlp.ttpsInfoPoolCBR.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import unlp.ttpsInfoPoolCBR.dao.calificacionRecorrido.CalificacionRecorridoDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.calificacionRecorrido.ICalificacionRecorridoDao;
import unlp.ttpsInfoPoolCBR.dao.calificacionUsuario.CalificacionUsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.calificacionUsuario.ICalificacionUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.denuncia.DenunciaDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.denuncia.IDenunciaDao;
import unlp.ttpsInfoPoolCBR.dao.evento.EventoDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.evento.IEventoDao;
import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.mensaje.MensajeDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.dao.recorrido.RecorridoDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.rol.RolDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.dao.viaje.IViajeDao;
import unlp.ttpsInfoPoolCBR.dao.viaje.ViajeDaoJPAImpl;

/**
 * @author Santiago
 */

public class Test0DropEverything {

	private ICalificacionRecorridoDao califRecorridoDao;
	private ICalificacionUsuarioDao califUsuarioDao;
	private IDenunciaDao denunciaDao;
	private IEventoDao eventoDao;
	private IMensajeDao mensajeDao;
	private IRecorridoDao recorridoDao;
	private IRolDao rolDao;
	private IUsuarioDao usuarioDao;
	private IViajeDao viajeDao;
	
	@BeforeClass(groups = "DropTest")
	public void init(){
		califRecorridoDao = new CalificacionRecorridoDaoJPAImpl();
		califUsuarioDao = new CalificacionUsuarioDaoJPAImpl();
		denunciaDao = new DenunciaDaoJPAImpl();
		eventoDao = new EventoDaoJPAImpl();
		mensajeDao = new MensajeDaoJPAImpl();
		recorridoDao = new RecorridoDaoJPAImpl();
		rolDao = new RolDaoJPAImpl();
		usuarioDao = new UsuarioDaoJPAImpl();
		viajeDao = new ViajeDaoJPAImpl();
	}
	
	@Test(groups = "DropTest" )
	public void shouldDeleteAll(){
        try {
//        	califRecorridoDao.drop();
//        	Assert.assertEquals(califRecorridoDao.listar().size(), 0);
//        	viajeDao.drop();
//        	Assert.assertEquals(viajeDao.listar().size(), 0);
//        	recorridoDao.drop();
//        	Assert.assertEquals(recorridoDao.listar().size(), 0);
//        	eventoDao.drop();
//        	Assert.assertEquals(eventoDao.listar().size(), 0);
//        	califUsuarioDao.drop();
//        	Assert.assertEquals(califUsuarioDao.listar().size(), 0);
//        	denunciaDao.drop();
//        	Assert.assertEquals(denunciaDao.listar().size(), 0);
//        	mensajeDao.drop();
//        	Assert.assertEquals(mensajeDao.listar().size(), 0);
//        	usuarioDao.drop();
//        	Assert.assertEquals(usuarioDao.listar().size(), 0);
//			rolDao.drop();
//			Assert.assertEquals(rolDao.listar().size(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
