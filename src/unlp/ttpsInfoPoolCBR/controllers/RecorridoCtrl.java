package unlp.ttpsInfoPoolCBR.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;

import com.google.gson.Gson;

@RestController
@RequestMapping(value="/rest/recorrido",produces="application/json",method=RequestMethod.GET)
public class RecorridoCtrl {
	
	@Autowired
	private IRecorridoDao recorridoDao;
	
	@Autowired
	private Gson gson;

//	@RequestMapping(value="/buscar")
//	public String buscar(@RequestParam("idRecorrido") String idRecorridoJson){
//		JsonResponseVo response = new JsonResponseVo();
//		try{
//			Integer idRecorrido = Integer.valueOf(idRecorridoJson);
//			RecorridoVo recorrido = recorridoDao.encontrar(idRecorrido);
//			
//			response.setOk(Boolean.TRUE);
//			response.setData(gson.toJson(recorrido));
//		}catch(Exception e){
//			response.setOk(Boolean.FALSE);
//			response.setMessage("No se pudo obtener el recorrido deseado.");
//			System.out.println("No se pudo encontrar el recorrido de id:"+idRecorridoJson+" ,error:");
//			e.printStackTrace();
//		}
//		return gson.toJson(response);
//	}
}
