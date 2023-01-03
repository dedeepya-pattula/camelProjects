package com.camel.api;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class Dynamic {
	
	public String route(String body, @Header(Exchange.SLIP_ENDPOINT) String previousRoute) {
		if (previousRoute == null) {
			return "direct://average";
			// check the body content and decide route
		} else if (body.toString().equals("ram in average")) {
			return "direct://failed";
			// check the body content and decide route
		} else if (body.toString().equals("ram in average in failed")) {
			return "direct://passed";
		} else {
			return null;
		}
	}


}
