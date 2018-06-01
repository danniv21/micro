package com.claro.miclaro.cuenta.prepago.dto;

public class HeaderBeanRequest
{
    private HeaderRequest HeaderRequest;

    public HeaderRequest getHeaderRequest ()
    {
        return HeaderRequest;
    }

    public void setHeaderRequest (HeaderRequest HeaderRequest)
    {
        this.HeaderRequest = HeaderRequest;
    }

	@Override
	public String toString() {
		return "HeaderBeanRequest [HeaderRequest=" + HeaderRequest + "]";
	}

}