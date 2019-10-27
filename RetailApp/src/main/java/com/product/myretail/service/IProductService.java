package com.product.myretail.service;

import java.util.List;

import com.product.myretail.dto.ProductDTO;
import com.product.myretail.entity.Product;

public interface IProductService {

	String getProductName();

	List<ProductDTO> getAllProducts();

	ProductDTO getProductById(int id);

	ProductDTO updateProductData(int id, Product newProduct);

	ProductDTO saveProduct(Product product);

	String deleteById(int id);
	
}
