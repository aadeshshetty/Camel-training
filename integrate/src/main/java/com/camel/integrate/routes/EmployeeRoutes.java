package com.camel.integrate.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.camel.integrate.services.EmployeeBindProcessor;

@Component
public class EmployeeRoutes extends RouteBuilder{
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
//		DataFormat bindy = new BindyCsvDataFormat(com.camel.integrate.domain.Employee.class);
		from("file:D:\\employee_source")
	    .convertBodyTo(String.class)
	    .process(new EmployeeBindProcessor())
	    .to("direct:salaryProcess");
//	    .to("file:/path/?fileName=test.txt");
		
//		restConfiguration()
//			.component("servlet")
//			.bindingMode(RestBindingMode.json);
//		rest("/employee")
//			.get("/list")
//			.route()
//			.bean(EmployeeService.class,"get")
//			.to("direct:salaryProcess");
	}

}
