package com.ynovb3.productapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ynovb3.productapi.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
