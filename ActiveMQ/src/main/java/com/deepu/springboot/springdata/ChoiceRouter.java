package com.deepu.springboot.springdata;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ChoiceRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:D:/data").split().tokenize("\n").to("direct:choice");
        
		//Content Based routing- Route the message based on the token it contains.
		        from("direct:choice") 
		        .choice()
		        .when(body().contains("hello world"))
		        .to("direct:hello-world")
				.when(simple("${body} contains 'something' ")).to("direct:something")
		        .otherwise()
		        .to("direct:dummy-route")
		        .end();
		        
		        
		        from("direct:hello-world")
				.log("hello world route!");
				
				from("direct:something")
				.log("something route!");
				
				from("direct:dummy-route")
				.log("dummy route!");
		
//		restConfiguration().component("servlet");
//		rest("/pay")
//		.post()
//		.to("direct:choice");
		


	}
}
