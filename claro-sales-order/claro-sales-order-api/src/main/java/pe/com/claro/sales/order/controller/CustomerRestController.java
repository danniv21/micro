package pe.com.claro.sales.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.http.HttpStatus;

import pe.com.claro.sales.order.model.Customer;
import pe.com.claro.sales.order.service.CustomerService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RefreshScope
@RestController
@RequestMapping("/api/customers")
class CustomerRestController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);

    @Value("${application.appname.customerservice.message001}")
    private String message001;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Buscar cliente por id",
//            notes = "Retorna la información de un cliente en especifico")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Customer search(@PathVariable Long customerId) {
        //logger.error("Prueba Cambio: [" + message001 + "]");

        return customerService.getPostCustomer(customerId);
    }
}
