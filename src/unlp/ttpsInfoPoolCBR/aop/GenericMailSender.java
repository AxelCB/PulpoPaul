package unlp.ttpsInfoPoolCBR.aop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import unlp.ttpsInfoPoolCBR.dao.rol.IRolDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.vo.DenunciaVo;
import unlp.ttpsInfoPoolCBR.vo.RolVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;


/**
 * Created by Axel on 22/01/2015.
 */

@Aspect
public class GenericMailSender {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IRolDao rolDao;
	
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender){
		this.mailSender = mailSender;
	}
	
	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@After("execution(* unlp.ttpsInfoPoolCBR.dao.denuncia.DenunciaDaoJPAImpl.guardar(..)")
	public void sendEmailAfterNewDenuncia(){//JoinPoint joinPoint
		SimpleMailMessage message = new SimpleMailMessage();
		EntityManager em = null;
		try {
			em = EntityManagerFactoryHolder.getEntityManager();
			RolVo rolAdmin = rolDao.buscarPorNombre(em,"administrador");
			List<UsuarioVo> admins = usuarioDao.listarDeRol(em,rolAdmin);
			
			
			HttpSession session = ServletActionContext.getRequest().getSession(false);
			DenunciaVo denuncia=((DenunciaVo)session.getAttribute("denuncia"));
			String mailText=denuncia.getContenido();
			
			for (UsuarioVo admin : admins) {
				message.setFrom("InfoPool@gmail.com");
				message.setTo(admin.getEmail());
				message.setSubject("Nueva Denuncia");
				message.setText(mailText);
				mailSender.send(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		
	}
}
