package com.ynovb3.productapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynovb3.productapi.model.Product;
import com.ynovb3.productapi.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public Iterable<Product> getProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Optional<Product> p = productRepository.findById(id);
		if(p.isPresent()) {
			return new ResponseEntity<Product>(p.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);//Return 404
	}
	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		productRepository.deleteById(id);
	}
	
	@PutMapping("/product")
	public Product replaceProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

}
