package com.ynovb3.productapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynovb3.productapi.model.Product;
import com.ynovb3.productapi.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product upsert(Product product) {
		if(product.getName().length() < 8) {
			return null;
		}
		return productRepository.save(product);
	}
	
	public Optional<Product> getProduct(Integer id) {
		return productRepository.findById(id);
	}
	
	public Iterable<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
}
