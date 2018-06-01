package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ConsultaPlanPrepagoMessageResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HeaderBeanResponse Header;
	private BodyResponseConsultaPlanPrepago Body;
	
	public HeaderBeanResponse getHeader() {
		return Header;
	}
	public void setHeader(HeaderBeanResponse header) {
		Header = header;
	}
	public BodyResponseConsultaPlanPrepago getBody() {
		return Body;
	}
	public void setBody(BodyResponseConsultaPlanPrepago body) {
		Body = body;
	}
	
	@Override
	public String toString() {
		return "ConsultaPlanPrepagoMessageResponse [Header=" + Header + ", Body=" + Body + "]";
	}

}
