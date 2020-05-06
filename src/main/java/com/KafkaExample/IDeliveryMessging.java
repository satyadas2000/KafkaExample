package com.KafkaExample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

public interface IDeliveryMessging {
	String TOPIC_DELIVERY="customer";

   //@KafkaListener(topics = TOPIC_DELIVERY, 	groupId="kafka-consumer")
    
   @KafkaListener(topicPartitions = @TopicPartition(topic = "customer", partitions = { "1","3"}), groupId="kafka-consumer")
   void consumeMessage(String content);
}
