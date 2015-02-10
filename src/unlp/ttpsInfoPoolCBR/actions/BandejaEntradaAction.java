package unlp.ttpsInfoPoolCBR.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.mensaje.IMensajeDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.util.Utils;
import unlp.ttpsInfoPoolCBR.vo.MensajeVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

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
	
	private List<MensajeVo> mensajes = new ArrayList<MensajeVo>();
	
	public String execute(){
		if(Utils.checkLogin()){
			UsuarioVo usuario = Utils.getUsuario();
			
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

	public List<MensajeVo> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeVo> mensajes) {
		this.mensajes = mensajes;
	}	
	
}
