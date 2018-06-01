package com.claro.miclaro.validacion.comprapaquete.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.claro.miclaro.validacion.comprapaquete.config.ApplicationProperties;
import com.claro.miclaro.validacion.comprapaquete.dto.CompraPaqueteRequest;
import com.claro.miclaro.validacion.comprapaquete.exception.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Utilitario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Utilitario.class);
	
	
	public static DateFormat getLocalFormat(){
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSXXX", Locale.getDefault());
    	dateFormat.setTimeZone(TimeZone.getDefault());
    	return dateFormat;
    }
	
	public static String parseDateFormat(String dateformat) {
		 DateFormat sdf = new SimpleDateFormat(dateformat);
		 sdf.setTimeZone(TimeZone.getTimeZone(Constants.TIME_ZONE_LIMA));
		 return sdf.format(new Date());		
	}
	
	public static String printPrettyJSONString(Object o) throws JsonProcessingException{
    	return new ObjectMapper().setDateFormat(getLocalFormat()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter().writeValueAsString(o); 
    }
	
	public static void validarParametrosObligatorios(HttpHeaders httpHeaders, CompraPaqueteRequest compraPaqueteRequest,
			ApplicationProperties applicationProperties) throws ServiceException {
		
		boolean flagParamObligatorio;
		
		flagParamObligatorio = Utilitario.validarVacioObjecto(httpHeaders) || httpHeaders.size() == 0;
		flagParamObligatorio |= Utilitario.validarVacioObjecto(httpHeaders.get(Constants.HEADER_TIMESTAMP))
				|| httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0).isEmpty()
				|| toCalendar(httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0));
		flagParamObligatorio |= Utilitario.validarVacioObjecto(httpHeaders.get(Constants.HEADER_ID_TRANSACCION))
				|| httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0).isEmpty();
		flagParamObligatorio |= Utilitario.validarVacioObjecto(compraPaqueteRequest.getTipoCliente());
		
		if (flagParamObligatorio) {
			throw new ServiceException(applicationProperties.getValidacioncomprapaqueteCodigoIdf1(),
					applicationProperties.getValidacioncomprapaqueteMensajeIdf1(), HttpStatus.BAD_REQUEST);
		}

	}

	public static boolean validarVacioObjecto(Object objeto) {
		return objeto == Constants.OBJECT_EMPTY;
	}

	public static boolean toCalendar(final String iso8601string) {
		Calendar calendar = GregorianCalendar.getInstance();
		boolean exito = true;
		try {

			String s = iso8601string.replace("Z", "+00:00");
			if (iso8601string.length() == Constants.VEINTE) { // *** Sin Precision de Milisegundos
				s = s.substring(0, 22) + s.substring(23);
				Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault()).parse(s);
				calendar.setTime(date);
				exito = false;
			}
			if (iso8601string.length() == Constants.VEINTICUATRO) { // *** Con Precision de Milisegundos
				s = s.substring(0, 26) + s.substring(27);
				Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(s);
				calendar.setTime(date);
				exito = false;
			}
		} catch (IndexOutOfBoundsException e) {
			logger.error("Ocurrio un error al recorrer la cadena de Fecha", e);

		} catch (Exception e) {
			logger.error("Ocurrio un error al convertir a Date la cadena de la fecha", e);

		}
		return exito;
	}

}
