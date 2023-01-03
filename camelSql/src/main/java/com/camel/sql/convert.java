package com.camel.sql;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class convert implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);
		final ObjectMapper objectMapper = new ObjectMapper();
		Employee[] employees = objectMapper.readValue(body, Employee[].class);
		List<Employee> list = new ArrayList(Arrays.asList(employees));
		exchange.getIn().setBody(list);
		
	}

}
