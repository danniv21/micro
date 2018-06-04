package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class DetallePlanResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String subtype;
	private String rate;
	private String dataPackage;
	private String voicePackage;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDataPackage() {
		return dataPackage;
	}
	public void setDataPackage(String dataPackage) {
		this.dataPackage = dataPackage;
	}
	public String getVoicePackage() {
		return voicePackage;
	}
	public void setVoicePackage(String voicePackage) {
		this.voicePackage = voicePackage;
	}
	@Override
	public String toString() {
		return "DetallePlanResponse [id=" + id + ", subtype=" + subtype + ", rate=" + rate + ", dataPackage="
				+ dataPackage + ", voicePackage=" + voicePackage + "]";
	}

}
