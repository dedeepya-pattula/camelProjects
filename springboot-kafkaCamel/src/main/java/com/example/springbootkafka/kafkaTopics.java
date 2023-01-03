package com.example.springbootkafka;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.example.springbootkafka.kafkaTopics.NamesEdit;

//@Component
public class kafkaTopics extends RouteBuilder {
	
	


	final String KAFKA_ENDPOINT ="kafka:%s?brokers=localhost:9092";
	

	@Override
	public void configure() throws Exception {
		
		fromF(KAFKA_ENDPOINT, "test-topic")
		.bean(NamesEdit.class)
		.log("${body}")
		.toF(KAFKA_ENDPOINT, "demo-topic");
		
	}
	public class NamesEdit {
		public String edit(String s) {
			return s+"User";
		}

	}

}
