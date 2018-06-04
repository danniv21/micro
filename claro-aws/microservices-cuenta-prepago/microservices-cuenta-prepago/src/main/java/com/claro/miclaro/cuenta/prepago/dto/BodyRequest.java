package com.claro.miclaro.cuenta.prepago.dto;

public class BodyRequest
{
    private String msisdn;

    public String getMsisdn ()
    {
        return msisdn;
    }

    public void setMsisdn (String msisdn)
    {
        this.msisdn = msisdn;
    }

	@Override
	public String toString() {
		return "Body [msisdn=" + msisdn + "]";
	}
    
}