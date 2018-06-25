package pe.com.claro.sales.order.message.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.claro.sales.order.model.Customer;

@Component
public class Producer
{
   @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private static final String EXCHANGE = "sales_data_exchange";
    private static final String ROUTING_KEY = "customer.order";

    public void produce(Customer customer)
    {
        LOGGER.info(" Publishing the Customer " + customer.getId());
        Message msg= new Message(customer.getCustomerName() + " "+ customer.getCustomerLastName());
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
    }
}
