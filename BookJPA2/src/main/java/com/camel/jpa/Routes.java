package com.camel.jpa;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
//import org.apache.camel.builder.endpoint.dsl.RestEndpointBuilderFactory.RestBindingMode;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class Routes extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		restConfiguration().component("undertow")
		.host("0.0.0.0").port(9094).bindingMode(RestBindingMode.auto);
				
		
		//get
		rest().get("get").route()
		.to("jpa://com.camel.jpa.Book?namedQuery=findAll");
		
		
		//post
		rest().post("add")
		.route().routeId("post book").log("post ---- ${body}")
		.marshal().json(JsonLibrary.Jackson)
		.process(new BookBindProcess())
		.to("jpa://com.camel.jpa.Book");
		
		//update
		rest().put("update/{id}")
		.route().log("update---- ${body}")
		.marshal().json(JsonLibrary.Jackson)
		.process(new NewBookBindProcess())
		.to("jpa://com.camel.jpa.Book");
		
		//delete
		rest().delete("delete/{id}")
		.route()
		.toD("jpa://com.camel.CamelJPA.Book"
            + "?nativeQuery=DELETE FROM books where id = ${header.id}");
		
		
	}

	

}
