package com.ynovb3.productapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynovb3.productapi.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Iterable<Product> findByName(String name);
	
}
