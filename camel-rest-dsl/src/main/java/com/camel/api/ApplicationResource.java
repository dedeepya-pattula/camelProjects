package com.camel.api;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.camel.model.rest.RestDefinition;
//import com.camel.api.StudentService;

@Component
public class ApplicationResource  extends RouteBuilder{

	//@Autowired
	//private StudentService service;
	@Autowired
	private StudentController controller;
	
	//CamelContext camelCentext = new DefaultCamelContext();
	//camelContext.addRoute();
	@Override
	public void configure() throws Exception {
		
		restConfiguration().component("servlet").port(8088).host("localhost").bindingMode(RestBindingMode.json);
		
		
		rest().consumes("application/json").produces("application/json").get()
        .to("rest:get:/get");
    
        rest().consumes("application/json").produces("application/json").post()
        .to("rest:post:/save");
        
//	     from("timer:rest-api-consumer?period=10000")
//	     .log("${body}")
//	     .to("rest:get:/get");
		
	     
	    /*  rest()
	     .post("/save")
	     .process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				//StudentController studentController = new StudentController();
				controller.addStudent(exchange.getIn().getBody(Student.class));
			}
		})
	     .to(null);
	     */
	     
	     
	     //from("timer:rest-api-consumer?period=10000")
	     /*rest("/students")
	     .post()
	     .log("${body}")
	     .to("rest:post:/save");*/
		
		
		
		
		
		
		
		
		
	     /*rest("/say")
	        .get("/hello").to("direct:hello");
	     from("direct:hello")
	        .transform().constant("Hello World");
	     	     
	     /*rest()
	     .get("/getStudents")
	     .produces(MediaType.APPLICATION_JSON_VALUE)
	     .route().setBody(()->service.getStudent());*/
	    
	     /*rest()
	     .get("/get")
	     //from("timer:rest-api-consumer?period=10000")
	     //.log("${body}")
	     .to("direct:start");
	     
	     from("direct:start")
	     .to("class:com.camel.api.StudentService?method=getStudent");*/
	     
	    /*.get("/bye").consumes("application/json").to("direct:bye")
	      rest()
	     .get("/getStudents")
	     .produces(MediaType.APPLICATION_JSON_VALUE)
	     .setBody(()->service.getStudent());
	    
	      rest().post("/addStudents")
	      .consumes(MediaType.APPLICATION_JSON_VALUE)
	      .type(Student.class).outType(Student.class).route().process();
	    */
	      
	    
	}

}
