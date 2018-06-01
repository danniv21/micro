package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class Status implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String code;
	private String message;
	private String msgid;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	
	@Override
	public String toString() {
		return "Status [type=" + type + ", code=" + code + ", message=" + message + ", msgid=" + msgid + "]";
	}

}
