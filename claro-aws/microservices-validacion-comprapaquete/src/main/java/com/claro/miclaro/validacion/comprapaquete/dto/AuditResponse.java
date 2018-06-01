package com.claro.miclaro.validacion.comprapaquete.dto;

public class AuditResponse {

	private String metodo;
	private String idTransaccion;
	private String codigoRespuesta;
	private String descripcionRespuesta;
	private String fecha;

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "AuditResponse [metodo=" + metodo + ", idTransaccion=" + idTransaccion + ", codigoRespuesta="
				+ codigoRespuesta + ", descripcionRespuesta=" + descripcionRespuesta + ", fecha=" + fecha + "]";
	}

}
