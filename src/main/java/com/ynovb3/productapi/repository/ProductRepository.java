package com.ynovb3.productapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ynovb3.productapi.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	//Derived query (requête dérivée)
	public Iterable<Product> findByName(String name);
	
	//Native query
	@Query(value = "SELECT * FROM products WHERE name = :name", nativeQuery = true)
	public Iterable<Product> findByNameNative(@Param("name") String name);
	
}
