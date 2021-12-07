package com.ynovb3.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynovb3.productapi.model.Category;
import com.ynovb3.productapi.model.Product;
import com.ynovb3.productapi.service.CategoryService;
import com.ynovb3.productapi.service.ProductService;
import com.ynovb3.productapi.transformer.category.CategoryFull;

@RestController
@RequestMapping("/api/private")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/categories")
	public List<CategoryFull> getCategories() {
		return categoryService.getCategories();
	}
	
	@PostMapping("/category/{idCategory}/{idProduct}")
	public void addProductToCategory(
			@PathVariable(name = "idCategory") Integer idCategory,
			@PathVariable(name = "idProduct") Integer idProduct) {

		Category category = categoryService.getCategory(idCategory).get();
		Product product = productService.getProduct(idProduct).get();

		category.addProduct(product);

		categoryService.saveCategory(category);

	}
}
