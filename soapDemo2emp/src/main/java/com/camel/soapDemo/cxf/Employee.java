package com.camel.soapDemo.cxf;

import java.util.HashMap;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="Employee")
public class Employee {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private String emp_name;
	private String id;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String emp_name, String id) {
		super();
		this.emp_name = emp_name;
		this.id = id;
	}
	/**
	 * @return the emp_name
	 */
	public String getEmp_name() {
		return emp_name;
	}
	/**
	 * @param emp_name the emp_name to set
	 */
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [emp_name=" + emp_name + ", id=" + id + "]";
	}
	
}
