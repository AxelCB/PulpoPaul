package unlp.ttpsInfoPoolCBR.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.vo.RecorridoVo;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;



@Action(value = "recorrido")
public class RecorridoAction extends ActionSupport{

    private static final long serialVersionUID = 1L;

    @Autowired
    IRecorridoDao recorridoDao; 
    
    @Autowired
    Gson gson;
    
    private Integer idRecorrido;

    @Action(value="buscar")
    public String recorridoNuevoAgregar(){
    	try {
    		HttpServletRequest request = ServletActionContext.getRequest();
    		idRecorrido= Integer.valueOf(request.getParameter("idRecorrido"));
    		
			RecorridoVo recorrido = recorridoDao.encontrar(idRecorrido);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
		    response.getWriter().write(gson.toJson(recorrido));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    //Getters y Setters
	public IRecorridoDao getRecorridoDao() {
		return recorridoDao;
	}
	public void setRecorridoDao(IRecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
	}
}
