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

import com.rafael.falconi.shoppingcart.controllers.CaracteristicController;
import com.rafael.falconi.shoppingcart.dtos.CaracteristicDto;
import com.rafael.falconi.shoppingcart.resources.exeptions.CaracteristicCreateError;
import com.rafael.falconi.shoppingcart.resources.exeptions.CaracteristicDontFound;
import com.rafael.falconi.shoppingcart.resources.exeptions.ProductDontFound;

@RestController
@RequestMapping(CaracteristicResource.CARACTERISTIC)
public class CaracteristicResource {

	public static final String CARACTERISTIC = "/caracteristics";
	public static final String ID="/{id}";

	@Autowired
	private CaracteristicController caracteristicCrontoller;

	@PostMapping
	public void createCaracteristic(@Valid @RequestBody CaracteristicDto caracteristicDto)
			throws CaracteristicCreateError, ProductDontFound {
		if (this.caracteristicCrontoller.createCaracteristic(caracteristicDto) == "product")
			throw new ProductDontFound();
	}
	
	@GetMapping
	public List<CaracteristicDto> readAllCaracteristics(){
		return this.caracteristicCrontoller.readAllCaracteristics();
	}
	
	@GetMapping(value = ID)
	public CaracteristicDto readCaracteristicById(@PathVariable int id) throws CaracteristicDontFound{
		return this.caracteristicCrontoller.findCaractaristicById(id).orElseThrow(()-> new CaracteristicDontFound());
	}
	
	@PutMapping(value = ID)
	public void editCaracteristic(@PathVariable int id, @Valid @RequestBody CaracteristicDto caracteristicDto) throws CaracteristicDontFound{
		if(! this.caracteristicCrontoller.editCaracteristic(id, caracteristicDto)) throw new CaracteristicDontFound();
	}
	

}
