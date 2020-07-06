package com.rafael.falconi.shoppingcart.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rafael.falconi.shoppingcart.dtos.CaracteristicDto;
import com.rafael.falconi.shoppingcart.entities.Caracteristic;
import com.rafael.falconi.shoppingcart.entities.Product;
import com.rafael.falconi.shoppingcart.repositories.CaracteristicRepository;

@Controller
public class CaracteristicController {

	@Autowired
	private CaracteristicRepository caracteristicRepository;
	@Autowired
	private ProductController productController;

	public String createCaracteristic(CaracteristicDto caracteristicDto) {
		Optional<Product> productOptional = this.productController
				.getProductById(caracteristicDto.getProduct().getId());
		if (!productOptional.isPresent())
			return "product";
		Product product = productOptional.get();
		Caracteristic caracteristic = new Caracteristic(caracteristicDto.getId(), caracteristicDto.getDescription(),
				product);
		this.caracteristicRepository.save(caracteristic);
		return "created";
	}

}
