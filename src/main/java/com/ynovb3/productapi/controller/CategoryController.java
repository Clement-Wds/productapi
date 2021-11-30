package com.ynovb3.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynovb3.productapi.service.CategoryService;
import com.ynovb3.productapi.transformer.category.CategoryFull;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public List<CategoryFull> getCategories() {
		return categoryService.getCategories();
	}
	
}
