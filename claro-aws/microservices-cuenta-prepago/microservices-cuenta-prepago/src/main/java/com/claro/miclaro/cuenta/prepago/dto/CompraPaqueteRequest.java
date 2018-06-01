package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;
import java.util.List;

public class CompraPaqueteRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoCliente;
	private List<ResumenPaqueteActivo> resumenBolsaActiva;
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public List<ResumenPaqueteActivo> getResumenBolsaActiva() {
		return resumenBolsaActiva;
	}
	public void setResumenBolsaActiva(List<ResumenPaqueteActivo> resumenBolsaActiva) {
		this.resumenBolsaActiva = resumenBolsaActiva;
	}
	@Override
	public String toString() {
		return "ValidacionCompraPaquete [tipoCliente=" + tipoCliente + ", resumenBolsaActiva=" + resumenBolsaActiva
				+ "]";
	}
}
