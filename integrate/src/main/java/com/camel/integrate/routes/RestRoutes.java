package com.camel.integrate.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.integrate.dao.StudentDAO;
import com.camel.integrate.domain.Student;

@Component
public class RestRoutes extends RouteBuilder{
	@Autowired
	private StudentDAO studentDao;
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration()
	       .component("servlet")
	       .bindingMode(RestBindingMode.json);
		rest("/app")
		.get("/student/list")
//		.produces("json")
		.route()
		.bean(studentDao, "list");
		
		rest("/app")
		.post("/student/save")
		.consumes("application/json")
		.bindingMode(RestBindingMode.json)
		.type(Student.class)
		.route()
		.bean(studentDao,"save");
		
		rest("/app")
		.delete("/student/delete/{id}")
		.route()
		.bean(studentDao,"delete(${header.id})");
	}
}
