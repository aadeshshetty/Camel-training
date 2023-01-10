package com.camel.integrate.domain;

public class Student {
	private String rollno;
	private String name;
	private double marksObtained;
	
	public Student() {
	}
	
	public Student(String rollno, String name, double marksObtained) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marksObtained = marksObtained;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}
	
	
}
