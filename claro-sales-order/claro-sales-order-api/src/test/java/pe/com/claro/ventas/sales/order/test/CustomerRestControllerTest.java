/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro.ventas.sales.order.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pe.com.claro.sales.order.service.CustomerService;
import pe.com.claro.sales.order.controller.CustomerRestController;
import pe.com.claro.sales.order.model.Customer;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 *
 * @author user
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerRestControllerTest {

    @Mock
    private CustomerService customerService;
    private CustomerRestController customerRestController;

    @Before
    public void setUp() throws Exception {
        customerRestController = new CustomerRestController(customerService);

    }

    @Test
    public void searchUserTest() throws Exception {
        final Customer savedCustomer = stubServiceToReturnStoredCustomer();
        Customer returnedSearch = customerRestController.search(new Long("1"));
        assertEquals(savedCustomer.getCustomerEmail(), returnedSearch.getCustomerEmail());
        verify(customerService, times(1)).getPostCustomer(new Long("1"));

    }

    private Customer stubServiceToReturnStoredCustomer() {
        final Customer customer = Utiltest.createCustomer();
        when(customerService.getPostCustomer(anyLong())).thenReturn(customer);
        return customer;
    }
}
