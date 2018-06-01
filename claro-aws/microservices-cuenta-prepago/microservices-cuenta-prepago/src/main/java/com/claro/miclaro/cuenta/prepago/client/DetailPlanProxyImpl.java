package com.claro.miclaro.cuenta.prepago.client;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.DetallePlanResponse;
import com.claro.miclaro.cuenta.prepago.exception.WSException;
import com.claro.miclaro.cuenta.prepago.util.Constants;
import com.claro.miclaro.cuenta.prepago.util.Utilitarios;
import com.google.gson.Gson;

@Repository
public class DetailPlanProxyImpl implements DetailPlanProxy{
	
	private static final Logger logger = LoggerFactory.getLogger(DetailPlanProxyImpl.class);

	@Override
	public DetallePlanResponse obtenerDetallePlan(String subTipo, ApplicationProperties properties) throws Exception {
		
		long tiempoInicio = System.currentTimeMillis();
		String msjTransaccion2 = "[obtenerDetallePlan] ";
		
		String metodo = "detailplan";
		String nombreWS = "plan";
		
		DetallePlanResponse response = null;
		
		Gson gsonReq = new Gson();
		String uri = properties.getUriDetailPlan()+subTipo;
		
		try {
			logger.info(msjTransaccion2 + "[INICIO de metodo: " + metodo + "]");
			logger.info(msjTransaccion2 + "Se invoca al Api Rest, URL={}",uri);
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(0,new StringHttpMessageConverter(Charset.forName("UTF-8")));
			
			SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
			rf.setConnectTimeout(Integer.parseInt(properties.getTimeOutConnectionDetailPlan()));
			rf.setReadTimeout(Integer.parseInt(properties.getTimeOutRequestDetailPlan()));
			
			logger.info(msjTransaccion2 + "Tiempo de Timeout de Conexion: " + properties.getTimeOutConnectionDetailPlan());
			logger.info(msjTransaccion2 + "Tiempo de Timeout de Ejecucion: " + properties.getTimeOutRequestDetailPlan());
			
			logger.info(msjTransaccion2 + "Dato de entrada: "+subTipo);
			
			long tiempoInicioWS = System.currentTimeMillis();
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
			logger.info(msjTransaccion2 + "Tiempo total de proceso del llamado del servicio REST: {} Metodo: {} (ms):{} ", "/plan/detailplan/", metodo, System.currentTimeMillis() - tiempoInicioWS);
			response = gsonReq.fromJson(responseEntity.getBody().toString(),
					DetallePlanResponse.class);
			
			logger.info(msjTransaccion2 + "Response Header: "
					+ Utilitarios.printPrettyJSONString(responseEntity.getHeaders()));
			
			logger.info(msjTransaccion2 + "Response Status: [{}]", responseEntity.getStatusCode().value());
			
			logger.info(msjTransaccion2 + "Response Body:"
					+ Utilitarios.printPrettyJSONString(response));
			
		} catch (Exception e) {
			logger.error(msjTransaccion2 + "ERROR: [Exception] - [" + e.getMessage() + "] ", e);
			if (e.getMessage().toUpperCase().contains(Constants.TIMEOUTEXCEP)
					|| e.getMessage().toUpperCase().contains(Constants.TIMEOUTEXCEP2)) {
				throw new WSException(properties.getCodigoRespuestaIDT1(),
						properties.getMensajeRespuestaIDT1().replace("$me", metodo).replace("$ws", nombreWS));
			}else{
				String codigo = properties.getCodigoRespuestaIDT2();
				String mensaje = properties.getMensajeRespuestaIDT2().replace("$ws", nombreWS).replace("$me", metodo); 
				throw new WSException(codigo, mensaje);
			}
		} finally {
			logger.info(msjTransaccion2 + "Tiempo total de proceso(ms):{} ", System.currentTimeMillis() - tiempoInicio);
			logger.info(msjTransaccion2 + "[Fin de metodo: " + metodo + "]");
		}
		
		return response;
	}

}
