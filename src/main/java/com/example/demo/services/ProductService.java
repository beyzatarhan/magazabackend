package com.example.demo.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	public Product findProductById(int barkod) {
        return productRepository.findProductByBarkod(barkod)
                .orElseThrow(() -> new ProductNotFoundException("Product by barkod " + barkod + " was not found"));
    }
	public void deleteProduct(int barkod) {
		productRepository.deleteProductByBarkod(barkod);
	}

}
