package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;
import java.util.List;

public class ListaResumenPaquetesActivos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ResumenPaqueteActivo> resumenPaqueteActivo;

	public List<ResumenPaqueteActivo> getResumenPaqueteActivo() {
		return resumenPaqueteActivo;
	}

	public void setResumenPaqueteActivo(List<ResumenPaqueteActivo> resumenPaqueteActivo) {
		this.resumenPaqueteActivo = resumenPaqueteActivo;
	}

	@Override
	public String toString() {
		return "ListaResumenPaquetesActivos [resumenPaqueteActivo=" + resumenPaqueteActivo + "]";
	}
	
}
