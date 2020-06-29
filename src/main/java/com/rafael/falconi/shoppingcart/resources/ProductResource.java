package com.rafael.falconi.shoppingcart.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.falconi.shoppingcart.controllers.ProductController;
import com.rafael.falconi.shoppingcart.dtos.ProductDto;
import com.rafael.falconi.shoppingcart.resources.exeptions.ProductCreateError;
@RestController
@RequestMapping(ProductResource.PRODUCT)
public class ProductResource {
	
	public static final String PRODUCT = "/products";
	
	@Autowired
	private ProductController productController;
	
	@PostMapping
	public void createProduct(@Valid @RequestBody ProductDto productDto )throws ProductCreateError {
		this.productController.createProduct(productDto);
		
	}

}
