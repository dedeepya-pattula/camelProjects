package com.camelSplitterAggregator;

public class Employee {

	private String name;
	private String month;

	private double salary;

	public Employee() {
		super();
	}

	public Employee(String name, String month, double salary) {
		super();
		this.name = name;
		this.month = month;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", month=" + month + ", salary=" + salary + "]";
	}

}
