package pe.com.claro.sales.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.common.resource.exception.CustomEntityNotFoundException;
import pe.com.claro.sales.order.model.Customer;
import pe.com.claro.sales.order.repository.CustomerRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private pe.com.claro.sales.order.message.component.Producer producer;

    @Value("${application.appname.customerservice.message001}")
    private String message001;

    @Transactional(readOnly = true)
    //@HystrixCommand(fallbackMethod = "getTokenHystrixFallbackMethod")
    
     @HystrixCommand(fallbackMethod = "getTokenHystrixFallbackMethod",
                    commandProperties = {
                            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
                    })
    public Customer getPostCustomer(Long customerId) {
        //logger.debug("Get post " + customerId);
        logger.info("Get postw " + customerId);
        Customer customer = customerRepository.findOne(customerId);
//		producer.produce(customer);
        return customer;
    }

    public Customer getTokenHystrixFallbackMethod(Long customerId) {
        logger.error("Error en el Sistema Intente Nuevamente ");
        logger.info("Error en el Sistema Intente Nuevamentes ");
        //Customer customer = null;
        Customer cus= new Customer();
        cus.setId(customerId);
        return cus;
        //throw new CustomEntityNotFoundException(message001 + " " + customerId.toString());
        //Customer customer = null;
//        if (customer == null) {
//            throw new CustomEntityNotFoundException(message001 + " " + customerId.toString());
//        }
        //return customer;
    }
}
