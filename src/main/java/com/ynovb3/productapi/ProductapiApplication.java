package com.ynovb3.productapi;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ynovb3.productapi.model.Category;
import com.ynovb3.productapi.repository.CategoryRepository;

@SpringBootApplication
public class ProductapiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductapiApplication.class, args);
	}
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Optional<Category> optCategory = categoryRepository.findById(1);
		Category categoryId1 = optCategory.get();
		
		System.out.println(categoryId1.getName());
		
		categoryId1.getProducts().forEach(
				product -> System.out.println(product.getName())
				);
	}

}
