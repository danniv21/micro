package com.claro.miclaro.cuenta.prepago.client;

import java.util.List;

import org.springframework.http.HttpHeaders;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.ResumenPaqueteActivo;
import com.claro.miclaro.cuenta.prepago.dto.CompraPaqueteResponse;

public interface ValidarCompraPaqueteProxy {
	
	CompraPaqueteResponse validarCompraPaquete(List<ResumenPaqueteActivo> lista, ApplicationProperties properties, HttpHeaders httpHeaders) throws Exception;

}
