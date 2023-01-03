package com.example.springbootkafka;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class kafkaRoutes extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		fromF("kafka:topic-test?brokers=localhost:9092")
		.log("${body}");
		
	}

}
