package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;
import java.util.List;

public class ListaPaquetesActivos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PaqueteActivo> paqueteActivo;
	
	public List<PaqueteActivo> getPaqueteActivo() {
		return paqueteActivo;
	}
	public void setPaqueteActivo(List<PaqueteActivo> paqueteActivo) {
		this.paqueteActivo = paqueteActivo;
	}
	
	@Override
	public String toString() {
		return "ListaPaquetesActivos [paqueteActivo=" + paqueteActivo + "]";
	}

}
