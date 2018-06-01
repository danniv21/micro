package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class MicroservicePrepagoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String msisdn;
	
	public MicroservicePrepagoRequest(){
		super();
	}
	
	public MicroservicePrepagoRequest(MicroservicePrepagoRequest request){
		super();
		this.msisdn = request.getMsisdn() != null ? !request.getMsisdn().isEmpty() ? request.getMsisdn() : null : null;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	@Override
	public String toString() {
		return "MicroservicePrepagoRequest [msisdn=" + msisdn + "]";
	}

}
