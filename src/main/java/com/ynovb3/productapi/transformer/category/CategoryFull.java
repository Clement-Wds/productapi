package com.ynovb3.productapi.transformer.category;

import java.util.ArrayList;
import java.util.List;

import com.ynovb3.productapi.transformer.product.ProductLight;

public class CategoryFull extends CategoryLight {
	
	private List<ProductLight> products = new ArrayList<>();
	
	public List<ProductLight> getProducts() {
		return products;
	}
	public void setProducts(List<ProductLight> products) {
		this.products = products;
	}
}
