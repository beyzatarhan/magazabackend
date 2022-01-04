package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Product;
import com.example.demo.model.Sayim;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeUserDetailsService;
import com.example.demo.services.ProductService;
import com.example.demo.services.SayimService;

@RestController
@RequestMapping("/sayim")
public class SayimController {
	@Autowired
	SayimService sayimService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	EmployeeUserDetailsService employeeService;
	
	@Autowired 
	EmployeeRepository employeeRepository;
		
	@PostMapping("/add")
	public ResponseEntity<Sayim> addSayim(@RequestBody Sayim sayim) {
		Sayim newsayim = sayimService.addSayim(sayim);
		return new ResponseEntity<>(newsayim, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}/product/{barkod}")
    Sayim addProductToSayim(
            @PathVariable int id,
            @PathVariable int barkod
    ) {
        Sayim sayim = sayimService.findSayimById(id);
        Product product = productService.findProductById(barkod);
        sayim.setProduct(product);
        return sayimService.addSayim(sayim);
    }
	
	@PutMapping("/{id}/employee/{employeeId}")
    Sayim assignEmployeeToSayim(
            @PathVariable int id,
            @PathVariable int employeeId
    ) {
        Sayim sayim = sayimService.findSayimById(id);
        Employee employee = employeeRepository.findById(employeeId).get();
        sayim.setEmployee(employee);
        return sayimService.addSayim(sayim);
    }
	
}
