package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class MicroservicePrepagoResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuditResponse auditResponse;
	private ObtenerDatosPlan obtenerDatosPlan;
	private ConsumosPrepago consumosPrepago;
	
	public AuditResponse getAuditResponse() {
		return auditResponse;
	}
	public void setAuditResponse(AuditResponse auditResponse) {
		this.auditResponse = auditResponse;
	}
	public ObtenerDatosPlan getObtenerDatosPlan() {
		return obtenerDatosPlan;
	}
	public void setObtenerDatosPlan(ObtenerDatosPlan obtenerDatosPlan) {
		this.obtenerDatosPlan = obtenerDatosPlan;
	}
	public ConsumosPrepago getConsumosPrepago() {
		return consumosPrepago;
	}
	public void setConsumosPrepago(ConsumosPrepago consumosPrepago) {
		this.consumosPrepago = consumosPrepago;
	}
	
	@Override
	public String toString() {
		return "MicroservicePrepagoResponse [auditResponse=" + auditResponse + ", obtenerDatosPlan=" + obtenerDatosPlan
				+ ", consumosPrepago=" + consumosPrepago + "]";
	}

}
