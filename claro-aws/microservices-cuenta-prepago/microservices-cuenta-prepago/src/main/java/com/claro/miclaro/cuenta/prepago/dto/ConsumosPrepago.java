package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ConsumosPrepago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fechaActualizacion;
	private ListaOtroPaquetesActivos listaOtroPaquetesActivos;
	private ListaPaquetesActivos listaPaquetesActivos;
	private ListaResumenPaquetesActivos listaResumenPaquetesActivos;
	
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
		return "ConsumosPrepago [fechaActualizacion=" + fechaActualizacion + ", listaOtroPaquetesActivos="
				+ listaOtroPaquetesActivos + ", listaPaquetesActivos=" + listaPaquetesActivos
				+ ", listaResumenPaquetesActivos=" + listaResumenPaquetesActivos + "]";
	}
	
}
