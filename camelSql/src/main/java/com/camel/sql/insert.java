package com.camel.sql;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class insert implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String employee = exchange.getIn().getBody(String.class);
		//System.out.println("emp"+employee); //Employee [empId=8, empName=sai]
		int ind = employee.indexOf('=');
		int indc = employee.indexOf(',');
		String id = employee.substring(ind + 1, indc);
		int indl = employee.lastIndexOf('=');
		int indb = employee.indexOf(']');
		String name = employee.substring(indl + 1, indb);
		//System.out.println(name);
		Employee emp = new Employee(id, name);
		String query = "INSERT INTO employee(empId,empName)values('" + emp.getEmpId() + "','" + emp.getEmpName()
				+ "')";
		exchange.getIn().setBody(query);


}

}
