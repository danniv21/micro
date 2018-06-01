package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ConsumosPrepagoResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsumosPrepagoMessageResponse MessageResponse;
	
	public ConsumosPrepagoMessageResponse getMessageResponse() {
		return MessageResponse;
	}
	public void setMessageResponse(ConsumosPrepagoMessageResponse messageResponse) {
		MessageResponse = messageResponse;
	}
	
	@Override
	public String toString() {
		return "ConsumosPrepagoResponse [MessageResponse=" + MessageResponse + "]";
	}
	
}
