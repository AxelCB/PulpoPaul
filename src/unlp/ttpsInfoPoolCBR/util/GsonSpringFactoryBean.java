package unlp.ttpsInfoPoolCBR.util;

import org.springframework.beans.factory.FactoryBean;

import unlp.ttpsInfoPoolCBR.vo.CalificacionRecorridoVo;
import unlp.ttpsInfoPoolCBR.vo.EventoVo;
import unlp.ttpsInfoPoolCBR.vo.UsuarioVo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Factory Bean for Gson Serializer/Deserializer
 * 
 * @author acollardbovy
 * 
 */
public class GsonSpringFactoryBean implements FactoryBean<Gson> {

	/**
	 * Singleton Instance.
	 */
	private Gson singleton = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public Gson getObject() throws Exception {
		if (this.singleton == null) {
			// we create the GsonBuilder
			GsonBuilder gsb = new GsonBuilder();

			gsb.setDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "misCalificaciones"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "calificacionesHechas"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "recorridosCalificados"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "misDenuncias"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "denunciasHechas"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "bandejaEntrada"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "bandejaSalida"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "recorridosMios"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "recorridosViajo"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "historial"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(UsuarioVo.class, false, "misViajes"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(EventoVo.class, false, "recorridos"));
			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(CalificacionRecorridoVo.class, false, "calificado"));
//			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(RecorridoVo.class, false, "pasajerosHistorial"));
//			gsb.addSerializationExclusionStrategy(new CustomExclusionStrategy(RecorridoVo.class, false, "propietario"));

			// returns the created builder
			this.singleton = gsb.create();
		}

		// returns the singleton
		return this.singleton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		return Gson.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
