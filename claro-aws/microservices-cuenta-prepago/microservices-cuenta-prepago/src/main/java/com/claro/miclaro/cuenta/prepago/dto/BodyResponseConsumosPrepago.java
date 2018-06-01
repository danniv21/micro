package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class BodyResponseConsumosPrepago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoRespuesta;
	private String fechaActualizacion;
	private String idTransaccion;
	private String mensajeRespuesta;
	private ListaOtroPaquetesActivos listaOtroPaquetesActivos;
	private ListaPaquetesActivos listaPaquetesActivos;
	private ListaResumenPaquetesActivos listaResumenPaquetesActivos;
	
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	public ListaOtroPaquetesActivos getListaOtroPaquetesActivos() {
		return listaOtroPaquetesActivos;
	}
	public void setListaOtroPaquetesActivos(ListaOtroPaquetesActivos listaOtroPaquetesActivos) {
		this.listaOtroPaquetesActivos = listaOtroPaquetesActivos;
	}
	public ListaPaquetesActivos getListaPaquetesActivos() {
		return listaPaquetesActivos;
	}
	public void setListaPaquetesActivos(ListaPaquetesActivos listaPaquetesActivos) {
		this.listaPaquetesActivos = listaPaquetesActivos;
	}
	
	public ListaResumenPaquetesActivos getListaResumenPaquetesActivos() {
		return listaResumenPaquetesActivos;
	}
	public void setListaResumenPaquetesActivos(ListaResumenPaquetesActivos listaResumenPaquetesActivos) {
		this.listaResumenPaquetesActivos = listaResumenPaquetesActivos;
	}
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	@Override
	public String toString() {
		return "BodyResponseConsumosPrepago [codigoRespuesta=" + codigoRespuesta + ", fechaActualizacion="
				+ fechaActualizacion + ", idTransaccion=" + idTransaccion + ", mensajeRespuesta=" + mensajeRespuesta
				+ ", listaOtroPaquetesActivos=" + listaOtroPaquetesActivos + ", listaPaquetesActivos="
				+ listaPaquetesActivos + ", listaResumenPaquetesActivos=" + listaResumenPaquetesActivos + "]";
	}
}
