package com.camel.jpa;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NewBookBindProcess implements Processor {

	public void process(Exchange exchange) throws Exception {

		Integer id = Integer.valueOf(exchange.getIn().getHeader("id").toString());
		ObjectMapper obj = new ObjectMapper();
		Book book = obj.readValue(exchange.getIn().getBody(String.class), Book.class);
		book.setId(id);
		exchange.getIn().setBody(book);
	}

}
