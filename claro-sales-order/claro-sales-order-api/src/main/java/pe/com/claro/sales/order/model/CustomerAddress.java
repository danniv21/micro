package pe.com.claro.sales.order.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import pe.com.claro.common.model.BaseEntity;


/**
 * The persistent class for the CustomerAddress database table.
 * 
 */
@Entity
@Table(name = "CustomerAddress")
@ApiModel(description="Informacion de las direcciones del cliente")
public class CustomerAddress extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private String address;

	private String addressCityName;

	private String addressCountryName;

	private byte addressStatus;

	private String addressZipCode;



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressCityName() {
		return addressCityName;
	}

	public void setAddressCityName(String addressCityName) {
		this.addressCityName = addressCityName;
	}

	public String getAddressCountryName() {
		return addressCountryName;
	}

	public void setAddressCountryName(String addressCountryName) {
		this.addressCountryName = addressCountryName;
	}

	public byte getAddressStatus() {
		return addressStatus;
	}

	public void setAddressStatus(byte addressStatus) {
		this.addressStatus = addressStatus;
	}

	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	

}