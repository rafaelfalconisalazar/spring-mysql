package com.rafael.falconi.shoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rafael.falconi.shoppingcart.dtos.ProductDto;
import com.rafael.falconi.shoppingcart.entities.Product;
import com.rafael.falconi.shoppingcart.repositories.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(ProductDto productDto) {
		Product product = new Product(productDto.getId(), productDto.getStock(), productDto.getName(), productDto.getDescription(), productDto.getPrice());
		this.productRepository.save(product);		
	}
	

}
