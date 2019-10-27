package com.product.myretail.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.product.myretail.dto.PriceDTO;
import com.product.myretail.dto.ProductDTO;
import com.product.myretail.service.ProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	ProductService productService;

	@InjectMocks
	private ProductController controller = new ProductController();

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void getProduct() throws Exception {

		ProductDTO productDto = new ProductDTO();
		productDto.setId(1);
		productDto.setProductName("The Big Lebowski (Blu-ray)(Widescreen)");
		PriceDTO priceDto = new PriceDTO();
		priceDto.setCurrency_code("INR");
		priceDto.setValue(100.00);
		productDto.setCurrent_price(priceDto);

		String expectedResponse = "{\"id\":1,\"productName\":\"The Big Lebowski (Blu-ray)(Widescreen)\",\"current_price\":{\"value\":100.0,\"currency_code\":\"INR\"}}";
		Mockito.when(productService.getProductById(Mockito.anyInt())).thenReturn(productDto);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/product/1")
				.contentType(MediaType.APPLICATION_JSON).content(productDto.toString())).andReturn();

		Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

		Assert.assertEquals(expectedResponse, result.getResponse().getContentAsString());

	}

}
