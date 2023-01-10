package com.camel.integrate.dao;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.camel.integrate.domain.Employee;

public class EmployeeService{
	static List<Employee> employeeList =new ArrayList<Employee>();
//	static {
//		HashMap<String,Double> hm = new HashMap<String,Double>();
//		hm.put("jan", 10000.00);
//		hm.put("feb", 12000.00);
//		hm.put("march", 13000.00);
//		employeeList.add(new Employee("A", hm));
//		employeeList.add(new Employee("B", hm));
//	}
	public List<Employee> get() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("D:\\employee_source\\emp.csv"));
	    String line =  null;
	    int f=0;
        String[] mon = new String[12];
	    while((line=br.readLine())!=null){
	    	HashMap<String,Double> map = new HashMap<String, Double>();
		    map.put("jan",0.0);
		    map.put("feb",0.0);
		    map.put("march",0.0);
		    map.put("april",0.0);
		    map.put("may",0.0);
		    map.put("june",0.0);
		    map.put("july",0.0);
		    map.put("aug",0.0);
		    map.put("sept",0.0);
		    map.put("oct",0.0);
		    map.put("nov",0.0);
		    map.put("dec",0.0);
	        String str[] = line.split(",");
	        for(int i=1;i<str.length;i++){
	        	if(f==0) {
	        		mon[i-1]=str[i].split("/")[1];
	        	}
	        	else {
	            map.put(mon[i-1], Double.parseDouble(str[i]));
	        	}
	        }
	        if(f==0) {
	        	f+=1;
	        	continue;
	        }
	        f+=1;
	       employeeList.add(new Employee(str[0],map)); 
	    }
	    br.close();
		return employeeList;
	}
}
