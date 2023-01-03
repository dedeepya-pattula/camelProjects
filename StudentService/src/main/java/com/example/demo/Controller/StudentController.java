package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	 StudentRepository Repo;
	
	@GetMapping("/GetAllStudentDetails")
	public List<Student> getStudents(){
		return Repo.findAll();
	}
	
	@PostMapping("/SaveStudentDetails")
	public void saveStudents(@RequestBody Student student) {
		Repo.save(student);
	}
	
	@PutMapping("/update")
	public void updateStudents(@RequestBody Student student) {
		Repo.save(student);
		
	}
	
	@DeleteMapping("/delete")  
	private void deleteBook(@RequestBody Student student)   
	{  
	Repo.delete(student);  
	}  
	
	
}
