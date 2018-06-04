package com.claro.miclaro.validacion.comprapaquete.util;

import org.springframework.http.MediaType;

public class Constants {
	//HTTP Constants
	public static final String HTTP_MEDIA_TYPE_JSON = MediaType.APPLICATION_JSON_UTF8_VALUE;
	//HTTP HEADERS
	public static final String HEADER_TIMESTAMP = "timestamp";
	public static final String HEADER_ID_TRANSACCION = "idTransaccion";
	
	//RESPONSE ERROR
	public static final String RESPONSE_EXCEPTION_TIMEOUT= "TIMEOUT";
	public static final String RESPONSE_EXCEPTION_TIMEOUT2= "TIME OUT";
	
	
	public static final Object OBJECT_EMPTY = null;
	public static final String STRING_EMPTY = "";
	
	//EXPRESSION FORMATS
	public static final String FORMAT_DATE_TIME_ZONE  = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	public static final String TIME_ZONE_LIMA = "America/Lima";
	
	//CONSTANTS
	public static final int VEINTE = 20;
	public static final int VEINTICUATRO = 24;
	
	public static String CADENA_VOZ 			= "VOZ";
	public static String CADENA_SMS 			= "SMS";
	public static String CADENA_DATOS 			= "DATOS";
}
