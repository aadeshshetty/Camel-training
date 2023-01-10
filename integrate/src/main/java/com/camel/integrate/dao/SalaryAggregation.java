package com.camel.integrate.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.camel.integrate.domain.Employee;
import com.camel.integrate.domain.EmployeeAnnualSalary;

@Component
public class SalaryAggregation implements AggregationStrategy{

	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		// TODO Auto-generated method stub
		Employee newBody = newExchange.getIn().getBody(Employee.class);
		if(oldExchange==null) {
			Employee emp = new Employee();
			emp.setEmp_name(newBody.getEmp_name());
			emp.setSalary_details(newBody.getSalary_details());
			HashMap<String,Double> hm = new HashMap<String,Double>(emp.getSalary_details());
			Double totalSalary = 0.0;
			for(Map.Entry<String, Double> entry : hm.entrySet()) {
				totalSalary+=entry.getValue();
			}
			newExchange.getIn().setBody(new ArrayList<EmployeeAnnualSalary>(Arrays.asList(new EmployeeAnnualSalary(emp.getEmp_name(), totalSalary))));
			return newExchange;
		}
		List<EmployeeAnnualSalary> oldBody = (List<EmployeeAnnualSalary>) oldExchange.getIn().getBody();
		
		HashMap<String,Double> hm = new HashMap<String,Double>(newBody.getSalary_details());
		Double totalSalary = 0.0;
		for(Map.Entry<String, Double> entry : hm.entrySet()) {
			totalSalary+=entry.getValue();
		}
		oldBody.add(new EmployeeAnnualSalary(newBody.getEmp_name(),totalSalary));
//		System.out.println(oldBody);
		oldExchange.getIn().setBody(oldBody);
		return oldExchange;
	}
}
