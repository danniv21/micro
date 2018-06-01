package com.claro.miclaro.validacion.comprapaquete.dto;

public class ResumenBolsaActiva {
	private double saldoTotal;
	private double saldoDisponible;
	private double saldoConsumido;
	private String servicio;
	private boolean flagIlimitado;
	private CompraPaquete compraPaquete;

	public ResumenBolsaActiva() {
	}
	
	public ResumenBolsaActiva(String servicio) {
		flagIlimitado = false;	
		saldoConsumido = 0;		
		saldoDisponible = 0;
		saldoTotal = 0;
		this.servicio = servicio;
		compraPaquete = new CompraPaquete();
	}
	
	public ResumenBolsaActiva(double saldoTotal, double saldoDisponible, double saldoConsumido, String servicio,
			boolean flagIlimitado, CompraPaquete compraPaquete) {
		super();
		this.saldoTotal = saldoTotal;
		this.saldoDisponible = saldoDisponible;
		this.saldoConsumido = saldoConsumido;
		this.servicio = servicio;
		this.flagIlimitado = flagIlimitado;
		this.compraPaquete = compraPaquete;
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public double getSaldoConsumido() {
		return saldoConsumido;
	}

	public void setSaldoConsumido(double saldoConsumido) {
		this.saldoConsumido = saldoConsumido;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public boolean isFlagIlimitado() {
		return flagIlimitado;
	}

	public void setFlagIlimitado(boolean flagIlimitado) {
		this.flagIlimitado = flagIlimitado;
	}

	public CompraPaquete getCompraPaquete() {
		return compraPaquete;
	}

	public void setCompraPaquete(CompraPaquete compraPaquete) {
		this.compraPaquete = compraPaquete;
	}

	@Override
	public String toString() {
		return "ResumenBolsaActivaDTO [saldoTotal=" + saldoTotal + ", saldoDisponible=" + saldoDisponible
				+ ", saldoConsumido=" + saldoConsumido + ", servicio=" + servicio + ", flagIlimitado=" + flagIlimitado
				+ ", compraPaquete=" + compraPaquete + "]";
	}

}
