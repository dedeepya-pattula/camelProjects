package com.camel.sql;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	ProducerTemplate producerTemplate;
	
	//public String KAFKA_ENDPOINT = "kafka:%s?brokers=localhost=9092";
	@GetMapping("/get")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = producerTemplate.requestBody("direct:select", null, List.class);
		return employees;

	}

	@PostMapping("/save")
	public boolean insertEmployee(@RequestBody Employee emp) {
		producerTemplate.requestBody("direct:post", emp, Employee.class);
		return true;
	}
//	
//	@PutMapping("/update")
//	public boolean update(@RequestBody Employee emp) {
//		producerTemplate.requestBody("direct:update", emp, Employee.class);
//		return true;
//		
//	}
	
//	@DeleteMapping("/delete/{Id}")
//	public void deleteEmployee(@PathVariable String Id) {
//		
//		producerTemplate.
//	}
//	
}


