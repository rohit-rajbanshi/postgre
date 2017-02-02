package com.gslab.dth;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.dth.data.Employee;
import com.gslab.dth.data.EmployeeDao;

@RestController
public class EmployeeRESTfulService {

	@Autowired
	EmployeeDao dao;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	private String test(HttpServletResponse response) {
		System.out.println("test called");
		return "test called";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	private Employee[] getEmployee(HttpServletResponse response) {
		System.out.println("find all emp");
		ArrayList<Employee> datalist = (ArrayList<Employee>) dao.findAll();
		Employee[] dataset = datalist.toArray(new Employee[datalist.size()]);
		System.out.println("all employees :" + datalist.size());
		for(int i=0;i<dataset.length;i++){
			dataset[i].setAddress((dataset[i].getAddress().trim()));
		}
		return dataset;
	}

}
