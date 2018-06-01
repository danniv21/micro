package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class HeaderBeanResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HeaderResponse HeaderResponse;
	
	public HeaderResponse getHeaderResponse() {
		return HeaderResponse;
	}
	public void setHeaderResponse(HeaderResponse headerResponse) {
		HeaderResponse = headerResponse;
	}
	
	@Override
	public String toString() {
		return "HeaderBeanResponse [HeaderResponse=" + HeaderResponse + "]";
	}

}
