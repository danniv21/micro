package pe.com.claro.sales.order.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import pe.com.claro.common.model.BaseEntity;
import pe.com.claro.sales.order.model.CustomerAddress;

/**
 * The persistent class for the Customer database table.
 *
 */
@Entity
@Table(name = "Customer")
@ApiModel(description = "informacion del cliente")
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String customerEmail;

    private String customerLastName;

    private String customerName;

    private byte status;
    /*
	//bi-directional many-to-one association to CustomerAddress
	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)*/
    @ManyToOne
    @JoinColumn(name = "customerAddressId")
    private CustomerAddress customerAddresses;

    public Customer(String customerEmail, String customerLastName, String customerName, byte status, CustomerAddress customerAddresses) {
        this.customerEmail = customerEmail;
        this.customerLastName = customerLastName;
        this.customerName = customerName;
        this.status = status;
        this.customerAddresses = customerAddresses;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public CustomerAddress getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(CustomerAddress customerAddresses) {
        this.customerAddresses = customerAddresses;
    }

}
