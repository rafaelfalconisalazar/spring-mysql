package com.rafael.falconi.shoppingcart.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.falconi.shoppingcart.controllers.ProductController;
import com.rafael.falconi.shoppingcart.dtos.ProductDto;
import com.rafael.falconi.shoppingcart.resources.exeptions.ProductCreateError;
import com.rafael.falconi.shoppingcart.resources.exeptions.ProductDontFound;
@RestController
@RequestMapping(ProductResource.PRODUCT)
public class ProductResource {
	
	public static final String PRODUCT = "/products";
	public static final String ID= "/{id}";
	
	@Autowired
	private ProductController productController;
	
	@PostMapping
	public void createProduct(@Valid @RequestBody ProductDto productDto )throws ProductCreateError {
		this.productController.createProduct(productDto);
		
	}
	
	@GetMapping
	public List<ProductDto> readAllProducts(){
		return this.productController.readAllProducts();
	}
	
	@GetMapping(value = ID)
	public ProductDto readProductById(@PathVariable int id) throws ProductDontFound{
		return this.productController.findProductById(id).orElseThrow(()-> new ProductDontFound());
	}
	
	@PutMapping(value=ID)
	public void editProduct(@PathVariable int id, @Valid @RequestBody ProductDto productDto ) throws ProductDontFound{
		if(!this.productController.editProduct(id, productDto)) throw new ProductDontFound();
	}
	

}
