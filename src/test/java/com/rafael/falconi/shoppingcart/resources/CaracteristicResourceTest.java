package com.rafael.falconi.shoppingcart.resources;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rafael.falconi.shoppingcart.dtos.CaracteristicDto;
import com.rafael.falconi.shoppingcart.dtos.ProductDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CaracteristicResourceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private RestService restService;
	private ProductDto productDto;
	private CaracteristicDto caracteristicDto;

	@Before
	public void Before() {
		this.productDto = new ProductDto(1, 5, "backpac", "wallet made from lether", 5.50);
		this.caracteristicDto = new CaracteristicDto(1, "color", this.productDto);

	}

	@Test
	public void createCaracteristic() {
		restService.restBuilder().path(CaracteristicResource.CARACTERISTIC).body(caracteristicDto).post().build();
	}

	@Test
	public void readAllCaracteristicsTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CaracteristicResource.CARACTERISTIC).get().build();

		System.out.println("-->" + json);
	}

	@Test
	public void readCaracteristicByIdTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CaracteristicResource.CARACTERISTIC).path(CaracteristicResource.ID).expand(1).get().build();

		System.out.println("-->" + json);
	}

	@Test
	public void editCaracteristicTest() {
		this.caracteristicDto.setDescription("material");
		this.productDto.setId(15);
		restService.restBuilder().path(CaracteristicResource.CARACTERISTIC)
		.path(CaracteristicResource.ID).expand(1).body(caracteristicDto).put().build();

		
	}

}
