package com.camel.seda;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class DirectEndPointRoute extends RouteBuilder {
	public static final String DIRECT_START = "direct:start";
    public static final String DIRECT_END = "direct:End";

	@Override
	public void configure() throws Exception {
		
		from(DIRECT_START)
		//.routeId("StartRouteId")
        .setBody().simple("Start Message")
        .to(DIRECT_END)
        .log("Message at start route completion = ${body}");


		from(DIRECT_END)
		//.routeId("EndRouteId")
        .setBody().simple("End Message")
        .log("message after end-router completion = ${body}");
}
		
	}

	

