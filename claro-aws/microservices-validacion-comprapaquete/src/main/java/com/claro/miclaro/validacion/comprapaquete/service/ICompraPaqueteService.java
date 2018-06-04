package com.claro.miclaro.validacion.comprapaquete.service;

import org.springframework.http.HttpHeaders;

import com.claro.miclaro.validacion.comprapaquete.dto.CompraPaqueteRequest;
import com.claro.miclaro.validacion.comprapaquete.dto.CompraPaqueteResponse;
import com.claro.miclaro.validacion.comprapaquete.exception.DBException;
import com.claro.miclaro.validacion.comprapaquete.exception.ServiceException;

public interface ICompraPaqueteService {
	CompraPaqueteResponse validarCompraPaquete(HttpHeaders httpHeaders, CompraPaqueteRequest compraPaqueteRequestDTO) throws ServiceException, DBException;
}
