package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class AuditStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msisdn;
	private String tiempo;
	private String tipo;
	private String status;
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "AuditStatus [msisdn=" + msisdn + ", tiempo=" + tiempo + ", tipo=" + tipo + ", status=" + status + "]";
	}
	
}
