package com.camel.api;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class multicast  extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:D:\\Json")
		.log("${body}").to("direct:completed");
		
		from("direct:completed")
//		.process(new conversion())
//        .split(body())
//        .setBody().constant("Thanks for taking the exam")
        .multicast()
        	.pipeline()
        		.to("direct:passed")
        		.to("direct:average")
        		.end()
        .log("multicast")
        .to("direct:failed")
        
        .end();
		
		from("direct:passed")
		.setBody(simple("${body} and passed the exam"))
		.log(" we are in passed route: ${body}");
		//.log("${body} is passed ....${threadName}");
		
		from("direct:failed")
		//.setBody(simple("better luck next time"))
		.setBody(simple("${body} failed the exam better luck next time"))
		.log(" we are in failed route: ${body}");
		
		from("direct:average")
		.setBody(simple("${body} and scored above average marks"))
		.log(" we are in average route: ${body}");
		//.log("${body} and scored above average marks ");
        
		
	}

}
