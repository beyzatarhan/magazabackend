package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Sayim;
import com.example.demo.repository.SayimRepository;
@Service
public class SayimService {
	
	@Autowired
	private SayimRepository sayimRepository;

	public SayimService(SayimRepository sayimRepository) {
		this.sayimRepository = sayimRepository;
	}
	
	public List<Sayim> listSayim(Employee employee){
		return sayimRepository.findByEmployee(employee);
	}
	
	public Sayim addSayim(Sayim sayim) {
		return sayimRepository.save(sayim);
	}
	public Sayim findSayimById(int id) {
        return sayimRepository.findSayimById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product by barkod " + id + " was not found"));
    }
	
}
