package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int rollno;
	private String name;
	private Double marksObtained;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollno, String name, Double marksObtained) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marksObtained = marksObtained;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(Double marksObtained) {
		this.marksObtained = marksObtained;
	}

}
