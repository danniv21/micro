package com.claro.miclaro.cuenta.prepago.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.AuditResponse;
import com.claro.miclaro.cuenta.prepago.dto.ConsumosPrepago;
import com.claro.miclaro.cuenta.prepago.dto.HeaderRequest;
import com.claro.miclaro.cuenta.prepago.dto.ListaOtroPaquetesActivos;
import com.claro.miclaro.cuenta.prepago.dto.ListaPaquetesActivos;
import com.claro.miclaro.cuenta.prepago.dto.ListaResumenPaquetesActivos;
import com.claro.miclaro.cuenta.prepago.dto.MicroservicePrepagoRequest;
import com.claro.miclaro.cuenta.prepago.dto.MicroservicePrepagoResponse;
import com.claro.miclaro.cuenta.prepago.dto.OtroPaqueteActivo;
import com.claro.miclaro.cuenta.prepago.dto.PaqueteActivo;
import com.claro.miclaro.cuenta.prepago.dto.ResumenPaqueteActivo;
import com.claro.miclaro.cuenta.prepago.entity.HeaderRequestBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class.
 * 
 * @author everis
 *
 */
@Component
public class Utilitarios implements Serializable {
	private static final Logger logger = LoggerFactory.getLogger(Utilitarios.class);

	private static final long serialVersionUID = -3301605591108950415L;

	public static DateFormat getLocalFormat(){
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSXXX", Locale.getDefault());
    	dateFormat.setTimeZone(TimeZone.getDefault());
    	return dateFormat;
    }
	
	public static String printPrettyJSONString(Object o) throws JsonProcessingException{
    	return new ObjectMapper().setDateFormat(getLocalFormat()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter().writeValueAsString(o); 
    }
	
	public static HeaderRequest getHeaderDataPower(HttpHeaders httpHeaders, ApplicationProperties properties, String modulo, String operacion){
		
		HeaderRequest headerRequest = new HeaderRequest();
		headerRequest.setConsumer(properties.getHeaderConsumer());
		headerRequest.setCountry(properties.getHeaderCountry());
		headerRequest.setDispositivo(properties.getHeaderDispositivo());
		headerRequest.setLanguage(properties.getHeaderLanguage());
		headerRequest.setModulo(modulo);
		headerRequest.setMsgType(properties.getHeaderMsgType());
		headerRequest.setOperation(operacion);
		headerRequest.setPid(httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) != null ? httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) :  Constants.CADENA_VACIA);
		headerRequest.setSystem(properties.getHeaderSystem());
		headerRequest.setTimestamp(httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0) != null ? httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0) :  Constants.CADENA_VACIA);
		headerRequest.setUserId(properties.getHeaderUserId());
		headerRequest.setWsIp(properties.getHeaderWsIp());
		
		return headerRequest;
	}
	
	public static HttpHeaders getHeader(HttpHeaders httpHeaders, ApplicationProperties properties, String linea){
		
		HttpHeaders headers = new HttpHeaders();
		
		//Header OSB
		headers.add(Constants.HEADER_USUARIO_APLICACION, properties.getHeaderUserId());
		headers.add(Constants.HEADER_ID_TRANSACCION_ESB, Constants.CADENA_VACIA );
		headers.add(Constants.HEADER_USUARIO_SESION, linea);
		headers.add(Constants.HEADER_ID_TRANSACCION_NEGOCIO, httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) != null ? httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) :  Constants.CADENA_VACIA);
		headers.add(Constants.HEADER_CANAL, properties.getHeaderCanal());
		headers.add(Constants.HEADER_ID_APLICACION, properties.getHeaderDispositivo());
	    
		//Header REST
		headers.add(Constants.HEADER_TIMESTAMP, httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0) != null ? httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0) :  Constants.CADENA_VACIA);
		headers.add(Constants.HEADER_MESSAGE_ID, UUID.randomUUID().toString());
		headers.add(Constants.HEADER_ACCEPT, MediaType.APPLICATION_JSON.toString());
		headers.add(Constants.HEADER_USER_ID, properties.getHeaderUserId());
		headers.add(Constants.HEADER_ID_TRANSACCION, httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) != null ? httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) :  Constants.CADENA_VACIA);
		
		//Header compartido
		headers.add(Constants.HEADER_AUTHORIZATION, properties.getHeaderAuthorization());
	    
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
		return headers;
	}
	
	public static Calendar toCalendar(final String iso8601string){
        Calendar calendar = GregorianCalendar.getInstance();
        try {
        	 boolean exito = false;
        	String s = iso8601string.replace("Z", "+00:00");
        	if (iso8601string.length() == Constants.VEINTE) { // *** Sin Precision de Milisegundos
        		s = s.substring(0, 22) + s.substring(23);
        		Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ",Locale.getDefault()).parse(s);
        		calendar.setTime(date);
        		exito = true;
			}
        	if (iso8601string.length() == Constants.VEINTICUATRO) { // *** Con Precision de Milisegundos
        		s = s.substring(0, 26) + s.substring(27);
        		Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ",Locale.getDefault()).parse(s);
        		calendar.setTime(date);
        		exito = true;
			}
        	if (!exito) {
				calendar = null;
			}
        	
        } catch (IndexOutOfBoundsException e) {
        	logger.error("Ocurrio un error al recorrer la cadena de Fecha" , e);
        	calendar = null;
        } catch (Exception e) {
        	logger.error("Ocurrio un error al convertir a Date la cadena de la fecha" , e);
        	calendar = null;
		}
        return calendar;
    }
	
	public static Object validateParameterInput(HttpHeaders httpHeaders, ApplicationProperties properties, MicroservicePrepagoRequest request) throws JsonProcessingException{
		logger.info("Datos del Header Request: "+Utilitarios.printPrettyJSONString(httpHeaders));
		logger.info("Datos del Body Request: "+Utilitarios.printPrettyJSONString(request));
		logger.info("########################### [PRE-REQUISITOS][INICIO].... ACTIVIDAD 01: VALIDANDO PARAMETROS OBLIGATORIOS #### ");
		MicroservicePrepagoResponse microservicePrepagoResponse = null;
		boolean isHeader = false;
		boolean isBody = false;
		boolean isTimeStamp = false;
		HeaderRequestBean header = new HeaderRequestBean(httpHeaders);
		MicroservicePrepagoRequest microservicioRequest = new MicroservicePrepagoRequest(request);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		logger.info("########################### ........... Evaluando Header ....  ");
		Set<ConstraintViolation<HeaderRequestBean>> constraintViolationsHeader = validator.validate(header);
		if (!constraintViolationsHeader.isEmpty()) {
			for (ConstraintViolation<?> c : constraintViolationsHeader) {
				if (c.getPropertyPath().toString().equals(Constants.HEADER_TIMESTAMP)) {
					if (httpHeaders.get(Constants.HEADER_TIMESTAMP) != null) {
						if (httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0) != null
								&& !httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0).isEmpty()) {
							isTimeStamp = true;
						}
					}
				}
			}
			isHeader = true;
		}
		
		logger.info("########################### ........... Evaluando Body ....  ");
		Set<ConstraintViolation<MicroservicePrepagoRequest>> constraintViolationsBody = validator.validate(microservicioRequest);
		if(!constraintViolationsBody.isEmpty()){
			isBody = true;
		}
		
		if(isHeader || isBody){
			String strCodigo = Constants.CADENA_VACIA;
			String strMensaje = Constants.CADENA_VACIA;
			microservicePrepagoResponse = new MicroservicePrepagoResponse();
			AuditResponse auditResponse = new AuditResponse();
			auditResponse.setServicio(Constants.CADENA_SERVICIO);
			auditResponse.setMetodo(Constants.CADENA_METODO);
			auditResponse.setMsisdn(request.getMsisdn());
			if(httpHeaders.get(Constants.HEADER_ID_TRANSACCION)!=null){
				auditResponse.setIdTransaccion(httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) != null ? httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) :  Constants.CADENA_VACIA);
			}else{
				auditResponse.setIdTransaccion(Constants.CADENA_VACIA);
			}
			if(isTimeStamp){
				strCodigo = properties.getCodigoRespuestaIDT5();
				strMensaje = properties.getMensajeRespuestaIDT5();
			}else{
				strCodigo = properties.getCodigoRespuestaIDF1();
				strMensaje = properties.getMensajeRespuestaIDF1();
			}
			
			auditResponse.setCodigoRespuesta(strCodigo);
			auditResponse.setDescripcionRespuesta(strMensaje);
			microservicePrepagoResponse.setAuditResponse(auditResponse);
			logger.info("########################### [PRE-REQUISITOS][FIN]....ACTIVIDAD 01: VALIDANDO PARAMETROS OBLIGATORIOS #### ");
		}
		return microservicePrepagoResponse;
	}
	
	public static String getTimeStamp(){
		
		DateFormat sdf = new SimpleDateFormat(Constants.FORMAT_DATE_TIME_ZONE);
		sdf.setTimeZone(TimeZone.getTimeZone(Constants.TIME_ZONE_LIMA));
		
		return sdf.format(new Date());
	}
	
	public static String getTimeStamp(String format){
		
		DateFormat sdf = new SimpleDateFormat(format);
		
		return sdf.format(new Date());
	}
	
	public static ConsumosPrepago setDatosVacios(ConsumosPrepago consumosPrepago){
		
		ListaOtroPaquetesActivos objetoListaOtrosPaquetesActivos = new ListaOtroPaquetesActivos();
		List<OtroPaqueteActivo> listaOtroPaquetesActivos = new ArrayList<>();
		objetoListaOtrosPaquetesActivos.setOtroPaqueteActivo(listaOtroPaquetesActivos);
		
		ListaPaquetesActivos objetoListaPaquetesActivos = new ListaPaquetesActivos();
		List<PaqueteActivo> listaPaqueteActivo = new ArrayList<>();
		objetoListaPaquetesActivos.setPaqueteActivo(listaPaqueteActivo);
		
		ListaResumenPaquetesActivos objetoListaResumenPaquetesActivos = new ListaResumenPaquetesActivos();
		List<ResumenPaqueteActivo> listaResumenPaqueteActivo = new ArrayList<>();
		objetoListaResumenPaquetesActivos.setResumenPaqueteActivo(listaResumenPaqueteActivo);
		
		String fecha = getTimeStamp();
		
		consumosPrepago.setListaOtroPaquetesActivos(objetoListaOtrosPaquetesActivos);
		consumosPrepago.setListaPaquetesActivos(objetoListaPaquetesActivos);
		consumosPrepago.setListaResumenPaquetesActivos(objetoListaResumenPaquetesActivos);
		consumosPrepago.setFechaActualizacion(fecha);
		
		return consumosPrepago;
		
	}
	
}