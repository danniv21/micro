/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro.ventas.sales.order.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import pe.com.claro.sales.order.model.Customer;
import pe.com.claro.sales.order.model.CustomerAddress;

/**
 *
 * @author user
 */
class Utiltest {

    private static final String customerEmail = "nombre@gmail.com";
    private static final String customerLastName = "Ruiz Gonzales";
    private static final String customerName = "Christian ";
    private static final byte status = 1;
    private static final CustomerAddress customerAddresses = new CustomerAddress();

    private Utiltest() {
        customerAddresses.setAddress("");
        customerAddresses.setAddressCityName("");
        customerAddresses.setAddressCountryName("");
        customerAddresses.setAddressStatus(new Byte("1"));
        customerAddresses.setAddressZipCode("");
        customerAddresses.setCreatedBy("");
        customerAddresses.setCreatedDate(new Date("2018-06-12"));
        customerAddresses.setDeleted(true);
        customerAddresses.setId(new Long("1"));
        customerAddresses.setLastModifiedBy("");
        customerAddresses.setLastModifiedDate(new Date("2018-06-12"));
    }

    public static Customer createCustomer() {
        return new Customer(customerEmail, customerLastName, customerName, status, customerAddresses);
    }

    public static List<Customer> createCustomerList(int howMany) {
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            customerList.add(new Customer(customerEmail, customerLastName, customerName, status, customerAddresses));
        }
        return customerList;
    }
}
