package com.rafael.falconi.shoppingcart.resources;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rafael.falconi.shoppingcart.dtos.ProductDto;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductResourceTest {

	@Rule
	public ExpectedException thrown= ExpectedException.none();
	
	@Autowired
	private RestService restService;
	private ProductDto productDto;
	
	@Before
	public void before() {
		this.productDto= new ProductDto(2, 5, "backpac", "wallet made from lether", 5.50);
	}
	
	@Test
	public void createProductTest() {
		restService.restBuilder().path(ProductResource.PRODUCT).body(productDto).post().build();
	}
	
	
	
}
