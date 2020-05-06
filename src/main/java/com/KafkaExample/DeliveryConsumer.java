package com.KafkaExample;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DeliveryConsumer implements IDeliveryMessging {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryConsumer.class);


    @Autowired
    private ObjectMapper objectMapper;
    
    @Override
    public void consumeMessage(String content) {
    	System.out.println(" message consumer ");
        try {
            Customer cust = objectMapper.readValue(content, Customer.class);
            
            System.out.println(" id "+cust.getId()+" for order name "+cust.getName());
    
            LOGGER.info(" id "+cust.getId()+" for order name "+cust.getName());
           

        } catch (IOException  e) {
            LOGGER.error(e.getMessage(), e);
        }
	
    }
}
