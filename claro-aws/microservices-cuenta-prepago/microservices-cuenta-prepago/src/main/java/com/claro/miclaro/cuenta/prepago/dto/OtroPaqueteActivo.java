package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class OtroPaqueteActivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private String saldo;
	private String vigencia;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	
	@Override
	public String toString() {
		return "OtroPaqueteActivo [descripcion=" + descripcion + ", saldo=" + saldo + ", vigencia=" + vigencia + "]";
	}

}
