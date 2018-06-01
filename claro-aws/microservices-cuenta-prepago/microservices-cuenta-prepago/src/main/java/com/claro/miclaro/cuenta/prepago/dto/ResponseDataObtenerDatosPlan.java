package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ResponseDataObtenerDatosPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fechaConsulta;
	private String nombrePlan;
	private String tipoPlan;
	private String fechaVencimiento;
	private String saldoPrepago;
	private String flagRecargar;
	
	public String getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getNombrePlan() {
		return nombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
	public String getTipoPlan() {
		return tipoPlan;
	}
	public void setTipoPlan(String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getSaldoPrepago() {
		return saldoPrepago;
	}
	public void setSaldoPrepago(String saldoPrepago) {
		this.saldoPrepago = saldoPrepago;
	}
	public String getFlagRecargar() {
		return flagRecargar;
	}
	public void setFlagRecargar(String flagRecargar) {
		this.flagRecargar = flagRecargar;
	}
	
	@Override
	public String toString() {
		return "ResponseDataObtenerDatosPlan [fechaConsulta=" + fechaConsulta + ", nombrePlan=" + nombrePlan
				+ ", tipoPlan=" + tipoPlan + ", fechaVencimiento=" + fechaVencimiento + ", saldoPrepago=" + saldoPrepago
				+ ", flagRecargar=" + flagRecargar + "]";
	}
	
}
