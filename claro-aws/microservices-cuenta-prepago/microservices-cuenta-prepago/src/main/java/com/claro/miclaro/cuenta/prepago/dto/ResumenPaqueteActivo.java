package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ResumenPaqueteActivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean flagIlimitado;
	private int saldoConsumido;
	private int saldoDisponible;
	private int saldoTotal;
	private String servicio;
	private CompraPaquete compraPaquete;
	
	public ResumenPaqueteActivo(){
		this.compraPaquete = new CompraPaquete();
	}
	
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public boolean isFlagIlimitado() {
		return flagIlimitado;
	}
	public void setFlagIlimitado(boolean flagIlimitado) {
		this.flagIlimitado = flagIlimitado;
	}
	public int getSaldoConsumido() {
		return saldoConsumido;
	}
	public void setSaldoConsumido(int saldoConsumido) {
		this.saldoConsumido = saldoConsumido;
	}
	public int getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(int saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	public int getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal(int saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	public CompraPaquete getCompraPaquete() {
		return compraPaquete;
	}
	public void setCompraPaquete(CompraPaquete compraPaquete) {
		this.compraPaquete = compraPaquete;
	}
	@Override
	public String toString() {
		return "ResumenPaqueteActivo [flagIlimitado=" + flagIlimitado + ", saldoConsumido=" + saldoConsumido
				+ ", saldoDisponible=" + saldoDisponible + ", saldoTotal=" + saldoTotal + ", servicio=" + servicio
				+ ", compraPaquete=" + compraPaquete + "]";
	}

}
