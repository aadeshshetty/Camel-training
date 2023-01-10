package com.camel.integrate.domain;

public class EmployeeAnnualSalary {
	private String emp_name;
	private Double salary;
	public EmployeeAnnualSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeAnnualSalary(String emp_name, Double salary) {
		super();
		this.emp_name = emp_name;
		this.salary = salary;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
