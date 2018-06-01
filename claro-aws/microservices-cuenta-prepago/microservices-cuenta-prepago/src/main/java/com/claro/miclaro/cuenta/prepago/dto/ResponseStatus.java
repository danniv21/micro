package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ResponseStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estado;
	private String codigoRespuesta;
	private String descripcionRespuesta;
	private String ubicacionError;
	private String fecha;
	private String origen;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}
	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
	public String getUbicacionError() {
		return ubicacionError;
	}
	public void setUbicacionError(String ubicacionError) {
		this.ubicacionError = ubicacionError;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	@Override
	public String toString() {
		return "ResponseStatus [estado=" + estado + ", codigoRespuesta=" + codigoRespuesta + ", descripcionRespuesta="
				+ descripcionRespuesta + ", ubicacionError=" + ubicacionError + ", fecha=" + fecha + ", origen="
				+ origen + "]";
	}
	
}
