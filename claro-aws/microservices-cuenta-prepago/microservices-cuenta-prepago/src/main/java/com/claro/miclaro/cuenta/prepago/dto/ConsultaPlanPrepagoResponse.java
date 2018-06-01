package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ConsultaPlanPrepagoResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsultaPlanPrepagoMessageResponse MessageResponse;
	
	
	public ConsultaPlanPrepagoMessageResponse getMessageResponse() {
		return MessageResponse;
	}
	public void setMessageResponse(ConsultaPlanPrepagoMessageResponse messageResponse) {
		MessageResponse = messageResponse;
	}
	
	@Override
	public String toString() {
		return "ConsultaPlanPrepagoResponse [MessageResponse=" + MessageResponse + "]";
	}

}
