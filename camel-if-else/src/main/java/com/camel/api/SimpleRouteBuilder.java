package com.camel.api;



import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
	public class SimpleRouteBuilder extends RouteBuilder {

	    @Override
	    public void configure() throws Exception {
	         from("timer://time?period=6000").doTry()
	         .doTry()
	         .process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					// TODO Auto-generated method stub
					throw new IllegalArgumentException();
					
				}
			})
	         .doCatch(IllegalArgumentException.class)
	         .log("Illegal exception")
	         .endDoTry()
	         .endDoTry()
	         .process(new MyProcessor())
	            .doCatch(Exception.class)
	            .process(new Processor() {

	                public void process(Exchange exchange) throws Exception {
	                    System.out.println("handling ex");
	                }
	            });//.log("Received body ");

	}

}
