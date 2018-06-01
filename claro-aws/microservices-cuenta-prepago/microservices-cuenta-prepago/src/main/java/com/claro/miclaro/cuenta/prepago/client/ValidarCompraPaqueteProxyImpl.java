package com.claro.miclaro.cuenta.prepago.client;

import java.nio.charset.Charset;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.ResumenPaqueteActivo;
import com.claro.miclaro.cuenta.prepago.util.Constants;
import com.claro.miclaro.cuenta.prepago.util.Utilitarios;
import com.claro.miclaro.cuenta.prepago.dto.CompraPaqueteRequest;
import com.claro.miclaro.cuenta.prepago.dto.CompraPaqueteResponse;
import com.google.gson.Gson;

@Repository
public class ValidarCompraPaqueteProxyImpl implements ValidarCompraPaqueteProxy{
	
	private static final Logger logger = LoggerFactory.getLogger(ValidarCompraPaqueteProxyImpl.class);

	@Override
	public CompraPaqueteResponse validarCompraPaquete(List<ResumenPaqueteActivo> lista, ApplicationProperties properties,
			HttpHeaders httpHeaders) throws Exception {
		
		long tiempoInicio = System.currentTimeMillis();
		String msjTransaccion2 = "[validarCompraPaquete] ";
		
		CompraPaqueteResponse response = null;
		String metodo = "comprapaquete";
		
		Gson gsonReq = new Gson();
		String uri = properties.getUriValidacionCompraPaquete();
		
		logger.info(msjTransaccion2 + "[INICIO de metodo: " + metodo + "]");
		logger.info(msjTransaccion2 + "Se invoca al Api Rest, URL={}",uri);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0,new StringHttpMessageConverter(Charset.forName("UTF-8")));
		
		SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
		rf.setConnectTimeout(Integer.parseInt(properties.getTimeOutConnectionCompraPaquete()));
		rf.setReadTimeout(Integer.parseInt(properties.getTimeOutRequestCompraPaquete()));
		
		logger.info(msjTransaccion2 + "Tiempo de Timeout de Conexion: " + properties.getTimeOutConnectionCompraPaquete());
		logger.info(msjTransaccion2 + "Tiempo de Timeout de Ejecucion: " + properties.getTimeOutRequestCompraPaquete());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add(Constants.HEADER_ID_TRANSACCION, httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0));
		headers.add(Constants.HEADER_TIMESTAMP, Utilitarios.getTimeStamp(Constants.FORMAT_DATE_TIME_ZONE_Z));
		
		CompraPaqueteRequest request = new CompraPaqueteRequest();
		request.setTipoCliente(Constants.CADENA_PREPAGO);
		request.setResumenBolsaActiva(lista);
		
		logger.info(msjTransaccion2 + "Request Header: "
				+ Utilitarios.printPrettyJSONString(headers));
		
		logger.info(msjTransaccion2 + "Request Body: "
				+ Utilitarios.printPrettyJSONString(request));
		
		HttpEntity<String> entity = new HttpEntity<String>(gsonReq.toJson(request), headers);
		
		long tiempoInicioWS = System.currentTimeMillis();
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, entity, String.class);
		
		logger.info(msjTransaccion2 + "Tiempo total de proceso del llamado del servicio REST: {} Metodo: {} (ms):{} ", "/validacion/comprapaquete", metodo, System.currentTimeMillis() - tiempoInicioWS);
		
		response = gsonReq.fromJson(responseEntity.getBody().toString(),
				CompraPaqueteResponse.class);
		
		logger.info(msjTransaccion2 + "Response Header: "
				+ Utilitarios.printPrettyJSONString(responseEntity.getHeaders()));
		
		logger.info(msjTransaccion2 + "Response Status: [{}]", responseEntity.getStatusCode().value());
		
		logger.info(msjTransaccion2 + "Response Body:"
				+ Utilitarios.printPrettyJSONString(response));
		
		logger.info(msjTransaccion2 + "Tiempo total de proceso(ms):{} ", System.currentTimeMillis() - tiempoInicio);
		logger.info(msjTransaccion2 + "[Fin de metodo: " + metodo + "]");
		
		if(!response.getAuditResponse().getCodigoRespuesta().equalsIgnoreCase(Constants.CODIGO_CERO)){
			throw new Exception();
		}
		
		return response;
	}

}
