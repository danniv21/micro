package com.claro.miclaro.cuenta.prepago.exception;

/**
 * @author Jose Mestas
 * @clase: BaseException.java
 * @descripcion Clase base para el manejo de excepciones
 * @author_company: CLARO.
 * @fecha_de_creacion: 15-12-2017.
 * @fecha_de_ultima_actualizacion: 15-12-2017.
 * @version 1.0
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = 5083267333882997675L;
	private Exception exception;
    private String code;
    private String message;
    private String messageDeveloper;
    
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
    
    public BaseException(String code, String message, String messageDeveloper) {
		super(message);
		this.code = code;
		this.message = message;
		this.messageDeveloper = messageDeveloper;
	}

    public BaseException(String code, String message, String messageDeveloper, Exception exception) {
		super(message);
		this.code = code;
		this.message = message;
		this.messageDeveloper = messageDeveloper;
		this.exception = exception;
	}

	public BaseException(Exception exception) {
        this.exception = exception;
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

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

}
