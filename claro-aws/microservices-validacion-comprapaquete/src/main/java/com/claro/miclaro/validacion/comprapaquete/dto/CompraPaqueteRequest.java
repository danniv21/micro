package com.claro.miclaro.validacion.comprapaquete.dto;

import java.util.List;

public class CompraPaqueteRequest {
	private String tipoCliente;
	private List<ResumenBolsaActiva> resumenBolsaActiva;

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<ResumenBolsaActiva> getResumenBolsaActiva() {
		return resumenBolsaActiva;
	}

	public void setResumenBolsaActiva(List<ResumenBolsaActiva> resumenBolsaActiva) {
		this.resumenBolsaActiva = resumenBolsaActiva;
	}

	@Override
	public String toString() {
		return "CompraPaqueteRequestDTO [tipoCliente=" + tipoCliente + ", resumenBolsaActiva=" + resumenBolsaActiva
				+ "]";
	}

}
