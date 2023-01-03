package com.camel.soapDemo.cxf;

import org.apache.camel.component.cxf.CxfEndpoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learnwebservices.services.hello.HelloEndpoint;
@Configuration
public class CxfBean {
	
	@Value("${endpoint.wsdl}")
	private String SOAP_URL;
	
	
	@Bean(name = "cxfHello")
	public CxfEndpoint buildCxfEndpoint() {
		CxfEndpoint cxf = new CxfEndpoint();
		cxf.setAddress(SOAP_URL);
		cxf.setServiceClass(HelloEndpoint.class);
		return cxf;
	}
}