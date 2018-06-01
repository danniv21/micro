package com.claro.miclaro.cuenta.prepago.validation;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.AuditResponse;
import com.claro.miclaro.cuenta.prepago.dto.MicroservicePrepagoResponse;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Autowired
    private ApplicationProperties properties;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public MicroservicePrepagoResponse processValidationError(MethodArgumentNotValidException ex) {
		logger.error("ERROR: [Exception] - [" + ex.getMessage() + "] ", ex);
		MicroservicePrepagoResponse response = new MicroservicePrepagoResponse();
		AuditResponse auditResponse = new AuditResponse();
		
		auditResponse.setCodigoRespuesta(properties.getCodigoRespuestaIDT5());
		auditResponse.setDescripcionRespuesta(properties.getMensajeRespuestaIDT5());
		response.setAuditResponse(auditResponse);
		
		return response;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public MicroservicePrepagoResponse handle(ConstraintViolationException exception) {
		logger.error("ERROR: [Exception] - [" + exception.getMessage() + "] ", exception);
		MicroservicePrepagoResponse response = new MicroservicePrepagoResponse();
		AuditResponse auditResponse = new AuditResponse();
		
		auditResponse.setCodigoRespuesta(properties.getCodigoRespuestaIDT5());
		auditResponse.setDescripcionRespuesta(properties.getMensajeRespuestaIDT5());
		response.setAuditResponse(auditResponse);
		
		return response;
	}

}
