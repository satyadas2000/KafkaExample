package com.KafkaExample;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DeliveryPublisher {
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    
  
    public void sendToOrderCallback(Customer cust) throws JsonProcessingException {
    	// key as null , because not needed
        kafkaTemplate.send("customer",cust.getCategory(), objectMapper.writeValueAsString(cust));
        System.out.println("message sent");
    }

}
