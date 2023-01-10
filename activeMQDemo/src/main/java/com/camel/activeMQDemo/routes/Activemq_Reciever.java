package com.camel.activeMQDemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Activemq_Reciever extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("activemq:example_queue")
		.log("${body}");
	}

}
