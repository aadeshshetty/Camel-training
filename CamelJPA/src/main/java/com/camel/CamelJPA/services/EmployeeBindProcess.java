package com.camel.CamelJPA.services;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.camel.CamelJPA.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeBindProcess implements Processor{

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper ob = new ObjectMapper();
		
		Employee emp = ob.readValue(exchange.getIn().getBody(String.class),Employee.class);
		exchange.getIn().setBody(emp);
	}

}
