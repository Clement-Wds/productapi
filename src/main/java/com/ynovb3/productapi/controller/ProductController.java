package com.ynovb3.productapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynovb3.productapi.model.Product;
import com.ynovb3.productapi.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public Iterable<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Optional<Product> p = productService.getProduct(id);
		if(p.isPresent()) {
			return new ResponseEntity<Product>(p.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);//Return 404
	}
	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product product) {
		productService.upsert(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
	}
	
	@PutMapping("/product")
	public Product replaceProduct(@RequestBody Product product) {
		return productService.upsert(product);
	}
	
	@PatchMapping("/product")
	public ResponseEntity<Product> partialReplaceProduct(@RequestBody Product product) {
		
		Optional<Product> p = productService.getProduct(product.getId()); 
		
		if(p.isPresent()) {
			Product existingProduct = p.get();
			
			if(product.getName() != null && product.getName().equals(existingProduct.getName())) {
				existingProduct.setName(product.getName());
			}
			
			if(product.getDescription() != null && product.getDescription().equals(existingProduct.getDescription())) {
				existingProduct.setDescription(product.getDescription());
			}
			
			if(product.getCost() != null && product.getCost().equals(existingProduct.getCost())) {
				existingProduct.setCost(product.getCost());
			}
			
			return new ResponseEntity<Product>(existingProduct, HttpStatus.OK);
		}
		
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}

}
