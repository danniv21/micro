package com.claro.miclaro.cuenta.prepago.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.AuditResponse;
import com.claro.miclaro.cuenta.prepago.dto.AuditStatus;
import com.claro.miclaro.cuenta.prepago.dto.ConsumosPrepago;
import com.claro.miclaro.cuenta.prepago.dto.ListaOtroPaquetesActivos;
import com.claro.miclaro.cuenta.prepago.dto.ListaPaquetesActivos;
import com.claro.miclaro.cuenta.prepago.dto.ListaResumenPaquetesActivos;
import com.claro.miclaro.cuenta.prepago.dto.MicroservicePrepagoRequest;
import com.claro.miclaro.cuenta.prepago.dto.MicroservicePrepagoResponse;
import com.claro.miclaro.cuenta.prepago.dto.ObtenerDatosPlan;
import com.claro.miclaro.cuenta.prepago.dto.OtroPaqueteActivo;
import com.claro.miclaro.cuenta.prepago.dto.PaqueteActivo;
import com.claro.miclaro.cuenta.prepago.dto.ResumenPaqueteActivo;
import com.claro.miclaro.cuenta.prepago.exception.DBException;
import com.claro.miclaro.cuenta.prepago.exception.WSException;
import com.claro.miclaro.cuenta.prepago.service.PrepagoService;
import com.claro.miclaro.cuenta.prepago.util.Constants;
import com.claro.miclaro.cuenta.prepago.util.Utilitarios;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/cuenta/prepago")
@Validated
public class PrepagoController {

	private static final Logger logger = LoggerFactory.getLogger(PrepagoController.class);

	@Autowired
	private PrepagoService prepagoService;
	
	@Autowired
    private ApplicationProperties properties;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MicroservicePrepagoResponse> consultarPrepago(@RequestHeader HttpHeaders httpHeaders,
    		@RequestBody MicroservicePrepagoRequest request) throws JsonProcessingException{
    	long tiempoInicio = System.currentTimeMillis();
    	Object object= Utilitarios.validateParameterInput(httpHeaders, properties, request);
    	AuditStatus audit = new AuditStatus();
    	audit.setMsisdn(request.getMsisdn());
    	audit.setTipo(Constants.CADENA_PREPAGO);
    	String statusTransaccion = Constants.CADENA_SUCCESS;
    	String idTransaccion = Constants.CADENA_VACIA;
    	if(httpHeaders.get(Constants.HEADER_ID_TRANSACCION)!=null){
    		idTransaccion = httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) != null ? httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) :  Constants.CADENA_VACIA;
    	}
    	MDC.put("idtransaccion", idTransaccion);
		String trazabilidad = "["+ idTransaccion + "]";
		logger.info(trazabilidad + "[INICIO] - Call PrepagoController.consultarPrepago()");
		MicroservicePrepagoResponse microservicePrepagoResponse = new MicroservicePrepagoResponse();
		AuditResponse auditResponse = new AuditResponse();
		auditResponse.setServicio(Constants.CADENA_SERVICIO);
		auditResponse.setMetodo(Constants.CADENA_METODO);
		auditResponse.setMsisdn(request.getMsisdn());
		HttpStatus status = HttpStatus.OK;
		
    	try {
    		
    		if(object != null){
    			microservicePrepagoResponse = (MicroservicePrepagoResponse) object;
    			statusTransaccion = Constants.CADENA_FAILED;
    		}else{
    			microservicePrepagoResponse = prepagoService.consultarPrepago(idTransaccion, httpHeaders, request.getMsisdn(), properties);
    		}
		} catch (Exception e) {
			logger.error(trazabilidad + "ERROR: [Exception] - [" + e.getMessage() + "] ", e);
			statusTransaccion = Constants.CADENA_FAILED;
			
			if (e instanceof WSException) {
				WSException x = (WSException) e;
				auditResponse.setIdTransaccion(idTransaccion);
				auditResponse.setCodigoRespuesta(x.getCode());
				auditResponse.setDescripcionRespuesta(x.getMessage());
				
			} else if(e instanceof DBException){
				DBException x = (DBException) e;
				auditResponse.setIdTransaccion(idTransaccion);
				auditResponse.setCodigoRespuesta(x.getCode());
				auditResponse.setDescripcionRespuesta(x.getMessage());
			} else{
				auditResponse.setIdTransaccion(idTransaccion);
				auditResponse.setCodigoRespuesta(properties.getCodigoRespuestaIDT5());
				auditResponse.setDescripcionRespuesta(properties.getMensajeRespuestaIDT5());
			}
			microservicePrepagoResponse.setAuditResponse(auditResponse);
			
			ObtenerDatosPlan obtenerDatosPlan = new ObtenerDatosPlan();
			ConsumosPrepago consumosPrepago = new ConsumosPrepago();
			
			ListaOtroPaquetesActivos objetoListaOtrosPaquetesActivos = new ListaOtroPaquetesActivos();
			List<OtroPaqueteActivo> listaOtroPaquetesActivos = new ArrayList<>();
			objetoListaOtrosPaquetesActivos.setOtroPaqueteActivo(listaOtroPaquetesActivos);
			
			ListaPaquetesActivos objetoListaPaquetesActivos = new ListaPaquetesActivos();
			List<PaqueteActivo> listaPaqueteActivo = new ArrayList<>();
			objetoListaPaquetesActivos.setPaqueteActivo(listaPaqueteActivo);
			
			ListaResumenPaquetesActivos objetoListaResumenPaquetesActivos = new ListaResumenPaquetesActivos();
			List<ResumenPaqueteActivo> listaResumenPaqueteActivo = new ArrayList<>();
			objetoListaResumenPaquetesActivos.setResumenPaqueteActivo(listaResumenPaqueteActivo);
			
			consumosPrepago.setListaOtroPaquetesActivos(objetoListaOtrosPaquetesActivos);
			consumosPrepago.setListaPaquetesActivos(objetoListaPaquetesActivos);
			consumosPrepago.setListaResumenPaquetesActivos(objetoListaResumenPaquetesActivos);
			
			microservicePrepagoResponse.setConsumosPrepago(consumosPrepago);
			microservicePrepagoResponse.setObtenerDatosPlan(obtenerDatosPlan);
			
		} finally {
			long tiempoTotal = System.currentTimeMillis() - tiempoInicio;
			logger.info("Datos del Body Response: "+Utilitarios.printPrettyJSONString(microservicePrepagoResponse));
			logger.info(trazabilidad + "Tiempo total de proceso(ms):{} ", tiempoTotal);
			audit.setStatus(statusTransaccion);
			audit.setTiempo(String.valueOf(tiempoTotal));
			logger.info("Datos de auditoria: "+Utilitarios.printPrettyJSONString(audit));
			logger.info(trazabilidad + "[FIN] - Call PrepagoController.consultarPrepago()");
		}
    	
    	return new ResponseEntity<>(microservicePrepagoResponse, status);
	}
}