package com.camel.soapDemo.cxf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBindProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		String body = exchange.getIn().getBody(String.class);
		String[] data = body.split(";");
		for(int i=1;i<data.length;i++) {
			Employee e = new Employee();
			String[] d = data[i].trim().split(",");
			e.setId(Integer.parseInt(d[0]));
			e.setName(d[1]);
			e.setMonths(Integer.parseInt(d[2]));
			e.setSalary(Double.parseDouble(d[3]));
//			HashMap<String, Double> hm = new HashMap<String, Double>();
//			String[] map = data[i].split(",");
//			e.setEmp_name(map[0]);
//			hm.put("jan", Double.parseDouble(map[1]));
//			hm.put("feb", Double.parseDouble(map[2]));
//			hm.put("march", Double.parseDouble(map[3]));
//			hm.put("april", Double.parseDouble(map[4]));
//			hm.put("may", Double.parseDouble(map[5]));
//			hm.put("june", Double.parseDouble(map[6]));
//			hm.put("july", Double.parseDouble(map[7]));
//			hm.put("aug", Double.parseDouble(map[8]));
//			hm.put("sept", Double.parseDouble(map[9]));
//			hm.put("oct", Double.parseDouble(map[10]));
//			hm.put("nov", Double.parseDouble(map[11]));
//			hm.put("dec", Double.parseDouble(map[12]));
//			e.setSalary_details(hm);
			employeeList.add(e);
		}
		exchange.getIn().setBody(employeeList);
	}

}
