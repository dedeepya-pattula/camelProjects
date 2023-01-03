package com.camel.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	private List<Student> list = new ArrayList<>();
	
	@PostConstruct
	public void initDB() {
		list.add(new Student(1,"deepu",40));
		list.add(new Student(2,"sai",90));
		list.add(new Student(3,"ram",30));
		list.add(new Student(4,"fan",30));
		
	}
	
	@PostMapping("/save")
	public Student addStudent(@RequestBody Student message) {
		list.add(message);
		return message;
	}
	
	@GetMapping("/get")
	public List<Student> getStudent(){
		return list;
	}
	
	
	

}
