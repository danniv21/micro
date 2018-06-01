package com.claro.miclaro.validacion.comprapaquete.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.claro.miclaro.validacion.comprapaquete.config.ApplicationProperties;
import com.claro.miclaro.validacion.comprapaquete.dto.AuditResponse;
import com.claro.miclaro.validacion.comprapaquete.dto.CompraPaqueteRequest;
import com.claro.miclaro.validacion.comprapaquete.dto.CompraPaqueteResponse;
import com.claro.miclaro.validacion.comprapaquete.dto.ResumenBolsaActiva;
import com.claro.miclaro.validacion.comprapaquete.entity.PaqueteCompras;
import com.claro.miclaro.validacion.comprapaquete.exception.DBException;
import com.claro.miclaro.validacion.comprapaquete.exception.ServiceException;
import com.claro.miclaro.validacion.comprapaquete.repository.PaqueteComprasRepositorio;
import com.claro.miclaro.validacion.comprapaquete.util.Constants;
import com.claro.miclaro.validacion.comprapaquete.util.Utilitario;

@Service("compraPaqueteService")
public class CompraPaqueteService implements ICompraPaqueteService {

	private static final Logger logger = LoggerFactory.getLogger(CompraPaqueteService.class);
	
	@Autowired
	private ApplicationProperties properties;

	@Autowired
	private PaqueteComprasRepositorio paqueteComprasRepositorio;

	public CompraPaqueteResponse validarCompraPaquete(HttpHeaders httpHeaders,
			CompraPaqueteRequest compraPaqueteRequest) throws ServiceException, DBException{
		
		boolean isSMS = false;
		boolean isVOZ = false;
		boolean isDATOS = false;
		logger.info("Start CompraPaqueteService.validarCompraPaquete()");

		logger.info("[INICIO]- Validando parametros obligatorios");
		Utilitario.validarParametrosObligatorios(httpHeaders, compraPaqueteRequest, properties);
		logger.info("[FIN]- Validando parametros obligatorios");
		
		String idTransaccion = httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0);
		
		org.apache.log4j.MDC.put("idtransaccion", idTransaccion);
		
		if (compraPaqueteRequest.getResumenBolsaActiva() == null
				|| compraPaqueteRequest.getResumenBolsaActiva().isEmpty()) {
			
			List<ResumenBolsaActiva> listaResumen = new ArrayList<>();
			listaResumen.add(new ResumenBolsaActiva(Constants.CADENA_VOZ));
			listaResumen.add(new ResumenBolsaActiva(Constants.CADENA_SMS));
			listaResumen.add(new ResumenBolsaActiva(Constants.CADENA_DATOS));
			
			compraPaqueteRequest.setResumenBolsaActiva(listaResumen);
		}

		CompraPaqueteResponse compraPaqueteResponse = new CompraPaqueteResponse();
		AuditResponse auditResponse = new AuditResponse();
		
		logger.info("[INICIO]-Invocando a la tabla buypackage de la BD DBSMSCLARO");
		List<PaqueteCompras> listaPaquetesCompras;
		try {
			listaPaquetesCompras = paqueteComprasRepositorio.findByTipoCliente(compraPaqueteRequest.getTipoCliente());
		} catch (Exception e) {
			logger.error("ERROR: [Exception] - [" + e.getMessage() + "] ", e);
			if (e.getMessage().toUpperCase().contains(Constants.RESPONSE_EXCEPTION_TIMEOUT)
					|| e.getMessage().toUpperCase().contains(Constants.RESPONSE_EXCEPTION_TIMEOUT2)) {
				logger.info("End CompraPaqueteService.validarCompraPaquete()");
				throw new DBException(properties.getValidacioncomprapaqueteCodigoIdt1(),
						properties.getValidacioncomprapaqueteMensajeIdt1().replace("$bd", "DBCLARODESARROLLO"),
						HttpStatus.GATEWAY_TIMEOUT);
			} else {
				logger.info("End CompraPaqueteService.validarCompraPaquete()");
				throw new DBException(properties.getValidacioncomprapaqueteCodigoIdt2(),
						properties.getValidacioncomprapaqueteMensajeIdt2().replace("$bd", "DBCLARODESARROLLO"),
						HttpStatus.GATEWAY_TIMEOUT);
			}
		}
		logger.info("[FIN]-Invocando a la tabla buypackage de la BD DBSMSCLARO");

		if (CollectionUtils.isEmpty(listaPaquetesCompras)) {
			logger.info("[EXCEPCION-FUNCIONAL] - No se obtuvo resultados al consultar la tabla buypackage");
			auditResponse.setIdTransaccion(idTransaccion);
			auditResponse.setCodigoRespuesta(properties.getValidacioncomprapaqueteCodigoIdf2());
			auditResponse.setDescripcionRespuesta(properties.getValidacioncomprapaqueteMensajeIdf2());
			auditResponse.setMetodo(properties.getMicroservicioName());
			auditResponse.setFecha(Utilitario.parseDateFormat(Constants.FORMAT_DATE_TIME_ZONE));
			compraPaqueteResponse.setAuditResponse(auditResponse);
		} else {
			for (ResumenBolsaActiva bolsaActiva : compraPaqueteRequest.getResumenBolsaActiva()) {
				if (bolsaActiva.getServicio()
						.equalsIgnoreCase(Constants.CADENA_VOZ)) {
					isVOZ = true;
				}
				if (bolsaActiva.getServicio()
						.equalsIgnoreCase(Constants.CADENA_SMS)) {
					isSMS = true;
				}
				if (bolsaActiva.getServicio()
						.equalsIgnoreCase(Constants.CADENA_DATOS)) {
					isDATOS = true;
				}
			}
			
			ResumenBolsaActiva resumen;
			if(!isVOZ) {
				resumen = new ResumenBolsaActiva(Constants.CADENA_VOZ);
				compraPaqueteRequest.getResumenBolsaActiva().add(resumen);
			}
			if(!isSMS) {
				resumen = new ResumenBolsaActiva(Constants.CADENA_SMS);
				compraPaqueteRequest.getResumenBolsaActiva().add(resumen);
			}
			if(!isDATOS) {
				resumen = new ResumenBolsaActiva(Constants.CADENA_DATOS);
				compraPaqueteRequest.getResumenBolsaActiva().add(resumen);
			}
			
			for (ResumenBolsaActiva bolsaActiva : compraPaqueteRequest.getResumenBolsaActiva()) {
				
				bolsaActiva.getCompraPaquete().setFlag(false);
				bolsaActiva.getCompraPaquete().setMensaje(Constants.STRING_EMPTY);

				if (!bolsaActiva.isFlagIlimitado()) {

					for (PaqueteCompras compras : listaPaquetesCompras) {

						if (bolsaActiva.getSaldoDisponible() <= compras
								.getValorMinimo()
								& bolsaActiva.getServicio()
										.equalsIgnoreCase(compras.getTipoPaquete())) {
							bolsaActiva.getCompraPaquete().setFlag(true);
							bolsaActiva.getCompraPaquete()
									.setMensaje(compras.getMensaje());
						}
					}
				}
			}
			auditResponse.setIdTransaccion(httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0));
			auditResponse.setCodigoRespuesta(properties.getValidacioncomprapaqueteCodigoIdf0());
			auditResponse.setFecha(Utilitario.parseDateFormat(Constants.FORMAT_DATE_TIME_ZONE));
			auditResponse.setDescripcionRespuesta(properties.getValidacioncomprapaqueteMensajeIdf0());
			auditResponse.setMetodo(properties.getMicroservicioName());

			compraPaqueteResponse.setAuditResponse(auditResponse);
			compraPaqueteResponse.setResumenBolsaActiva(compraPaqueteRequest.getResumenBolsaActiva());
		}

		return compraPaqueteResponse;
	}
}
