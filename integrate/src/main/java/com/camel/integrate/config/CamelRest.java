package com.camel.integrate.config;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class CamelRest extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);
		rest()
//		.get("/work").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("working!!!!"));
        .get("/hello").to("direct:hello")
        .get("/bye").consumes("application/json").to("direct:bye");
		from("direct:hello")
        .transform().constant("Hello World")
        .log("Body is ${body}");

    from("direct:bye")
        .transform().constant("Bye World");
	}

}
