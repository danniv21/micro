package com.claro.miclaro.cuenta.prepago.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {

    @Value("${header.consumer}")
    private String headerConsumer;
    
    @Value("${header.country}")
    private String headerCountry;
    
    @Value("${header.dispositivo}")
    private String headerDispositivo;
    
    @Value("${header.language}")
    private String headerLanguage;
    
    @Value("${header.authorization}")
    private String headerAuthorization;
    
    @Value("${header.modulo.ws.consulta.plan.prepago}")
    private String headerModuloConsultaPlanPrepago;
    
    @Value("${header.operation.obtener.datos.plan}")
    private String headerOperationObtenerDatosPlan;
    
    @Value("${header.modulo.ws.consumos.prepago}")
    private String headerModuloConsumosPrepago;
    
    @Value("${header.operation.consulta.resumen}")
    private String headerOperationConsultaResumen;
    
    @Value("${header.msgType}")
    private String headerMsgType;
    
    @Value("${header.system}")
    private String headerSystem;
    
    @Value("${header.userId}")
    private String headerUserId;
    
    @Value("${header.wsIp}")
    private String headerWsIp;
    
    @Value("${header.canal}")
    private String headerCanal;
    
    @Value("${time.out.connection.consulta.plan.prepago}")
    private String timeOutConnectionConsultaPlanPrepago;
    
    @Value("${time.out.request.consulta.plan.prepago}")
    private String timeOutRequestConsultaPlanPrepago;
    
    @Value("${time.out.connection.consumos.prepago}")
    private String timeOutConnectionConsumosPrepago;
    
    @Value("${time.out.request.consumos.prepago}")
    private String timeOutRequestConsumosPrepago;
    
    @Value("${time.out.connection.detail.plan}")
    private String timeOutConnectionDetailPlan;
    
    @Value("${time.out.request.detail.plan}")
    private String timeOutRequestDetailPlan;
    
    @Value("${time.out.connection.compra.paquete}")
    private String timeOutConnectionCompraPaquete;
    
    @Value("${time.out.request.compra.paquete}")
    private String timeOutRequestCompraPaquete;
    
	@Value("${codigo.respuesta.idf.cero}")
    private String codigoRespuestaIDF0;
    
    @Value("${codigo.respuesta.idf.uno}")
    private String codigoRespuestaIDF1;
    
    @Value("${codigo.respuesta.idf.dos}")
    private String codigoRespuestaIDF2;
    
    @Value("${codigo.respuesta.idf.tres}")
    private String codigoRespuestaIDF3;
    
    @Value("${codigo.respuesta.idf.cuatro}")
    private String codigoRespuestaIDF4;
    
    @Value("${mensaje.respuesta.idf.cero}")
    private String mensajeRespuestaIDF0;
    
    @Value("${mensaje.respuesta.idf.uno}")
    private String mensajeRespuestaIDF1;
    
    @Value("${mensaje.respuesta.idf.dos}")
    private String mensajeRespuestaIDF2;
    
    @Value("${mensaje.respuesta.idf.tres}")
    private String mensajeRespuestaIDF3;
    
    @Value("${mensaje.respuesta.idf.cuatro}")
    private String mensajeRespuestaIDF4;
    
    @Value("${codigo.respuesta.idt.uno}")
    private String codigoRespuestaIDT1;
    
    @Value("${codigo.respuesta.idt.dos}")
    private String codigoRespuestaIDT2;
    
    @Value("${codigo.respuesta.idt.tres}")
    private String codigoRespuestaIDT3;
    
    @Value("${codigo.respuesta.idt.cuatro}")
    private String codigoRespuestaIDT4;
  
    @Value("${codigo.respuesta.idt.cinco}")
    private String codigoRespuestaIDT5;
    
    @Value("${mensaje.respuesta.idt.uno}")
    private String mensajeRespuestaIDT1;
    
    @Value("${mensaje.respuesta.idt.dos}")
    private String mensajeRespuestaIDT2;
    
    @Value("${mensaje.respuesta.idt.tres}")
    private String mensajeRespuestaIDT3;
    
    @Value("${mensaje.respuesta.idt.cuatro}")
    private String mensajeRespuestaIDT4;
    
    @Value("${mensaje.respuesta.idt.cinco}")
    private String mensajeRespuestaIDT5;
    
    @Value("${uri.rest.consulta.plan.prepago}")
    private String uriConsultaPlanPrepago;
    
    @Value("${uri.rest.consumos.prepago}")
    private String uriConsumosPrepago;
    
    @Value("${uri.rest.detail.plan}")
    private String uriDetailPlan;
    
    @Value("${uri.rest.validacion.compra.paquete}")
    private String uriValidacionCompraPaquete;
    
    @Value("${descripcion.tipo.plan.control}")
    private String descripcionTipoPlanControl;
    
	public String getUriConsultaPlanPrepago() {
		return uriConsultaPlanPrepago;
	}

	public void setUriConsultaPlanPrepago(String uriConsultaPlanPrepago) {
		this.uriConsultaPlanPrepago = uriConsultaPlanPrepago;
	}

	public String getCodigoRespuestaIDF0() {
		return codigoRespuestaIDF0;
	}

	public void setCodigoRespuestaIDF0(String codigoRespuestaIDF0) {
		this.codigoRespuestaIDF0 = codigoRespuestaIDF0;
	}

	public String getCodigoRespuestaIDF1() {
		return codigoRespuestaIDF1;
	}

	public void setCodigoRespuestaIDF1(String codigoRespuestaIDF1) {
		this.codigoRespuestaIDF1 = codigoRespuestaIDF1;
	}

	public String getCodigoRespuestaIDF2() {
		return codigoRespuestaIDF2;
	}

	public void setCodigoRespuestaIDF2(String codigoRespuestaIDF2) {
		this.codigoRespuestaIDF2 = codigoRespuestaIDF2;
	}

	public String getCodigoRespuestaIDF3() {
		return codigoRespuestaIDF3;
	}

	public void setCodigoRespuestaIDF3(String codigoRespuestaIDF3) {
		this.codigoRespuestaIDF3 = codigoRespuestaIDF3;
	}

	public String getMensajeRespuestaIDF0() {
		return mensajeRespuestaIDF0;
	}

	public void setMensajeRespuestaIDF0(String mensajeRespuestaIDF0) {
		this.mensajeRespuestaIDF0 = mensajeRespuestaIDF0;
	}

	public String getMensajeRespuestaIDF1() {
		return mensajeRespuestaIDF1;
	}

	public void setMensajeRespuestaIDF1(String mensajeRespuestaIDF1) {
		this.mensajeRespuestaIDF1 = mensajeRespuestaIDF1;
	}

	public String getMensajeRespuestaIDF2() {
		return mensajeRespuestaIDF2;
	}

	public void setMensajeRespuestaIDF2(String mensajeRespuestaIDF2) {
		this.mensajeRespuestaIDF2 = mensajeRespuestaIDF2;
	}

	public String getMensajeRespuestaIDF3() {
		return mensajeRespuestaIDF3;
	}

	public void setMensajeRespuestaIDF3(String mensajeRespuestaIDF3) {
		this.mensajeRespuestaIDF3 = mensajeRespuestaIDF3;
	}

	public String getCodigoRespuestaIDF4() {
		return codigoRespuestaIDF4;
	}

	public void setCodigoRespuestaIDF4(String codigoRespuestaIDF4) {
		this.codigoRespuestaIDF4 = codigoRespuestaIDF4;
	}

	public String getMensajeRespuestaIDF4() {
		return mensajeRespuestaIDF4;
	}

	public void setMensajeRespuestaIDF4(String mensajeRespuestaIDF4) {
		this.mensajeRespuestaIDF4 = mensajeRespuestaIDF4;
	}

	public String getCodigoRespuestaIDT1() {
		return codigoRespuestaIDT1;
	}

	public void setCodigoRespuestaIDT1(String codigoRespuestaIDT1) {
		this.codigoRespuestaIDT1 = codigoRespuestaIDT1;
	}

	public String getCodigoRespuestaIDT2() {
		return codigoRespuestaIDT2;
	}

	public void setCodigoRespuestaIDT2(String codigoRespuestaIDT2) {
		this.codigoRespuestaIDT2 = codigoRespuestaIDT2;
	}

	public String getCodigoRespuestaIDT3() {
		return codigoRespuestaIDT3;
	}

	public void setCodigoRespuestaIDT3(String codigoRespuestaIDT3) {
		this.codigoRespuestaIDT3 = codigoRespuestaIDT3;
	}

	public String getCodigoRespuestaIDT4() {
		return codigoRespuestaIDT4;
	}

	public void setCodigoRespuestaIDT4(String codigoRespuestaIDT4) {
		this.codigoRespuestaIDT4 = codigoRespuestaIDT4;
	}

	public String getCodigoRespuestaIDT5() {
		return codigoRespuestaIDT5;
	}

	public void setCodigoRespuestaIDT5(String codigoRespuestaIDT5) {
		this.codigoRespuestaIDT5 = codigoRespuestaIDT5;
	}

	public String getMensajeRespuestaIDT1() {
		return mensajeRespuestaIDT1;
	}

	public void setMensajeRespuestaIDT1(String mensajeRespuestaIDT1) {
		this.mensajeRespuestaIDT1 = mensajeRespuestaIDT1;
	}

	public String getMensajeRespuestaIDT2() {
		return mensajeRespuestaIDT2;
	}

	public void setMensajeRespuestaIDT2(String mensajeRespuestaIDT2) {
		this.mensajeRespuestaIDT2 = mensajeRespuestaIDT2;
	}

	public String getMensajeRespuestaIDT3() {
		return mensajeRespuestaIDT3;
	}

	public void setMensajeRespuestaIDT3(String mensajeRespuestaIDT3) {
		this.mensajeRespuestaIDT3 = mensajeRespuestaIDT3;
	}

	public String getMensajeRespuestaIDT4() {
		return mensajeRespuestaIDT4;
	}

	public void setMensajeRespuestaIDT4(String mensajeRespuestaIDT4) {
		this.mensajeRespuestaIDT4 = mensajeRespuestaIDT4;
	}

	public String getMensajeRespuestaIDT5() {
		return mensajeRespuestaIDT5;
	}

	public void setMensajeRespuestaIDT5(String mensajeRespuestaIDT5) {
		this.mensajeRespuestaIDT5 = mensajeRespuestaIDT5;
	}

	public String getHeaderCanal() {
		return headerCanal;
	}

	public void setHeaderCanal(String headerCanal) {
		this.headerCanal = headerCanal;
	}

	public String getTimeOutConnectionConsultaPlanPrepago() {
		return timeOutConnectionConsultaPlanPrepago;
	}

	public void setTimeOutConnectionConsultaPlanPrepago(String timeOutConnectionConsultaPlanPrepago) {
		this.timeOutConnectionConsultaPlanPrepago = timeOutConnectionConsultaPlanPrepago;
	}

	public String getTimeOutRequestConsultaPlanPrepago() {
		return timeOutRequestConsultaPlanPrepago;
	}

	public void setTimeOutRequestConsultaPlanPrepago(String timeOutRequestConsultaPlanPrepago) {
		this.timeOutRequestConsultaPlanPrepago = timeOutRequestConsultaPlanPrepago;
	}
	
	public String getTimeOutConnectionConsumosPrepago() {
		return timeOutConnectionConsumosPrepago;
	}

	public void setTimeOutConnectionConsumosPrepago(String timeOutConnectionConsumosPrepago) {
		this.timeOutConnectionConsumosPrepago = timeOutConnectionConsumosPrepago;
	}

	public String getTimeOutRequestConsumosPrepago() {
		return timeOutRequestConsumosPrepago;
	}

	public void setTimeOutRequestConsumosPrepago(String timeOutRequestConsumosPrepago) {
		this.timeOutRequestConsumosPrepago = timeOutRequestConsumosPrepago;
	}

	public String getUriConsumosPrepago() {
		return uriConsumosPrepago;
	}

	public void setUriConsumosPrepago(String uriConsumosPrepago) {
		this.uriConsumosPrepago = uriConsumosPrepago;
	}

	public String getHeaderConsumer() {
		return headerConsumer;
	}

	public void setHeaderConsumer(String headerConsumer) {
		this.headerConsumer = headerConsumer;
	}

	public String getHeaderCountry() {
		return headerCountry;
	}

	public void setHeaderCountry(String headerCountry) {
		this.headerCountry = headerCountry;
	}

	public String getHeaderDispositivo() {
		return headerDispositivo;
	}

	public void setHeaderDispositivo(String headerDispositivo) {
		this.headerDispositivo = headerDispositivo;
	}

	public String getHeaderLanguage() {
		return headerLanguage;
	}

	public void setHeaderLanguage(String headerLanguage) {
		this.headerLanguage = headerLanguage;
	}

	public String getHeaderMsgType() {
		return headerMsgType;
	}

	public void setHeaderMsgType(String headerMsgType) {
		this.headerMsgType = headerMsgType;
	}

	public String getHeaderSystem() {
		return headerSystem;
	}

	public void setHeaderSystem(String headerSystem) {
		this.headerSystem = headerSystem;
	}

	public String getHeaderUserId() {
		return headerUserId;
	}

	public void setHeaderUserId(String headerUserId) {
		this.headerUserId = headerUserId;
	}

	public String getHeaderWsIp() {
		return headerWsIp;
	}

	public void setHeaderWsIp(String headerWsIp) {
		this.headerWsIp = headerWsIp;
	}

	public String getHeaderModuloConsultaPlanPrepago() {
		return headerModuloConsultaPlanPrepago;
	}

	public void setHeaderModuloConsultaPlanPrepago(String headerModuloConsultaPlanPrepago) {
		this.headerModuloConsultaPlanPrepago = headerModuloConsultaPlanPrepago;
	}

	public String getHeaderOperationObtenerDatosPlan() {
		return headerOperationObtenerDatosPlan;
	}

	public void setHeaderOperationObtenerDatosPlan(String headerOperationObtenerDatosPlan) {
		this.headerOperationObtenerDatosPlan = headerOperationObtenerDatosPlan;
	}

	public String getHeaderModuloConsumosPrepago() {
		return headerModuloConsumosPrepago;
	}

	public void setHeaderModuloConsumosPrepago(String headerModuloConsumosPrepago) {
		this.headerModuloConsumosPrepago = headerModuloConsumosPrepago;
	}

	public String getHeaderOperationConsultaResumen() {
		return headerOperationConsultaResumen;
	}

	public void setHeaderOperationConsultaResumen(String headerOperationConsultaResumen) {
		this.headerOperationConsultaResumen = headerOperationConsultaResumen;
	}

	public String getHeaderAuthorization() {
		return headerAuthorization;
	}

	public void setHeaderAuthorization(String headerAuthorization) {
		this.headerAuthorization = headerAuthorization;
	}

	public String getDescripcionTipoPlanControl() {
		return descripcionTipoPlanControl;
	}

	public void setDescripcionTipoPlanControl(String descripcionTipoPlanControl) {
		this.descripcionTipoPlanControl = descripcionTipoPlanControl;
	}

	public String getUriDetailPlan() {
		return uriDetailPlan;
	}

	public void setUriDetailPlan(String uriDetailPlan) {
		this.uriDetailPlan = uriDetailPlan;
	}

	public String getTimeOutConnectionDetailPlan() {
		return timeOutConnectionDetailPlan;
	}

	public void setTimeOutConnectionDetailPlan(String timeOutConnectionDetailPlan) {
		this.timeOutConnectionDetailPlan = timeOutConnectionDetailPlan;
	}

	public String getTimeOutRequestDetailPlan() {
		return timeOutRequestDetailPlan;
	}

	public void setTimeOutRequestDetailPlan(String timeOutRequestDetailPlan) {
		this.timeOutRequestDetailPlan = timeOutRequestDetailPlan;
	}

	public String getUriValidacionCompraPaquete() {
		return uriValidacionCompraPaquete;
	}

	public void setUriValidacionCompraPaquete(String uriValidacionCompraPaquete) {
		this.uriValidacionCompraPaquete = uriValidacionCompraPaquete;
	}

	public String getTimeOutConnectionCompraPaquete() {
		return timeOutConnectionCompraPaquete;
	}

	public void setTimeOutConnectionCompraPaquete(String timeOutConnectionCompraPaquete) {
		this.timeOutConnectionCompraPaquete = timeOutConnectionCompraPaquete;
	}

	public String getTimeOutRequestCompraPaquete() {
		return timeOutRequestCompraPaquete;
	}

	public void setTimeOutRequestCompraPaquete(String timeOutRequestCompraPaquete) {
		this.timeOutRequestCompraPaquete = timeOutRequestCompraPaquete;
	}
	
}