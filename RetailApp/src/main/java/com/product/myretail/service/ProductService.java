package com.product.myretail.service;

import java.util.List;

import java.util.Optional;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.product.myretail.dto.ProductDTO;
import com.product.myretail.entity.Product;
import com.product.myretail.exception.RetailAppGenericException;
import com.product.myretail.repository.ProductRepository;
import com.product.myretail.utility.Utility;

@Component
public class ProductService implements IProductService{

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	ProductRepository productRepository;
	
	private static final Logger logger = LogManager.getLogger(ProductService.class);

	/**
	 * This method is used to parse the product details JSON from external API and
	 * fetch the name object alone.
	 * 
	 * @param id:
	 *            Product ID
	 * @return response json with updated product details
	 */
	public String getProductName() {
		/*
		 * Mocked the url [ used in case of no internet ] returns product related
		 * details.
		 */
		 // String url = "http://localhost:8082/productname";
		 String url =
		 "https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

		String resultJson = restTemplate.getForObject(url, String.class);
		JSONObject resultObj;
		String productName = null;
		try {
			resultObj = new JSONObject(resultJson);
			JSONObject productObj = (JSONObject) resultObj.get("product");
			JSONObject itemObj = (JSONObject) productObj.get("item");
			JSONObject descObj = (JSONObject) itemObj.get("product_description");
			productName = (String) descObj.get("title");
		} catch (Exception e) {
			logger.error("Error while fetching product name...");
			throw new RetailAppGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

		return productName;
	}

	public List<ProductDTO> getAllProducts() {
		logger.info("Inside List all products method...");
		Iterable<Product> result = productRepository.findAll();
		return Utility.setListToDto(result);
	}

	public ProductDTO getProductById(int id) {
		logger.info("Inside get product method by id...");
		Optional<Product> product = productRepository.findById(id);
		if (!product.isPresent())
			throw new RetailAppGenericException(HttpStatus.NOT_FOUND, "Product not found for the given id " + id);
		// Set Product name by parsing the json output from redsky api
		String productName = getProductName();
		product.get().setProductName(productName);
		ProductDTO productDto = Utility.setToDto(product.get());
		return productDto;

	}

	/**
	 * Metod to update product currency related values.
	 * 
	 * @param id
	 * @param newProduct
	 * @return ProductDTO
	 */
	public ProductDTO updateProductData(int id, Product newProduct) {
		Product product = null;
		logger.info("Inside update product method by id...");
		try {
			Optional<Product> getProduct = productRepository.findById(id);
			if (!getProduct.isPresent())
				throw new RetailAppGenericException(HttpStatus.NOT_FOUND,
						"Failed to update... Product not found for the given id " + id);
			product = getProduct.get();
			// Set if values passed.
			if (!StringUtils.isEmpty(newProduct.getCurrencyValue()))
				product.setCurrencyValue(newProduct.getCurrencyValue());
			if (!StringUtils.isEmpty(newProduct.getCurrencyCode()))
				product.setCurrencyCode(newProduct.getCurrencyCode());
			product.setProductName(getProduct.get().getProductName());
			product.setId(getProduct.get().getId());
			// Save product with updated values.
			productRepository.save(product);

		} catch (Exception e) {
			logger.error("Error while updating product...");
			throw new RetailAppGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return Utility.setToDto(product);

	}

	public ProductDTO saveProduct(Product product) {
		logger.info("Inside save product method...");
		// Generate id
		Random objGenerator = new Random();
		int id = objGenerator.nextInt(99999999);
		Product saveProduct = new Product(id, product.getProductName(), product.getCurrencyValue(),
				product.getCurrencyCode());
		productRepository.save(saveProduct);
		ProductDTO productDto = Utility.setToDto(saveProduct);
		return productDto;

	}

	public String deleteById(int id) {
		logger.info("Inside delete product method by id...");
		boolean result = productRepository.existsById(id);
		try {
			if (result) {
				productRepository.deleteById(id);
				return "{ \"success\" :  \"Successfully deleted \"  }";
			} else {
				return "{ \"Failure\" :  \"Id not found \"  }";
			}
		} catch (Exception e) {
			logger.error("Error while deleteing product...");
			throw new RetailAppGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
