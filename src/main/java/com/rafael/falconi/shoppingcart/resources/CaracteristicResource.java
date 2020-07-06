package com.rafael.falconi.shoppingcart.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.falconi.shoppingcart.controllers.CaracteristicController;
import com.rafael.falconi.shoppingcart.dtos.CaracteristicDto;
import com.rafael.falconi.shoppingcart.resources.exeptions.CaracteristicCreateError;
import com.rafael.falconi.shoppingcart.resources.exeptions.ProductDontFound;

@RestController
@RequestMapping(CaracteristicResource.CARACTERISTIC)
public class CaracteristicResource {

	public static final String CARACTERISTIC = "/caracteristics";

	@Autowired
	private CaracteristicController caracteristicCrontoller;

	@PostMapping
	public void createCaracteristic(@Valid @RequestBody CaracteristicDto caracteristicDto)
			throws CaracteristicCreateError, ProductDontFound {
		if (this.caracteristicCrontoller.createCaracteristic(caracteristicDto) == "product")
			throw new ProductDontFound();
	}

}
