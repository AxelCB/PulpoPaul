package unlp.ttpsInfoPoolCBR.aop;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.vo.MensajeVo;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

/**
 * Sends messages to users by aop
 * @author axel
 *
 */
@Aspect
public class MessageSenderAop {
	
	@Autowired
	private IMensajeDao mensajeDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@After("execution(* unlp.ttpsInfoPoolCBR.dao.recorrido.RecorridoDaoJPAImpl.eliminarPasajero(..))")
	public void avisarPasajeroDespuesDeExpulsionDeRecorrido(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		EntityManager em = null;
		UsuarioVo pasajeroEliminado=(UsuarioVo)args[2];
		RecorridoVo recorrido=(RecorridoVo)args[1];
		try{
			em = EntityManagerFactoryHolder.getEntityManager();
			Calendar calendar = Calendar.getInstance();
			
			//Creación de mensaje
			MensajeVo mensaje = new MensajeVo();
			
			//Seteo de los campos que correspondan
			/**********************************************************************/
			/*         SANTI SI TENES QUE CAMBIAR EL MENSAJE MIRÁ ACÁ             */
			/**********************************************************************/
			
			mensaje.setEmisor(recorrido.getPropietario());
			mensaje.setReceptor(pasajeroEliminado);
			mensaje.setFecha(new Date(calendar.getTimeInMillis()));
			mensaje.setAsunto("Expulsión de un Recorrido");
			mensaje.setContenido("Usted ha sido expulsado/a del recorrido "+recorrido.getNombre()+".");
			
			//Esto es necesario? para que está el campo recorrido?
			//mensaje.setRecorrido(recorrido);
			
			this.getMensajeDao().guardar(em, mensaje);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			em.close();
		}
	}

	public IMensajeDao getMensajeDao() {
		return mensajeDao;
	}

	public void setMensajeDao(IMensajeDao mensajeDao) {
		this.mensajeDao = mensajeDao;
	}

	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
