package com.spring.kafkademo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.stereotype.Component;

@Component
public class exampleroutes extends RouteBuilder {
	final String KAFKA_ENDPOINT = "kafka:%s?brokers=localhost:9092"; 
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		fromF(KAFKA_ENDPOINT,"names-topic")
		.bean(NamesEdit.class)
		.log("offset is ${header.kafka.OFFSET} and body is ${body}")
		.toF(KAFKA_ENDPOINT, "users-topic");
		
		fromF(KAFKA_ENDPOINT,"users-topic")
		.log("body is ${body}");
//		from("file:D:\\inbox?noop=true").setHeader(KafkaConstants.KEY, constant("Camel"))
//				.to("kafka:example-topics?brokers=localhost:9092");
//
//		from("kafka:example-topics?brokers=localhost:9092").log("Message received from Kafka : ${body}")
//				.log("    on the topic ${headers[kafka.TOPIC]}").log("    on the partition ${headers[kafka.PARTITION]}")
//				.log("    with the offset ${headers[kafka.OFFSET]}").log("    with the key ${headers[kafka.KEY]}");
	}
	
	private class NamesEdit{
		public String edit(String s) {
			return s+" User";
		}
	}

}
