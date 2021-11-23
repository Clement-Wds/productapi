package com.ynovb3.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynovb3.productapi.model.Comment;
import com.ynovb3.productapi.model.Product;
import com.ynovb3.productapi.service.ProductService;

@RestController
public class CommentController {
	
	@Autowired
	private ProductService productService;
			
	@PostMapping("/comment/{product_id}")
	public Product addComment(@RequestBody Comment comment, @PathVariable Integer product_id) {

		Product existingProduct = productService.getProduct(product_id).get();

		existingProduct.getComments().add(comment);
		
		return productService.upsert(existingProduct);
		
	}
	
}
