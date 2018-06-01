package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class CompraPaquete implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean flag;
	private String mensaje;
	
	public CompraPaquete(){
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		return "CompraPaquete [flag=" + flag + ", mensaje=" + mensaje + "]";
	}

}
