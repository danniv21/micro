package com.claro.miclaro.validacion.comprapaquete.controller;

import com.claro.miclaro.validacion.comprapaquete.config.ApplicationProperties;
import com.claro.miclaro.validacion.comprapaquete.dto.AuditResponse;
import com.claro.miclaro.validacion.comprapaquete.dto.CompraPaqueteRequest;
import com.claro.miclaro.validacion.comprapaquete.dto.CompraPaqueteResponse;
import com.claro.miclaro.validacion.comprapaquete.exception.DBException;
import com.claro.miclaro.validacion.comprapaquete.exception.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claro.miclaro.validacion.comprapaquete.service.ICompraPaqueteService;
import com.claro.miclaro.validacion.comprapaquete.util.Constants;
import com.claro.miclaro.validacion.comprapaquete.util.Utilitario;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/validacion")
@Validated
public class CompraPaqueteController {

	private static final Logger logger = LoggerFactory.getLogger(CompraPaqueteController.class);

	@Autowired
	private ApplicationProperties properties;

	@Autowired
	private ICompraPaqueteService iCompraPaqueteService;

	@PostMapping(value = "/comprapaquete", produces = Constants.HTTP_MEDIA_TYPE_JSON)
	public ResponseEntity<CompraPaqueteResponse> validarCompraPaquete(@RequestHeader HttpHeaders httpHeaders,
			@RequestBody CompraPaqueteRequest compraPaqueteMicroserviceDTO) throws JsonProcessingException {

		logger.info("[INICIO]- CompraPaqueteController - validarCompraPaquete()");
		CompraPaqueteResponse compraPaqueteResponse = new CompraPaqueteResponse();
		HttpStatus status = HttpStatus.OK;
		MultiValueMap<String, String> headers = new HttpHeaders();

		long tiempoInicio = System.currentTimeMillis();

		try {
			compraPaqueteResponse = iCompraPaqueteService.validarCompraPaquete(httpHeaders,
					compraPaqueteMicroserviceDTO);
			status = HttpStatus.OK;
		} catch (ServiceException e) {
			AuditResponse auditResponse = new AuditResponse();
			auditResponse.setCodigoRespuesta(e.getCode());
			auditResponse.setFecha(Utilitario.parseDateFormat(Constants.FORMAT_DATE_TIME_ZONE));
			auditResponse.setDescripcionRespuesta(e.getMessage());
			auditResponse.setMetodo(properties.getMicroservicioName());				
			compraPaqueteResponse.setAuditResponse(auditResponse);
			status = e.getStatus();

			if (e.getCode().equalsIgnoreCase(properties.getValidacioncomprapaqueteCodigoIdf1())) {
				auditResponse.setIdTransaccion(Constants.STRING_EMPTY);
			} else {
				auditResponse.setIdTransaccion(httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0));
			}

		} catch (DBException e) {
			AuditResponse auditResponse = new AuditResponse();
			auditResponse.setFecha(Utilitario.parseDateFormat(Constants.FORMAT_DATE_TIME_ZONE));
			if(e.getCode().equalsIgnoreCase(properties.getValidacioncomprapaqueteCodigoIdt1())) {
				auditResponse.setCodigoRespuesta(properties.getValidacioncomprapaqueteCodigoIdt1());
				auditResponse.setDescripcionRespuesta(properties.getValidacioncomprapaqueteMensajeIdt1());
			} else {
				if(e.getCode().equalsIgnoreCase(properties.getValidacioncomprapaqueteCodigoIdt2())) {
					auditResponse.setCodigoRespuesta(properties.getValidacioncomprapaqueteCodigoIdt2());
					auditResponse.setDescripcionRespuesta(properties.getValidacioncomprapaqueteMensajeIdt2());
				} else {
					auditResponse.setCodigoRespuesta(properties.getValidacioncomprapaqueteCodigoIdt3());
					auditResponse.setDescripcionRespuesta(properties.getValidacioncomprapaqueteMensajeIdt3());
				}
			}
			compraPaqueteResponse.setAuditResponse(auditResponse);
			status = HttpStatus.BAD_REQUEST;
		}

		finally {
			logger.info("Body response microservices-validacion-comprapaquete:"
					+ Utilitario.printPrettyJSONString(compraPaqueteResponse));
			Long fin = System.currentTimeMillis() - tiempoInicio;
			logger.info("Tiempo total de proceso(ms):{} ", fin);
		}

		logger.info("[FIN]- CompraPaqueteController - validarCompraPaquete()");
		return new ResponseEntity<>(compraPaqueteResponse, headers, status);
	}
}
