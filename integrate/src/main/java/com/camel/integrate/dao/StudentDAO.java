package com.camel.integrate.dao;

import java.util.*;


import org.springframework.stereotype.Service;

import com.camel.integrate.domain.Student;

@Service
public class StudentDAO {

	static List<Student> studentList = new ArrayList<Student>();
	static {
		studentList.add(new Student("22A1", "Elizabeth", 980.00));
		studentList.add(new Student("22A2", "Michael", 800.00));
		studentList.add(new Student("22A3", "Charlotte",900.00));
		studentList.add(new Student("22A4", "Lucas", 950.00));
	}

	public List<Student> list() {
		return studentList;
	}
	
	public Student save(Student student) {
		studentList.add(student);
		return student;
	}
	
	public boolean delete(String id) {
		for(int i=0;i<studentList.size();i++) {
			if(studentList.get(i).getRollno().equals(id)) {
				studentList.remove(i);
				return true;
			}
		}
		return false;
	}

}
