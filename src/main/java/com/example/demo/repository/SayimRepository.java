package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Sayim;

@Repository
public interface SayimRepository extends JpaRepository<Sayim, Integer>{

	Optional<Sayim> findSayimById(int id);

	List<Sayim> findByEmployee(Employee employee);

}
