package com.camelSplitterAggregator;

import java.util.List;

public class Salary {
	
	private List<Employee> employees;
	
	private double totalSalary;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		return "Salary [employees=" + employees + ", totalSalary=" + totalSalary + "]";
	}
	
	

}
