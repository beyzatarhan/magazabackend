package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.services.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private final ProductService productService;
	
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	//get all products
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
	    List<Product> products = productService.findAllProducts();
	    return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	//create product
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newproduct = productService.addProduct(product);
		return new ResponseEntity<>(newproduct, HttpStatus.CREATED);
	}
	
	 @DeleteMapping("/delete/{barkod}")
	    public ResponseEntity<?> deleteProduct(@PathVariable("barkod") int barkod) {
		 productService.deleteProduct(barkod);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	
}

