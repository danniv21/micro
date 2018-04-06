package pe.com.claro.sales.order.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.common.resource.exception.CustomEntityNotFoundException;
import pe.com.claro.sales.order.model.Customer;
import pe.com.claro.sales.order.repository.CustomerRepository;


@Service
public class CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private pe.com.claro.sales.order.message.component.Producer producer;
	
	public Customer getPostCustomer(Long customerId){
		logger.debug("Get post " + customerId);
		Customer customer = customerRepository.findOne(customerId);
		if (customer == null) {
			 throw new CustomEntityNotFoundException("No se encontro el cliente con id=" +customerId.toString());
		}
		producer.produce(customer);
		return customer;
	}
}
