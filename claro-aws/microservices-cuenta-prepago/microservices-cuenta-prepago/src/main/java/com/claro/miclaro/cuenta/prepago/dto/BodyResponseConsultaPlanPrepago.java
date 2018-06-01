package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class BodyResponseConsultaPlanPrepago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResponseStatus responseStatus;
	private ResponseDataObtenerDatosPlan responseDataObtenerDatosPlan;
	
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	public ResponseDataObtenerDatosPlan getResponseDataObtenerDatosPlan() {
		return responseDataObtenerDatosPlan;
	}
	public void setResponseDataObtenerDatosPlan(ResponseDataObtenerDatosPlan responseDataObtenerDatosPlan) {
		this.responseDataObtenerDatosPlan = responseDataObtenerDatosPlan;
	}
	
	@Override
	public String toString() {
		return "BodyResponseConsultaPlanPrepago [responseStatus=" + responseStatus + ", responseDataObtenerDatosPlan="
				+ responseDataObtenerDatosPlan + "]";
	}
	
}
