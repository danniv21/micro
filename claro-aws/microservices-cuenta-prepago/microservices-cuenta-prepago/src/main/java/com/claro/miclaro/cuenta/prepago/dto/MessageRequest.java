package com.claro.miclaro.cuenta.prepago.dto;

import java.io.Serializable;

public class MessageRequest implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BodyRequest Body;
    private HeaderBeanRequest Header;

    public BodyRequest getBody ()
    {
        return Body;
    }

    public void setBody (BodyRequest Body)
    {
        this.Body = Body;
    }

    public HeaderBeanRequest getHeader ()
    {
        return Header;
    }

    public void setHeader (HeaderBeanRequest Header)
    {
        this.Header = Header;
    }

	@Override
	public String toString() {
		return "MessageRequest [Body=" + Body + ", Header=" + Header + "]";
	}

}