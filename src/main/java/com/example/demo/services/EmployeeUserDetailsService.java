package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeUserDetailsService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee fetchUserByEmailAndPassword(String tempTc, String tempPassword) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmailAndPassword(tempTc, tempPassword);
	}

}
