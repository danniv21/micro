package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class PaqueteActivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private boolean flagIlimitado;
	private String saldo;
	private String servicio;
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
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public boolean isFlagIlimitado() {
		return flagIlimitado;
	}
	public void setFlagIlimitado(boolean flagIlimitado) {
		this.flagIlimitado = flagIlimitado;
	}
	@Override
	public String toString() {
		return "PaqueteActivo [descripcion=" + descripcion + ", flagIlimitado=" + flagIlimitado + ", saldo=" + saldo
				+ ", servicio=" + servicio + ", vigencia=" + vigencia + "]";
	}
	
}
