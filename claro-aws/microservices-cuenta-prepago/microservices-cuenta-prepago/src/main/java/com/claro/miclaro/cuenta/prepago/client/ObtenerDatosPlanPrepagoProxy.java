package com.claro.miclaro.cuenta.prepago.client;

import org.springframework.http.HttpHeaders;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.ConsultaPlanPrepagoResponse;

public interface ObtenerDatosPlanPrepagoProxy {
	
	ConsultaPlanPrepagoResponse obtenerdatosplan(String linea, ApplicationProperties properties, HttpHeaders httpHeaders) throws Exception;

}
