/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro.ventas.sales.order.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import pe.com.claro.sales.order.model.Customer;
import pe.com.claro.sales.order.repository.CustomerRepository;
import pe.com.claro.sales.order.service.CustomerService;

/**
 *
 * @author user
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImpTest {

    @Mock
    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService(customerRepository);
    }
    @Test
    public void searchUserTest() throws Exception {
        final Customer savedCustomer = stubServiceToReturnStoredCustomer();
        Customer returnedSearch = customerService.getPostCustomer(new Long("1"));
        assertEquals(savedCustomer.getCustomerEmail(), returnedSearch.getCustomerEmail());
        verify(customerRepository, times(1)).findOne(new Long("1"));
    }
    private Customer stubServiceToReturnStoredCustomer() {
        final Customer customer = Utiltest.createCustomer();
        when(customerService.getPostCustomer(anyLong())).thenReturn(customer);
        return customer;
    }
}
