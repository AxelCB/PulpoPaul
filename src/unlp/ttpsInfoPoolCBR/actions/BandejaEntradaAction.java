package unlp.ttpsInfoPoolCBR.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.model.Mensaje;
import unlp.ttpsInfoPoolCBR.model.Usuario;
import unlp.ttpsInfoPoolCBR.util.Utils;

@Action(value = "bandejaEntrada")
@Results({
	@Result(name = "exito", location = "/viajero/bandejaEntrada.jsp"),
	@Result(name = "input", location = "/viajero/bandejaEntrada.jsp"),
	@Result(name = "nologed", location = "index", type = "chain")
})
public class BandejaEntradaAction {

	@Autowired
	IUsuarioDao usuarioDao;
	
	@Autowired
	IMensajeDao mensajeDao;
	
	private List<Mensaje> mensajes;
	
	public String execute(){
		if(Utils.checkLogin()){
			Usuario usuario = Utils.getUsuario();
			/*Usuario remitente = null;
			try {
				remitente = usuarioDao.buscarPorEmail("viajero@viajero");
			} catch (Exception e) {
				e.printStackTrace();
			}
			Mensaje mensaje = new Mensaje(
											"hola que tal", 
											"quisiera que me lleves en tu triciclo", 
											Boolean.FALSE,
											usuario,
											remitente
										);
			try {
				mensajeDao.guardar(mensaje);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
			try{
				usuario = usuarioDao.traerBandejaEntrada(usuario);
				mensajes = usuario.getBandejaEntrada();
			}
			catch(Exception ex){
				ex.printStackTrace();
				return "input";
			}
			
			return "exito";
		}
		else{
			return "nologed";
		}
		
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}	
	
}
