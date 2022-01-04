package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeUserDetailsService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	 @Autowired
	 EmployeeUserDetailsService employeeService;
	 
	 @PostMapping("/login")
	 @CrossOrigin(origins = "http://localhost:4200")
	 public Employee loginEmployee(@RequestBody Employee employee) {
		 String tempTc = employee.getTc();
		 String tempPassword = employee.getPassword();
		 Employee employeeObj =  null;
		 if(tempTc != null && tempPassword != null) {
			 employeeObj = employeeService.fetchUserByEmailAndPassword(tempTc, tempPassword);
		 }
		 
		 return employeeObj;
	 }
}
