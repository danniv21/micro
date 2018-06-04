package com.claro.miclaro.validacion.comprapaquete.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {
	@Value("${microservicio.name}")
	private String microservicioName;

	// IDF
	@Value("${validacioncomprapaquete.codigo.idf0}")
	private String validacioncomprapaqueteCodigoIdf0;

	@Value("${validacioncomprapaquete.mensaje.idf0}")
	private String validacioncomprapaqueteMensajeIdf0;

	@Value("${validacioncomprapaquete.codigo.idf1}")
	private String validacioncomprapaqueteCodigoIdf1;

	@Value("${validacioncomprapaquete.mensaje.idf1}")
	private String validacioncomprapaqueteMensajeIdf1;

	@Value("${validacioncomprapaquete.codigo.idf2}")
	private String validacioncomprapaqueteCodigoIdf2;

	@Value("${validacioncomprapaquete.mensaje.idf2}")
	private String validacioncomprapaqueteMensajeIdf2;

	// IDT
	@Value("${validacioncomprapaquete.codigo.idt1}")
	private String validacioncomprapaqueteCodigoIdt1;

	@Value("${validacioncomprapaquete.mensaje.idt1}")
	private String validacioncomprapaqueteMensajeIdt1;

	@Value("${validacioncomprapaquete.codigo.idt2}")
	private String validacioncomprapaqueteCodigoIdt2;

	@Value("${validacioncomprapaquete.mensaje.idt2}")
	private String validacioncomprapaqueteMensajeIdt2;

	@Value("${validacioncomprapaquete.codigo.idt3}")
	private String validacioncomprapaqueteCodigoIdt3;

	@Value("${validacioncomprapaquete.mensaje.idt3}")
	private String validacioncomprapaqueteMensajeIdt3;

	public String getMicroservicioName() {
		return microservicioName;
	}

	public String getValidacioncomprapaqueteCodigoIdf0() {
		return validacioncomprapaqueteCodigoIdf0;
	}

	public String getValidacioncomprapaqueteMensajeIdf0() {
		return validacioncomprapaqueteMensajeIdf0;
	}

	public String getValidacioncomprapaqueteCodigoIdf1() {
		return validacioncomprapaqueteCodigoIdf1;
	}

	public String getValidacioncomprapaqueteMensajeIdf1() {
		return validacioncomprapaqueteMensajeIdf1;
	}

	public String getValidacioncomprapaqueteCodigoIdf2() {
		return validacioncomprapaqueteCodigoIdf2;
	}

	public String getValidacioncomprapaqueteMensajeIdf2() {
		return validacioncomprapaqueteMensajeIdf2;
	}

	public String getValidacioncomprapaqueteCodigoIdt1() {
		return validacioncomprapaqueteCodigoIdt1;
	}

	public String getValidacioncomprapaqueteMensajeIdt1() {
		return validacioncomprapaqueteMensajeIdt1;
	}

	public String getValidacioncomprapaqueteCodigoIdt2() {
		return validacioncomprapaqueteCodigoIdt2;
	}

	public String getValidacioncomprapaqueteMensajeIdt2() {
		return validacioncomprapaqueteMensajeIdt2;
	}

	public String getValidacioncomprapaqueteCodigoIdt3() {
		return validacioncomprapaqueteCodigoIdt3;
	}

	public String getValidacioncomprapaqueteMensajeIdt3() {
		return validacioncomprapaqueteMensajeIdt3;
	}

	

	
}
