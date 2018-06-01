package com.claro.miclaro.cuenta.prepago.client;

import org.springframework.http.HttpHeaders;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.ConsumosPrepagoResponse;

public interface ConsumosPrepagoProxy {
	
	ConsumosPrepagoResponse consultaresumen(String linea, ApplicationProperties properties, HttpHeaders httpHeaders) throws Exception;

}
