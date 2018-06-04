package com.claro.miclaro.cuenta.prepago.service;

import org.springframework.http.HttpHeaders;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.MicroservicePrepagoResponse;
import com.claro.miclaro.cuenta.prepago.exception.WSException;

public interface PrepagoService {
	
	MicroservicePrepagoResponse consultarPrepago(String idTransaccion, HttpHeaders httpHeaders, String number, ApplicationProperties properties) throws WSException, Exception;

}
