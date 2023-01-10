package com.camel.CamelJPA.services;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.camel.CamelJPA.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NewEmployeeBindProcess implements Processor {

	public void process(Exchange exchange) throws Exception {
		Integer id = Integer.valueOf(exchange.getIn().getHeader("id").toString());
		ObjectMapper ob = new ObjectMapper();
		Employee emp = ob.readValue(exchange.getIn().getBody(String.class), Employee.class);
		emp.setId(id);
		exchange.getIn().setBody(emp);

	}

}
