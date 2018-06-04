package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.claro.miclaro.cuenta.prepago.util.Constants;

public class AuditResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String servicio;
	private String metodo;
	private String idTransaccion;
	private String codigoRespuesta;
	private String descripcionRespuesta;
	private String msisdn;
	private String fecha;
	
	public AuditResponse(){
		DateFormat sdf = new SimpleDateFormat(Constants.FORMAT_DATE_TIME_ZONE);
		sdf.setTimeZone(TimeZone.getTimeZone(Constants.TIME_ZONE_LIMA));
		String fechaActual = sdf.format(new Date());
		this.fecha = fechaActual;
	}
	
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
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
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "AuditResponse [servicio=" + servicio + ", metodo=" + metodo + ", idTransaccion=" + idTransaccion
				+ ", codigoRespuesta=" + codigoRespuesta + ", descripcionRespuesta=" + descripcionRespuesta
				+ ", msisdn=" + msisdn + ", fecha=" + fecha + "]";
	}

}
