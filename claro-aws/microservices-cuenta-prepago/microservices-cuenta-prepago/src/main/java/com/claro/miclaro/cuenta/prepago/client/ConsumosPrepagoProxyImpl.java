package com.claro.miclaro.cuenta.prepago.client;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.BodyRequest;
import com.claro.miclaro.cuenta.prepago.dto.ConsumosPrepagoRequest;
import com.claro.miclaro.cuenta.prepago.dto.ConsumosPrepagoResponse;
import com.claro.miclaro.cuenta.prepago.dto.HeaderBeanRequest;
import com.claro.miclaro.cuenta.prepago.dto.HeaderRequest;
import com.claro.miclaro.cuenta.prepago.dto.MessageRequest;
import com.claro.miclaro.cuenta.prepago.exception.WSException;
import com.claro.miclaro.cuenta.prepago.util.Constants;
import com.claro.miclaro.cuenta.prepago.util.Utilitarios;
import com.google.gson.Gson;

@Repository
public class ConsumosPrepagoProxyImpl implements ConsumosPrepagoProxy{
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumosPrepagoProxyImpl.class);

	@Override
	public ConsumosPrepagoResponse consultaresumen(String linea, ApplicationProperties properties,
			HttpHeaders httpHeaders) throws Exception {
		
		long tiempoInicio = System.currentTimeMillis();
		String msjTransaccion2 = "[consultaresumen] ";
		
		ConsumosPrepagoResponse response = null;
		String metodo = "consultaresumen";
		String nombreWS = "consumosprepago";
		
		Gson gsonReq = new Gson();
		String uri = properties.getUriConsumosPrepago();
		
		try {
			
			logger.info(msjTransaccion2 + "[INICIO de metodo: " + metodo + "]");
			logger.info(msjTransaccion2 + "Se invoca al Api Rest, URL={}",uri);
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(0,new StringHttpMessageConverter(Charset.forName("UTF-8")));
			
			SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
			rf.setConnectTimeout(Integer.parseInt(properties.getTimeOutConnectionConsultaPlanPrepago()));
			rf.setReadTimeout(Integer.parseInt(properties.getTimeOutRequestConsultaPlanPrepago()));
			
			logger.info(msjTransaccion2 + "Tiempo de Timeout de Conexion: " + properties.getTimeOutConnectionConsumosPrepago());
			logger.info(msjTransaccion2 + "Tiempo de Timeout de Ejecucion: " + properties.getTimeOutRequestConsumosPrepago());
			
			ConsumosPrepagoRequest request = new ConsumosPrepagoRequest();
			MessageRequest messageRequest = new MessageRequest();
			
			HeaderRequest headerRequest = Utilitarios.getHeaderDataPower(httpHeaders, properties, properties.getHeaderModuloConsumosPrepago(), properties.getHeaderOperationConsultaResumen());
			
			HeaderBeanRequest headerBeanRequest = new HeaderBeanRequest();
			headerBeanRequest.setHeaderRequest(headerRequest);
			messageRequest.setHeader(headerBeanRequest);
			BodyRequest bodyRequest = new BodyRequest();
			bodyRequest.setMsisdn(linea);
			messageRequest.setBody(bodyRequest);
			request.setMessageRequest(messageRequest);
			
			HttpHeaders headers = Utilitarios.getHeader(httpHeaders, properties, linea);
			
			logger.info(msjTransaccion2 + "Request Header: "
					+ Utilitarios.printPrettyJSONString(headers));
			
			logger.info(msjTransaccion2 + "Request Body: "
					+ Utilitarios.printPrettyJSONString(request));
			
			HttpEntity<String> entity = new HttpEntity<String>(gsonReq.toJson(request), headers);
			
			long tiempoInicioWS = System.currentTimeMillis();
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, entity, String.class);
			
			logger.info(msjTransaccion2 + "Tiempo total de proceso del llamado del servicio REST: {} Metodo: {} (ms):{} ", "/consumosprepago/consultaresumen", metodo, System.currentTimeMillis() - tiempoInicioWS);
			
			response = gsonReq.fromJson(responseEntity.getBody().toString(),
					ConsumosPrepagoResponse.class);
			
			logger.info(msjTransaccion2 + "Response Header: "
					+ Utilitarios.printPrettyJSONString(responseEntity.getHeaders()));
			
			logger.info(msjTransaccion2 + "Response Status: [{}]", responseEntity.getStatusCode().value());
			
			logger.info(msjTransaccion2 + "Response Body:"
					+ Utilitarios.printPrettyJSONString(response));
			
			if (response.getMessageResponse() != null) {
				if (!response.getMessageResponse().getHeader().getHeaderResponse().getStatus().getCode()
						.equals(Constants.CODIGO_CERO)) {
					throw new WSException(properties.getCodigoRespuestaIDF2(),
							properties.getMensajeRespuestaIDF2().replace("$me", metodo).replace("$ws", nombreWS));
				}
				if (!response.getMessageResponse().getBody().getCodigoRespuesta()
						.equals(Constants.CODIGO_CERO) && !response.getMessageResponse().getBody().getCodigoRespuesta()
						.equals(Constants.CODIGO_DOS)) {
					throw new WSException(properties.getCodigoRespuestaIDF2(),
							properties.getMensajeRespuestaIDF2().replace("$me", metodo).replace("$ws", nombreWS));
				}
			} else{
				throw new WSException(properties.getCodigoRespuestaIDT2(),
						properties.getMensajeRespuestaIDT2().replace("$ws", nombreWS).replace("$me", metodo));
			}
		} catch (Exception e) {
			logger.error(msjTransaccion2 + "ERROR: [Exception] - [" + e.getMessage() + "] ", e);
			if (e.getMessage().toUpperCase().contains(Constants.TIMEOUTEXCEP)
					|| e.getMessage().toUpperCase().contains(Constants.TIMEOUTEXCEP2)) {
				throw new WSException(properties.getCodigoRespuestaIDT1(),
						properties.getMensajeRespuestaIDT1().replace("$me", metodo).replace("$ws", nombreWS));
			} else{
				String codigo = properties.getCodigoRespuestaIDT2();
				String mensaje = properties.getMensajeRespuestaIDT2().replace("$ws", nombreWS).replace("$me", metodo); 
				if(e instanceof WSException){
					codigo = ((WSException) e).getCode();
					mensaje = ((WSException) e).getMessage();
				}
				throw new WSException(codigo, mensaje);
			}
		} finally {
			logger.info(msjTransaccion2 + "Tiempo total de proceso(ms):{} ", System.currentTimeMillis() - tiempoInicio);
			logger.info(msjTransaccion2 + "[Fin de metodo: " + metodo + "]");
		}
		return response;
	}

}
