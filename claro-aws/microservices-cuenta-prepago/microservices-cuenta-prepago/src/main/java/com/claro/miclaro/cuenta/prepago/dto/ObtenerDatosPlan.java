package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class ObtenerDatosPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoPlan;
	private String nombrePlan;
	private String fechaVencimiento;
	private String saldoPrepago;
	private boolean flagRecargar;
	private String rate;
	private String dataPackage;
	private String voicePackage;
	
	public String getTipoPlan() {
		return tipoPlan;
	}
	public void setTipoPlan(String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}
	public String getNombrePlan() {
		return nombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
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
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDataPackage() {
		return dataPackage;
	}
	public void setDataPackage(String dataPackage) {
		this.dataPackage = dataPackage;
	}
	public String getVoicePackage() {
		return voicePackage;
	}
	public void setVoicePackage(String voicePackage) {
		this.voicePackage = voicePackage;
	}
	public boolean isFlagRecargar() {
		return flagRecargar;
	}
	public void setFlagRecargar(boolean flagRecargar) {
		this.flagRecargar = flagRecargar;
	}
	@Override
	public String toString() {
		return "ObtenerDatosPlan [tipoPlan=" + tipoPlan + ", nombrePlan=" + nombrePlan + ", fechaVencimiento="
				+ fechaVencimiento + ", saldoPrepago=" + saldoPrepago + ", flagRecargar=" + flagRecargar + ", rate="
				+ rate + ", dataPackage=" + dataPackage + ", voicePackage=" + voicePackage + "]";
	}
	
}
