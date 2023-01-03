package com.camel.api;

//import javax.annotation.processing.Processor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class dynamicRouter  extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:D:\\Json").split().tokenize("\n").dynamicRouter(method(Dynamic.class, "route"));

		from("direct:passed").process(new Processor() {
			public void process(Exchange exchange) {
				String body = exchange.getIn().getBody().toString();
				body = body + " in passed";
				System.out.println(body);
				exchange.getIn().setBody(body);
			}
		});

		from("direct:failed").process(new Processor() {
			public void process(Exchange exchange) {
				String body = exchange.getIn().getBody().toString();
				body = body + " in failed";
				System.out.println(body);
				exchange.getIn().setBody(body);
			}
		});

		from("direct:average").process(new Processor() {
			public void process(Exchange exchange) {
				String body = exchange.getIn().getBody().toString();
				body = body + " in average";
				exchange.getIn().setBody(body);
				System.out.println(body);
			}
		});
	}
	}

