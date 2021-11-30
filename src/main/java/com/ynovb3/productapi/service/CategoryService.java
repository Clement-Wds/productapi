package com.ynovb3.productapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynovb3.productapi.model.Category;
import com.ynovb3.productapi.repository.CategoryRepository;

@Service
public class CategoryService {

	//Injection du repository
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Get ALL
	public Iterable<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
	//Get By ID
	public Optional<Category> getCategory(Integer id){
		return categoryRepository.findById(id);
	}
	
	public Category upsert(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}
}
