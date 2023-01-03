package com.camel.seda;

import java.util.Date;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.DefaultMessage;
import org.springframework.stereotype.Component;
import static org.apache.camel.LoggingLevel.ERROR;
import static java.util.concurrent.TimeUnit.SECONDS;

//@Component
public class sedaRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("timer:ping?period=200")
		.process(exchange -> {
			Message message = new DefaultMessage(exchange);
			message.setBody(new Date());
			exchange.setMessage(message);
		})
//		.to("seda:slow");
//		
//		from("seda:slow")
		.to("direct:complexProcess");
		
		from("direct:complexProcess")
		.log(ERROR, "${body}")
		.process(exchange -> SECONDS.sleep(2))
		.end();
		
	}

}
