package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ConsumosPrepagoMessageResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HeaderBeanResponse Header;
	private BodyResponseConsumosPrepago Body;
	
	public HeaderBeanResponse getHeader() {
		return Header;
	}
	public void setHeader(HeaderBeanResponse header) {
		Header = header;
	}
	public BodyResponseConsumosPrepago getBody() {
		return Body;
	}
	public void setBody(BodyResponseConsumosPrepago body) {
		Body = body;
	}
	
	@Override
	public String toString() {
		return "ConsumosPrepagoMessageResponse [Header=" + Header + ", Body=" + Body + "]";
	}
}
