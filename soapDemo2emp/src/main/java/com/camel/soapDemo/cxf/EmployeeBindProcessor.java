package com.camel.soapDemo.cxf;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBindProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		String body = exchange.getIn().getBody(String.class);
		String[] data = body.split("\n");
		for(int i=1;i<data.length;i++) {
			String[] arr=data[i].split(",");
			
			Employee e = new Employee();
			System.out.println(data[i]);
			e.setEmp_name(arr[0]);
			e.setId(arr[1]);
			employeeList.add(e);
		}
		exchange.getIn().setBody(employeeList);
	}

}
