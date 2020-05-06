package com.KafkaExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerPartitioner implements Partitioner{
	private static Map<String,Integer> categoryToPartitionMap;
	
    @Autowired
    private ObjectMapper objectMapper;
	
	@Override
	 public void configure(Map<String, ?> configs) {
		categoryToPartitionMap = new HashMap<String, Integer>();
		categoryToPartitionMap.put("USA", 1);
		categoryToPartitionMap.put("India", 2);
		
	  }
	
	  @Override
	  public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster){
		 System.out.println("key"+key);
			  

		  if(categoryToPartitionMap.containsKey(key)){
              //If the country is mapped to particular partition return it
              return categoryToPartitionMap.get(key);
          }else {
              //If no country is mapped to particular partition distribute between remaining partitions
              int noOfPartitions = cluster.topics().size();
              int valuech=  value.hashCode()%noOfPartitions + categoryToPartitionMap.size() ;
              //return  value.hashCode()%noOfPartitions + categoryToPartitionMap.size() ;
          System.out.println("valuech"+valuech);
          return valuech;
          
          }
		  
		  
	
	  }
	  @Override
	  public void close() {
	  }



}
