package com.spring.sedaDemo.routes;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.spring.sedaDemo.services.Employee;
import com.spring.sedaDemo.services.EmployeeBindProcessor;

@Component
public class SedaRoutes extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:D:\\employee_source").convertBodyTo(String.class)
		.process(new EmployeeBindProcessor())
		.to("seda:salaryProcess")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				// TODO Auto-generated method stub
				Employee[] el= exchange.getIn().getBody(Employee[].class);
				for(int i=0; i<el.length;i++) {
					System.out.println(timestamp+ " Hello" + el[i].getName());
				}
			}
		});
		
		
		from("seda:salaryProcess")
		.process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				Employee[] el= exchange.getIn().getBody(Employee[].class);
				for(int i=0; i<el.length;i++) {
					System.out.println(timestamp+" Annual Salary : "+ el[i].getMonths()*el[i].getSalary());
				}
			}
		});
	}

}
