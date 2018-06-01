package com.claro.miclaro.validacion.comprapaquete.dto;

public class CompraPaquete {
	private boolean flag;
	private String mensaje;

	
	public CompraPaquete() {
	}

	public CompraPaquete(boolean flag, String mensaje) {
		this.flag = flag;
		this.mensaje = mensaje;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "CompraPaquete [flag=" + flag + ", mensaje=" + mensaje + "]";
	}

}
