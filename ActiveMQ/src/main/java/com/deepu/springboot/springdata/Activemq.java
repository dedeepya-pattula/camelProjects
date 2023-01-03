package com.deepu.springboot.springdata;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Activemq extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("timer:active-mq-timer?period=10000")
		.transform().constant("My message for active mq")
		.to("activemq:my-activemq-queue");
	}

}
