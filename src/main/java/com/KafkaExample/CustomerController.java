package com.KafkaExample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test-doc")
public class CustomerController {
	
	
    @Autowired
    private DeliveryPublisher deliveryService;
    
	@RequestMapping("/customers")
    public List<Customer> findAll() throws Exception
    {
		List<Customer> customerList;
	      customerList = new ArrayList<Customer>(); 
	      customerList.add(new Customer(1, "frank","abc","USA"));
	      customerList.add(new Customer(2, "john","bcd","India"));
	      
	      deliveryService.sendToOrderCallback(new Customer(1, "frank","abc","USA"));
	      deliveryService.sendToOrderCallback(new Customer(2, "satya","abc","India"));
	      deliveryService.sendToOrderCallback(new Customer(3, "ram","abc","UK"));
   return customerList;
    
    }

}
