package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class HeaderRequest implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String timestamp;
    private String operation;
    private String system;
    private String dispositivo;
    private String userId;
    private String modulo;
    private String pid;
    private String msgType;
    private String language;
    private String wsIp;
    private String consumer;
    private String country;

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getOperation ()
    {
        return operation;
    }

    public void setOperation (String operation)
    {
        this.operation = operation;
    }

    public String getSystem ()
    {
        return system;
    }

    public void setSystem (String system)
    {
        this.system = system;
    }

    public String getDispositivo ()
    {
        return dispositivo;
    }

    public void setDispositivo (String dispositivo)
    {
        this.dispositivo = dispositivo;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getModulo ()
    {
        return modulo;
    }

    public void setModulo (String modulo)
    {
        this.modulo = modulo;
    }

    public String getPid ()
    {
        return pid;
    }

    public void setPid (String pid)
    {
        this.pid = pid;
    }

    public String getMsgType ()
    {
        return msgType;
    }

    public void setMsgType (String msgType)
    {
        this.msgType = msgType;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getWsIp ()
    {
        return wsIp;
    }

    public void setWsIp (String wsIp)
    {
        this.wsIp = wsIp;
    }

    public String getConsumer ()
    {
        return consumer;
    }

    public void setConsumer (String consumer)
    {
        this.consumer = consumer;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

	@Override
	public String toString() {
		return "HeaderRequest [timestamp=" + timestamp + ", operation=" + operation + ", system=" + system
				+ ", dispositivo=" + dispositivo + ", userId=" + userId + ", modulo=" + modulo + ", pid=" + pid
				+ ", msgType=" + msgType + ", language=" + language + ", wsIp=" + wsIp + ", consumer=" + consumer
				+ ", country=" + country + "]";
	}
    
}