package unlp.ttpsInfoPoolCBR.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unlp.ttpsInfoPoolCBR.dao.recorrido.IRecorridoDao;
import unlp.ttpsInfoPoolCBR.model.JsonResponse;
import unlp.ttpsInfoPoolCBR.model.Recorrido;

import com.google.gson.Gson;

@RestController
@RequestMapping(value="/recorrido",produces="application/json",method=RequestMethod.GET)
public class RecorridoCtrl {
	
	@Autowired
	private IRecorridoDao recorridoDao;
	
	@Autowired
	private Gson gson;

	@RequestMapping(value="/buscar")
	public String buscar(@RequestParam("idRecorrido") String idRecorridoJson){
		JsonResponse response = new JsonResponse();
		try{
			Integer idRecorrido = Integer.valueOf(idRecorridoJson);
			Recorrido recorrido = recorridoDao.encontrar(idRecorrido);
			
			response.setOk(Boolean.TRUE);
			response.setData(gson.toJson(recorrido));
		}catch(Exception e){
			response.setOk(Boolean.FALSE);
			response.setMessage("No se pudo obtener el recorrido deseado.");
			System.out.println("No se pudo encontrar el recorrido de id:"+idRecorridoJson+" ,error:");
			e.printStackTrace();
		}
		return gson.toJson(response);
	}
}
