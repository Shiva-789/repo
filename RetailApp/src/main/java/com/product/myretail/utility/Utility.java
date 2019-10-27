package com.product.myretail.utility;

import java.util.ArrayList;

import java.util.List;

import com.product.myretail.dto.PriceDTO;
import com.product.myretail.dto.ProductDTO;
import com.product.myretail.entity.Product;

public class Utility {

	public static ProductDTO setToDto(Product product) {
		ProductDTO productDto = new ProductDTO();
		PriceDTO priceDto = new PriceDTO();
		productDto.setId(product.getId());
		productDto.setProductName(product.getProductName());
		priceDto.setValue(product.getCurrencyValue());
		priceDto.setCurrency_code(product.getCurrencyCode());
		productDto.setCurrent_price(priceDto);
		return productDto;
	}

	public static List<ProductDTO> setListToDto(Iterable<Product> result) {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		for (Product product : result) {
			productList.add(setToDto(product));
		}
		return productList;
	}

}
