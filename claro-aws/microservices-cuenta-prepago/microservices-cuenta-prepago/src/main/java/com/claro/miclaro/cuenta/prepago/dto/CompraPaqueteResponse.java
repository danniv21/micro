package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;
import java.util.List;

public class CompraPaqueteResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuditResponse auditResponse;
	private List<ResumenPaqueteActivo> resumenBolsaActiva;
	
	public AuditResponse getAuditResponse() {
		return auditResponse;
	}
	public void setAuditResponse(AuditResponse auditResponse) {
		this.auditResponse = auditResponse;
	}
	public List<ResumenPaqueteActivo> getResumenBolsaActiva() {
		return resumenBolsaActiva;
	}
	public void setResumenBolsaActiva(List<ResumenPaqueteActivo> resumenBolsaActiva) {
		this.resumenBolsaActiva = resumenBolsaActiva;
	}
	@Override
	public String toString() {
		return "ValidacionCompraPaqueteResponse [auditResponse=" + auditResponse + ", resumenBolsaActiva="
				+ resumenBolsaActiva + "]";
	}
	
}
