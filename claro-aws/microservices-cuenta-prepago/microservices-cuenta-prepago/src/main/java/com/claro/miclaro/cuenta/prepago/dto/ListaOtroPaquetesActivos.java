package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;
import java.util.List;

public class ListaOtroPaquetesActivos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OtroPaqueteActivo> otroPaqueteActivo;
	
	public List<OtroPaqueteActivo> getOtroPaqueteActivo() {
		return otroPaqueteActivo;
	}
	public void setOtroPaqueteActivo(List<OtroPaqueteActivo> otroPaqueteActivo) {
		this.otroPaqueteActivo = otroPaqueteActivo;
	}
	
	@Override
	public String toString() {
		return "ListaOtroPaquetesActivos [otroPaqueteActivo=" + otroPaqueteActivo + "]";
	}

}
