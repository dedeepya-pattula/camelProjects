package com.camel.soapDemo.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Component;

import com.camel.soapDemo.cxf.Employee;
import com.camel.soapDemo.cxf.EmployeeBindProcessor;
import com.learnwebservices.services.hello.HelloRequest;
import com.learnwebservices.services.hello.HelloResponse;

@Component
public class SoapRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("file:D:/input1").convertBodyTo(String.class)

				.process(new EmployeeBindProcessor())
				.split(body())
			//.split().tokenize("\n")
		
				.process(new Processor() {

					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						Employee emp = exchange.getIn().getBody(Employee.class);
						//String body = exchange.getIn().getBody(String.class);
						HelloRequest hr = new HelloRequest();
						//hr.setName(body);
						hr.setName(emp.getEmp_name());
						exchange.getIn().setBody(hr);
					}
				})
				.setHeader(CxfConstants.OPERATION_NAME, constant("{{endpoint.operation.sayhello}}"))
				.setHeader(CxfConstants.OPERATION_NAMESPACE, constant("{{endpoint.namespace}}"))
				.to("cxf:bean:cxfHello")
				
				.process(new Processor() {

					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
					
						MessageContentsList m = (MessageContentsList) exchange.getIn().getBody();
						HelloResponse hre = (HelloResponse) m.get(0);
						exchange.getIn().setBody(hre.getMessage());

					}
				}).log("${body}");

	}

}
