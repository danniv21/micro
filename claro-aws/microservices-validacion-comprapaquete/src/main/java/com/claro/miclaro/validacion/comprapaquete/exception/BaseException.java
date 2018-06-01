package com.claro.miclaro.validacion.comprapaquete.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	private Exception exception;
	private String code;
	private String message;
	private String messageDeveloper;
	private HttpStatus status;

	public BaseException(String code, String message, Exception exception) {
		super(message);
		this.exception = exception;
		this.code = code;
		this.message = message;
	}

	public BaseException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public BaseException(String message, Exception exception) {
		super(message);
		this.exception = exception;
		this.message = message;
	}

	public BaseException(String code, String message, HttpStatus status) {
		super(message);
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public BaseException(String code, String message, String messageDeveloper, Exception exception, HttpStatus status) {
		super(message);
		this.code = code;
		this.message = message;
		this.messageDeveloper = messageDeveloper;
		this.exception = exception;
		this.status = status;
	}

	public BaseException(Exception exception) {
		this.exception = exception;
	}

	public BaseException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getCode() {
		return code;
	}

	public String getMessageDeveloper() {
		return messageDeveloper;
	}

	public void setMessageDeveloper(String messageDeveloper) {
		this.messageDeveloper = messageDeveloper;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}