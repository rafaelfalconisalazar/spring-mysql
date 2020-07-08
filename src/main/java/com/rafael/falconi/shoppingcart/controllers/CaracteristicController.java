package com.rafael.falconi.shoppingcart.controllers;

import java.util.ArrayList;
import java.util.List;
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

	public Optional<Caracteristic> getCaracteristicById(int id) {
		Optional<Caracteristic> caOptional = this.caracteristicRepository.findById(id);
		return caOptional;
	}

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

	public List<CaracteristicDto> readAllCaracteristics() {
		List<Caracteristic> caracteristicList = this.caracteristicRepository.findAll();
		List<CaracteristicDto> caracteristicListDto = new ArrayList<CaracteristicDto>();
		for (Caracteristic caracteristic : caracteristicList) {
			caracteristicListDto.add(new CaracteristicDto(caracteristic));

		}
		return caracteristicListDto;
	}

	public Optional<CaracteristicDto> findCaractaristicById(int id) {
		Optional<Caracteristic> caOptional = this.getCaracteristicById(id);
		if (caOptional.isPresent()) {
			return Optional.of(new CaracteristicDto(caOptional.get()));
		} else {
			return Optional.empty();
		}
	}

	public boolean editCaracteristic(int id, CaracteristicDto caracteristicDto) {
		Optional<Caracteristic> caOptional = this.getCaracteristicById(id);
		if (!caOptional.isPresent())
			return false;
		Optional<Product> productOptional = this.productController
				.getProductById(caracteristicDto.getProduct().getId());
		if (!productOptional.isPresent())
			return false;
		Caracteristic caracteristic= caOptional.get();
		caracteristic.setDescription(caracteristicDto.getDescription());
		caracteristic.setProduct(productOptional.get());
		this.caracteristicRepository.save(caracteristic);
		return true;
		
	}

}
