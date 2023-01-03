package com.camel.seda;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelSedaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CamelSedaApplication.class, args);
		
		CamelContext camelContext = new DefaultCamelContext();
       camelContext.addRoutes(new SedaEndPointRouter());
       camelContext.start();

        ProducerTemplate producerTemplate=camelContext.createProducerTemplate();
        producerTemplate.sendBody(SedaEndPointRouter.SEDA_START, "Initial Message");
        
//        camelContext.addRoutes(new DirectEndPointRoute());
//        camelContext.start();
//
//        ProducerTemplate producerTemplate=camelContext.createProducerTemplate();
//        producerTemplate.sendBody(DirectEndPointRoute.DIRECT_START, "Initial Message");

////        Thread.sleep(2000);
	}

}
