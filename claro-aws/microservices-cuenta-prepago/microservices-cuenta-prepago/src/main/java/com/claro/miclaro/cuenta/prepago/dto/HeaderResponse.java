package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class HeaderResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String timestamp;
	private String varArg;
	private Status status;
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getVarArg() {
		return varArg;
	}
	public void setVarArg(String varArg) {
		this.varArg = varArg;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "HeaderResponse [timestamp=" + timestamp + ", varArg=" + varArg + ", status=" + status + "]";
	}
}
