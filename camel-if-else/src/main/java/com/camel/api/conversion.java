package com.camel.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.camel.api.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class conversion implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		String body = exchange.getIn().getBody(String.class);
		final ObjectMapper objectMapper = new ObjectMapper();
		Student[] employees = objectMapper.readValue(body, Student[].class);
		List<Student> list = new ArrayList(Arrays.asList(employees));
		exchange.getIn().setBody(list);
	}

}
