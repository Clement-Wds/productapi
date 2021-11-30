package com.ynovb3.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynovb3.productapi.model.Category;
import com.ynovb3.productapi.repository.CategoryRepository;
import com.ynovb3.productapi.transformer.category.CategoryFull;
import com.ynovb3.productapi.transformer.category.CategoryTransformer;

@Service
public class CategoryService {

	@Autowired
	private CategoryTransformer categoryTransformer;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<CategoryFull> getCategories() {
		return categoryTransformer.transform(categoryRepository.findAll());
	}
	
}
