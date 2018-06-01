package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ConsultaPlanPrepagoRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageRequest MessageRequest;
	
	public MessageRequest getMessageRequest() {
		return MessageRequest;
	}
	public void setMessageRequest(MessageRequest messageRequest) {
		MessageRequest = messageRequest;
	}
	
	@Override
	public String toString() {
		return "ConsultaPlanPrepagoRequest [MessageRequest=" + MessageRequest + "]";
	}
	
}
