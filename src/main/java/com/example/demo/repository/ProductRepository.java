package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	void deleteProductByBarkod(int barkod);

	Optional<Product> findProductByBarkod(int barkod);
}