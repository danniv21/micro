package com.claro.miclaro.cuenta.prepago.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.claro.miclaro.cuenta.prepago.client.ConsumosPrepagoProxy;
import com.claro.miclaro.cuenta.prepago.client.DetailPlanProxy;
import com.claro.miclaro.cuenta.prepago.client.ObtenerDatosPlanPrepagoProxy;
import com.claro.miclaro.cuenta.prepago.client.ValidarCompraPaqueteProxy;
import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.AuditResponse;
import com.claro.miclaro.cuenta.prepago.dto.CompraPaqueteResponse;
import com.claro.miclaro.cuenta.prepago.dto.ConsultaPlanPrepagoResponse;
import com.claro.miclaro.cuenta.prepago.dto.ConsumosPrepago;
import com.claro.miclaro.cuenta.prepago.dto.ConsumosPrepagoResponse;
import com.claro.miclaro.cuenta.prepago.dto.DetallePlanResponse;
import com.claro.miclaro.cuenta.prepago.dto.ListaResumenPaquetesActivos;
import com.claro.miclaro.cuenta.prepago.dto.MicroservicePrepagoResponse;
import com.claro.miclaro.cuenta.prepago.dto.ObtenerDatosPlan;
import com.claro.miclaro.cuenta.prepago.dto.ResumenPaqueteActivo;
import com.claro.miclaro.cuenta.prepago.exception.WSException;
import com.claro.miclaro.cuenta.prepago.util.Constants;
import com.claro.miclaro.cuenta.prepago.util.Utilitarios;

@Service("PrepagoServiceImpl")
public class PrepagoServiceImpl implements PrepagoService{
	
	private static final Logger logger = LoggerFactory.getLogger(PrepagoServiceImpl.class);
	
	@Autowired
	private ObtenerDatosPlanPrepagoProxy obtenerDatosPlanProxy;
	
	@Autowired
	private ConsumosPrepagoProxy consumosPrepagoProxy;
	
	@Autowired
	private DetailPlanProxy detailPlanProxy;
	
	@Autowired
	private ValidarCompraPaqueteProxy validarCompraPaqueteProxy;
	
	@Override
	public MicroservicePrepagoResponse consultarPrepago(String idTransaccion, HttpHeaders httpHeaders, String number, ApplicationProperties properties) throws WSException, Exception{
		
		logger.info("Start PrepagoServiceImpl.consultarPrepago()");
		
		MicroservicePrepagoResponse response = new MicroservicePrepagoResponse();
		AuditResponse auditResponse = new AuditResponse();
		auditResponse.setServicio(Constants.CADENA_SERVICIO);
		auditResponse.setMetodo(Constants.CADENA_METODO);
		auditResponse.setMsisdn(number);
		ObtenerDatosPlan obtenerDatosPlan = new ObtenerDatosPlan();
		ConsumosPrepago consumosPrepago = new ConsumosPrepago();
		DetallePlanResponse detallePlanResponse = null;
		CompraPaqueteResponse compraPaqueteResponse = null;
		boolean flagCompraPaquete = false;
		boolean isListaVacia = false;
		
		logger.info("[INICIO]-Invocando al API REST ConsultaPlanPrepago");
		ConsultaPlanPrepagoResponse consultaPlanPrepagoResponse = obtenerDatosPlanProxy.obtenerdatosplan(number, properties, httpHeaders);
		logger.info("[FIN]-Invocando al API REST ConsultaPlanPrepago");
		
		String tipoPlan = consultaPlanPrepagoResponse.getMessageResponse().getBody().getResponseDataObtenerDatosPlan().getTipoPlan();
		
		if(tipoPlan != null && !tipoPlan.isEmpty()){
			boolean flagRecarga = false;
			obtenerDatosPlan.setTipoPlan(tipoPlan);
			obtenerDatosPlan.setNombrePlan(consultaPlanPrepagoResponse.getMessageResponse().getBody().getResponseDataObtenerDatosPlan().getNombrePlan());
			obtenerDatosPlan.setFechaVencimiento(consultaPlanPrepagoResponse.getMessageResponse().getBody().getResponseDataObtenerDatosPlan().getFechaVencimiento());
			obtenerDatosPlan.setSaldoPrepago(consultaPlanPrepagoResponse.getMessageResponse().getBody().getResponseDataObtenerDatosPlan().getSaldoPrepago());
			if(consultaPlanPrepagoResponse.getMessageResponse().getBody().getResponseDataObtenerDatosPlan().getFlagRecargar().equalsIgnoreCase(Constants.CADENA_TRUE)){
				flagRecarga = true;
			}
			obtenerDatosPlan.setFlagRecargar(flagRecarga);
			
			if(tipoPlan.toUpperCase().equals(properties.getDescripcionTipoPlanControl())){
				consumosPrepago = Utilitarios.setDatosVacios(consumosPrepago);
				auditResponse.setIdTransaccion(idTransaccion);
				auditResponse.setCodigoRespuesta(properties.getCodigoRespuestaIDF4());
				auditResponse.setDescripcionRespuesta(properties.getMensajeRespuestaIDF4());
				response.setAuditResponse(auditResponse);
				response.setObtenerDatosPlan(obtenerDatosPlan);
				response.setConsumosPrepago(consumosPrepago);
				
				return response;
			}
		} else {
			auditResponse.setIdTransaccion(idTransaccion);
			auditResponse.setCodigoRespuesta(properties.getCodigoRespuestaIDF3());
			auditResponse.setDescripcionRespuesta(properties.getMensajeRespuestaIDF3());
			response.setAuditResponse(auditResponse);
			
			logger.info("End PrepagoServiceImpl.consultarPrepago()");
			logger.info("Datos del Body Response: "+Utilitarios.printPrettyJSONString(response));
			return response;
		}
		
		response.setObtenerDatosPlan(obtenerDatosPlan);
		logger.info("[INICIO]-Invocando al Microservices Plan");
		detallePlanResponse = detailPlanProxy.obtenerDetallePlan(tipoPlan, properties);
		logger.info("[FIN]-Invocando al Microservices Plan");
		
		obtenerDatosPlan.setRate(detallePlanResponse.getRate());
		obtenerDatosPlan.setDataPackage(detallePlanResponse.getDataPackage());
		obtenerDatosPlan.setVoicePackage(detallePlanResponse.getVoicePackage());
		
		logger.info("[INICIO]-Invocando al API REST ConsumosPrepago");
		ConsumosPrepagoResponse consumosPrepagoResponse = consumosPrepagoProxy.consultaresumen(number, properties, httpHeaders);
		logger.info("[FIN]-Invocando al API REST ConsumosPrepago");
		
		if(consumosPrepagoResponse.getMessageResponse().getBody().getCodigoRespuesta().equals(Constants.CODIGO_DOS)){
			consumosPrepago = Utilitarios.setDatosVacios(consumosPrepago);
			
			ListaResumenPaquetesActivos listaResumen = new ListaResumenPaquetesActivos();
			List<ResumenPaqueteActivo> lista = new ArrayList<>();
			listaResumen.setResumenPaqueteActivo(lista);
			consumosPrepagoResponse.getMessageResponse().getBody().setListaResumenPaquetesActivos(listaResumen);
			isListaVacia = true;
		}
		
		logger.info("[INICIO]-Invocando al Microservices ValidacionCompraPaquete");
		try {
			compraPaqueteResponse = validarCompraPaqueteProxy.validarCompraPaquete(consumosPrepagoResponse.getMessageResponse().getBody().getListaResumenPaquetesActivos().getResumenPaqueteActivo(), properties, httpHeaders);
			flagCompraPaquete = true;
		} catch (Exception e) {
			logger.error("ERROR: [Exception] - [" + e.getMessage() + "] ", e);
		}
		logger.info("[FIN]-Invocando al Microservices ValidacionCompraPaquete");
		
		
		if(flagCompraPaquete){
			consumosPrepagoResponse.getMessageResponse().getBody().getListaResumenPaquetesActivos().setResumenPaqueteActivo(compraPaqueteResponse.getResumenBolsaActiva());
			consumosPrepago.setListaResumenPaquetesActivos(consumosPrepagoResponse.getMessageResponse().getBody().getListaResumenPaquetesActivos());
		}else{
			if(!isListaVacia){
				consumosPrepago.setListaResumenPaquetesActivos(consumosPrepagoResponse.getMessageResponse().getBody().getListaResumenPaquetesActivos());
			}
		}
		
		if(!isListaVacia){
			consumosPrepago.setListaOtroPaquetesActivos(consumosPrepagoResponse.getMessageResponse().getBody().getListaOtroPaquetesActivos());
			consumosPrepago.setListaPaquetesActivos(consumosPrepagoResponse.getMessageResponse().getBody().getListaPaquetesActivos());
			consumosPrepago.setFechaActualizacion(consumosPrepagoResponse.getMessageResponse().getBody().getFechaActualizacion());
		}
		
		auditResponse.setIdTransaccion(idTransaccion);
		auditResponse.setCodigoRespuesta(properties.getCodigoRespuestaIDF0());
		auditResponse.setDescripcionRespuesta(properties.getMensajeRespuestaIDF0());
		
		response.setAuditResponse(auditResponse);
		response.setConsumosPrepago(consumosPrepago);
		
		logger.info("End PrepagoServiceImpl.consultarPrepago()");
		
		return response;
	}
}
