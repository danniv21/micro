package com.claro.miclaro.validacion.comprapaquete.dto;

import java.util.List;

public class CompraPaqueteResponse {
	private AuditResponse auditResponse;
	private List<ResumenBolsaActiva> resumenBolsaActiva;

	public AuditResponse getAuditResponse() {
		return auditResponse;
	}

	public void setAuditResponse(AuditResponse auditResponse) {
		this.auditResponse = auditResponse;
	}

	public List<ResumenBolsaActiva> getResumenBolsaActiva() {
		return resumenBolsaActiva;
	}

	public void setResumenBolsaActiva(List<ResumenBolsaActiva> resumenBolsaActiva) {
		this.resumenBolsaActiva = resumenBolsaActiva;
	}

	@Override
	public String toString() {
		return "CompraPaqueteResponse [auditResponse=" + auditResponse + ", resumenBolsaActiva=" + resumenBolsaActiva
				+ "]";
	}

}
