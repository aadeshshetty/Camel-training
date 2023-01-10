package com.camel.CamelJPA.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.camel.CamelJPA.services.EmployeeBindProcess;
import com.camel.CamelJPA.services.NewEmployeeBindProcess;

@Component
public class JpaRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration()
		.component("undertow").host("0.0.0.0").port(9091).bindingMode(RestBindingMode.auto);
		
		//-----------------------------SELECT-----------------------------
		rest().get("employee").route()
		.to("jpa://com.camel.CamelJPA.Employee?namedQuery=findAll");
		
		//-----------------------------INSERT-----------------------------
		rest().post("add")
	      .route().routeId("postemployeeRoute").log("--- binded ${body} ---")
	      .marshal().json(JsonLibrary.Jackson)
	      .process(new EmployeeBindProcess())
	      .to("jpa://com.camel.CamelJPA.Employee");
		
		//-----------------------------UPDATE-----------------------------
		rest().put("edit/{id}")
			.route().log("---${body}---")
			.marshal().json(JsonLibrary.Jackson)
			.process(new NewEmployeeBindProcess())
			.to("jpa://com.camel.CamelJPA.Employee?useExecuteUpdate=true");
		
		//-----------------------------DELETE-----------------------------
		rest().delete("delete/{id}")
		.route()
		.toD("jpa://com.camel.CamelJPA.Employee"
            + "?nativeQuery=DELETE FROM employee where id = ${header.id}&useExecuteUpdate=true");
		
	}
	
}
