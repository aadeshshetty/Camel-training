package com.camel.activeMQDemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Activemq_Sender extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:test?period=10000")
		.setBody(simple("This is first message to Queue"))
		.to("activemq:example_queue");
	}

}
