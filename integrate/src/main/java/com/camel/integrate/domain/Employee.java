package com.camel.integrate.domain;

import java.util.HashMap;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;


@CsvRecord(separator = ",", skipFirstLine = true)
public class Employee {
	@DataField(pos = 1)
	private String emp_name;
	@DataField(pos = 2)
	private HashMap<String, Double> salary_details;
	public Employee(String emp_name, HashMap<String, Double> salary_details) {
		super();
		this.emp_name = emp_name;
		this.salary_details = salary_details;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public HashMap<String, Double> getSalary_details() {
		return salary_details;
	}
	public void setSalary_details(HashMap<String, Double> salary_details) {
		this.salary_details = salary_details;
	}
	
}
