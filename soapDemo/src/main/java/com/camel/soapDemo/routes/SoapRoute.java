package com.camel.soapDemo.routes;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.springframework.stereotype.Component;
import org.tempuri.Add;
import org.tempuri.AddResponse;

import com.camel.soapDemo.cxf.Employee;
import com.camel.soapDemo.cxf.EmployeeBindProcessor;
import com.learnwebservices.services.hello.HelloRequest;
import com.learnwebservices.services.hello.HelloResponse;
import com.soapwebservices.springsoap.gen.EmployeeDetails;
import com.soapwebservices.springsoap.gen.GetEmployeeSalaryRequest;
import com.soapwebservices.springsoap.gen.GetEmployeeSalaryResponse;

@Component
public class SoapRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
//		from("file:D:\\employee_source").convertBodyTo(String.class)
//				.process(new EmployeeBindProcessor())
//				.split(body())
				from("direct:calc")
				.removeHeaders("CamelHttp*")
				.removeHeader("Accept-Encoding")
				.process(new Processor() {

					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						int num1 = Integer.parseInt(exchange.getIn().getHeader("num1").toString());
						int num2 = Integer.parseInt(exchange.getIn().getHeader("num2").toString());
						System.out.println(num1+""+num2);
						Add a = new Add();
						a.setIntA(num1);
						a.setIntB(num2);
						exchange.getIn().setBody(a);
						
						
//						Employee emp = exchange.getIn().getBody(Employee.class);
//						Add a = new Add();
//						a.setIntA(42);
//						a.setIntB(48);
//						exchange.getIn().setBody(a);
//						HelloRequest hr = new HelloRequest();
//						hr.setName(emp.getName());
//						exchange.getIn().setBody(hr);
//						GetEmployeeSalaryRequest er = new GetEmployeeSalaryRequest();
//						EmployeeDetails e = new EmployeeDetails();
//						e.setId(emp.getId());
//						e.setName(emp.getName());
//						e.setMonths(emp.getMonths());
//						e.setSalary(emp.getSalary());
//						er.setEmployee(e);
//						exchange.getIn().setBody(er);
					}
				})
				.setHeader(CxfConstants.OPERATION_NAME, constant("{{endpoint.operation.add}}"))
				.setHeader(CxfConstants.OPERATION_NAMESPACE, constant("{{endpoint.namespace}}"))
				.to("cxf:bean:cxfHello")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						MessageContentsList m =((MessageContentsList)exchange.getIn().getBody());
						AddResponse ad = (AddResponse) m.get(0);
						exchange.getIn().setBody("result is "+ad.getAddResult());			
										}
				})
				.log("cxf route-1 ${body}")
				;

	}

}
//.process(new Processor() {
//
//	public void process(Exchange exchange) throws Exception {
//		// TODO Auto-generated method stub
//		MessageContentsList m = (MessageContentsList) exchange.getIn().getBody();
//		HelloResponse hre = (HelloResponse) m.get(0);
////		System.out.println("m is"+ m.get(0));
////		GetEmployeeSalaryResponse ere = (GetEmployeeSalaryResponse) m.get(0);
//		exchange.getIn().setBody(hre.getMessage());
//
//	}
//})
//.to("cxf://http://localhost:8090/ws" + "?serviceClass=com.soapwebservices.springsoap.gen.EmployeePort"
//		+ "&wsdlURL=/wsdl/employees.wsdl")
//.bean(new GetEmployeeSalaryResponse())
//.to("cxf://http://www.dneonline.com/calculator.asmxL" + "?serviceClass=org.tempuri.CalculatorSoap"
//		+ "&wsdlURL=/wsdl/calculator.wsdl")