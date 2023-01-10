package com.camel.integrate.routes;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.integrate.dao.SalaryAggregation;
import com.camel.integrate.domain.EmployeeAnnualSalary;

@Component
public class SalaryRoutes extends RouteBuilder {

	@Autowired
	private SalaryAggregation salaryAggregation;

	@Override
	public void configure() throws Exception {

		// TODO Auto-generated method stub
		from("direct:salaryProcess").split(body(), salaryAggregation).log("splitting").end().process(new Processor() {
			public void process(Exchange exchange) throws Exception {

				List<EmployeeAnnualSalary> res = (List<EmployeeAnnualSalary>) exchange.getIn().getBody();
				for (int i = 0; i < res.size(); i++) {
					System.out.println(res.get(i).getEmp_name() + "-" + res.get(i).getSalary());
				}
			}
		}).marshal().json(JsonLibrary.Jackson)
				.to("file:D://employee_dest?filename=emploee_annualSalary.json");
	}

}
