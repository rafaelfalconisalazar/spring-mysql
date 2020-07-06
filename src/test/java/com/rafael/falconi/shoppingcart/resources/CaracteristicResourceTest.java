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
	public ExpectedException thrown= ExpectedException.none();
	
	@Autowired
	private RestService restService;
	private ProductDto productDto;
	private CaracteristicDto caracteristicDto;
	
	@Before 
	public void Before() {
		this.productDto= new ProductDto(1, 5, "backpac", "wallet made from lether", 5.50);
		this.caracteristicDto= new CaracteristicDto(1, "color", this.productDto);
		
	}
	
	@Test
	public void test() {
		restService.restBuilder().path(CaracteristicResource.CARACTERISTIC).body(caracteristicDto).post().build();
	}

}
