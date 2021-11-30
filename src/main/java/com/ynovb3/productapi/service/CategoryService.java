package com.ynovb3.productapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynovb3.productapi.model.Category;
import com.ynovb3.productapi.repository.CategoryRepository;
import com.ynovb3.productapi.transformer.CategoryFull;
import com.ynovb3.productapi.transformer.CategoryTransformer;


@Service
public class CategoryService {

	//Injection du repository
	@Autowired
	private CategoryRepository categoryRepository;
	
	//get All
	public List<CategoryFull> getCategories() {
		Iterable<Category> categories = categoryRepository.findAll();
		CategoryTransformer transformer = new CategoryTransformer();
		return transformer.transform(categories);
	}

	//Get By ID
	public Optional<Category> getCategory(Integer id){
		return categoryRepository.findById(id);
	}
	
}
