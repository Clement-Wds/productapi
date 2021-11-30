package com.ynovb3.productapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ynovb3.productapi.model.Category;
import com.ynovb3.productapi.service.CategoryService;
import com.ynovb3.productapi.transformer.CategoryFull;

@RestController
public class CategoryController {

	//Injection du service
	@Autowired
	private CategoryService categoryService;
	
	//Get all categories
	@GetMapping("/categories")
	public List<CategoryFull> getCategories() {
		return categoryService.getCategories();
	}
	
	//get category by id or return 404 if category not exist
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
		Optional<Category> c = categoryService.getCategory(id);
		if(c.isPresent()) {
			return new ResponseEntity<Category>(c.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	}
	
	
}
