package com.rafael.falconi.shoppingcart.dtos;

import com.rafael.falconi.shoppingcart.entities.Caracteristic;

public class CaracteristicDto {

	private int id;

	private String description;

	private ProductDto product;

	public CaracteristicDto(int id, String description, ProductDto product) {
		super();
		this.id = id;
		this.description = description;
		this.product = product;
	}

	public CaracteristicDto(Caracteristic caracteristic) {
		this.id = caracteristic.getId();
		this.description = caracteristic.getDescription();
		this.product = new ProductDto(caracteristic.getProduct());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}
	
	

}
