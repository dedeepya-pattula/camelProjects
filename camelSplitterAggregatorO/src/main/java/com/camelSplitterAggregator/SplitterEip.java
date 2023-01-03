package com.camelSplitterAggregator;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//import domain.Employee;

@Component
public class SplitterEip extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:D:/data")
		.unmarshal().csv()
		.split(body())
		.log("${body}");
		//.to("log:split");
		
	}

}
