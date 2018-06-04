package com.claro.miclaro.cuenta.prepago.entity;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;

import com.claro.miclaro.cuenta.prepago.util.Constants;
import com.claro.miclaro.cuenta.prepago.util.Utilitarios;

public class HeaderRequestBean {
	 
	 @NotNull
	 private String idTransaccion;
	 @NotNull
	 private String AuthorizationApi;
	 @NotNull
	 private Date timestamp;
	 
	 public HeaderRequestBean(){
		super();
	 }
	 
	 public HeaderRequestBean(HttpHeaders httpHeaders) {
		super();
		if(httpHeaders.get(Constants.HEADER_ID_TRANSACCION)!=null){
			this.idTransaccion = httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) != null ? !httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0).isEmpty() ? httpHeaders.get(Constants.HEADER_ID_TRANSACCION).get(0) : null :  null;
		}else{
			this.idTransaccion = null;
		}
		
		if(httpHeaders.get(Constants.HEADER_TIMESTAMP)!=null){
			Calendar a = Utilitarios.toCalendar(httpHeaders.get(Constants.HEADER_TIMESTAMP) != null
					? httpHeaders.get(Constants.HEADER_TIMESTAMP).get(0) : Constants.CADENA_VACIA);
			if (a != null)
				this.timestamp = a.getTime();
		}else{
			this.timestamp = null;
		}
		
		this.AuthorizationApi = httpHeaders.get(Constants.HEADER_AUTHORIZATION_API).get(0) != null ? httpHeaders.get(Constants.HEADER_AUTHORIZATION_API).get(0) : null ;
		
	}
	
	public String getIdTransaccion(){
		return idTransaccion;
	}
	
	public void setIdTransaccion( String idTransaccion ){
		this.idTransaccion = idTransaccion;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getAuthorizationApi() {
		return AuthorizationApi;
	}

	public void setAuthorizationApi(String authorizationApi) {
		AuthorizationApi = authorizationApi;
	}

	@Override
	public String toString() {
		return "HeaderRequestBean [idTransaccion=" + idTransaccion + ", AuthorizationApi=" + AuthorizationApi
				+ ", timestamp=" + timestamp + "]";
	}
	
}
