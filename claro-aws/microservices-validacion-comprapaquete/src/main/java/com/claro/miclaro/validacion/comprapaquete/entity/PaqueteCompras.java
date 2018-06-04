package com.claro.miclaro.validacion.comprapaquete.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buypackage")
public class PaqueteCompras implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "type_client")
	private String tipoCliente;

	@Column(name = "type_package")
	private String tipoPaquete;

	@Column(name = "min_value")
	private int valorMinimo;

	@Column(name = "message")
	private String mensaje;

	@Column(name = "type_value")
	private String tipoValor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTypeClient(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getTipoPaquete() {
		return tipoPaquete;
	}

	public void setTipoPaquete(String tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}

	public int getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(int valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTipoValor() {
		return tipoValor;
	}

	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}

	@Override
	public String toString() {
		return "PaqueteCompras [id=" + id + ", tipoCliente=" + tipoCliente + ", tipoPaquete=" + tipoPaquete
				+ ", valorMinimo=" + valorMinimo + ", mensaje=" + mensaje + ", tipoValor=" + tipoValor + "]";
	}

	
	
}
