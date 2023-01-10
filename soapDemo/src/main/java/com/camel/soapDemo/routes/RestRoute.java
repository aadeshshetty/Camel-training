package com.camel.soapDemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration().component("undertow").port(8085).bindingMode(RestBindingMode.auto).dataFormatProperty("prettyPrint", "true").enableCORS(true);;
		rest("/calc")
		.get("/add/{num1}/{num2}")
		.param().name("num1").type(RestParamType.path).dataType("int")
		.name("num2").type(RestParamType.path).dataType("int")
		.endParam()
		.to("direct:calc");
	}

}
