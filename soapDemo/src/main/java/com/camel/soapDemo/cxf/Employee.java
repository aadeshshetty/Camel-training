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
	private int id;
	private String name;
	private int months;
	private Double salary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, int months, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.months = months;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
