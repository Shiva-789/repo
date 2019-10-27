package com.product.myretail.web;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.product.myretail.dto.ProductDTO;
import com.product.myretail.entity.Product;
import com.product.myretail.repository.ProductRepository;
import com.product.myretail.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;
	
	 private static final Logger logger = LogManager.getLogger(ProductController.class);


	/**
	 * This method is used to get details of all products.
	 * 
	 * @return response json with product details
	 */
	@GetMapping(value = "/product", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ProductDTO> getProducts() {
		logger.info("List all products...");
		List<ProductDTO> productList = productService.getAllProducts();
		return productList;
	}

	/**
	 * This method is used to get details of a product based on id passed.
	 * 
	 * @param id:
	 *            Product ID
	 * @return response json with specific product details
	 */
	@GetMapping(value = "/product/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ProductDTO getProduct(@PathVariable int id) {
		logger.info("List product by Id...");
		ProductDTO product = productService.getProductById(id);
		return product;
	}

	/**
	 * This method is used to update details for a product based on id passed.
	 * 
	 * @param id:
	 *            Product ID
	 * @return response json with updated product details
	 */
	@PutMapping(value = "/product/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ProductDTO updateProduct(@RequestBody Product newProduct, @PathVariable int id) {
		logger.info("Update product currency data...");
		ProductDTO updatedProduct = productService.updateProductData(id,newProduct);
		return updatedProduct;
	}

	/**
	 * This method is used to create a product record.
	 * 
	 * @return response json with created product details
	 */
	@PostMapping(value = "/product", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ProductDTO addProduct(@RequestBody Product product) {
		logger.info("Save product data...");
		ProductDTO productDto = productService.saveProduct(product);
		return productDto;
	}
	
	/**
	 * This method is used to delete a product based on id passed.
	 * 
	 * @param id:
	 *            Product ID
	 * @return response json with success message
	 */
	@DeleteMapping(value = "/product/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String deleteProduct(@PathVariable int id) {
		logger.info("Delete product data...");
		String status= productService.deleteById(id);
		return status;
			
	}

	/**
	 * This method is an internal API to fetch the product details. This API is used
	 * to mimic the external API response of redsky.target.com.
	 * 
	 * @return response json with created product details
	 */
	@GetMapping("/productname")
	public String getProductName() {
		String returnJson = "{\"product\":{\"deep_red_labels\":{\"total_count\":2,\"labels\":[{\"id\":\"twbl94\",\"name\":\"Movies\",\"type\":\"merchandise type\",\"priority\":0,\"count\":1},{\"id\":\"rv3fdu\",\"name\":\"SA\",\"type\":\"relationship type\",\"priority\":0,\"count\":1}]},\"available_to_promise_network\":{\"product_id\":\"13860428\",\"id_type\":\"TCIN\",\"available_to_promise_quantity\":59.0,\"street_date\":\"2011-11-15T06:00:00.000Z\",\"availability\":\"AVAILABLE\",\"online_available_to_promise_quantity\":59.0,\"stores_available_to_promise_quantity\":0.0,\"availability_status\":\"IN_STOCK\",\"multichannel_options\":[],\"is_infinite_inventory\":false,\"loyalty_availability_status\":\"IN_STOCK\",\"loyalty_purchase_start_date_time\":\"1970-01-01T00:00:00.000Z\",\"is_loyalty_purchase_enabled\":false,\"is_out_of_stock_in_all_store_locations\":false,\"is_out_of_stock_in_all_online_locations\":false},\"item\":{\"tcin\":\"13860428\",\"bundle_components\":{},\"dpci\":\"058-34-0436\",\"upc\":\"025192110306\",\"product_description\":{\"title\":\"The Big Lebowski (Blu-ray)\",\"bullet_description\":[\"<B>Movie Studio:</B> Universal Studios\",\"<B>Movie Genre:</B> Comedy\",\"<B>Software Format:</B> Blu-ray\"]},\"buy_url\":\"https://www.target.com/p/the-big-lebowski-blu-ray/-/A-13860428\",\"enrichment\":{\"images\":[{\"base_url\":\"https://target.scene7.com/is/image/Target/\",\"primary\":\"GUEST_44aeda52-8c28-4090-85f1-aef7307ee20e\",\"content_labels\":[{\"image_url\":\"GUEST_44aeda52-8c28-4090-85f1-aef7307ee20e\"}]}],\"sales_classification_nodes\":[{\"node_id\":\"hp0vg\"},{\"node_id\":\"5xswx\"}]},\"return_method\":\"This item can be returned to any Target store or Target.com.\",\"handling\":{},\"recall_compliance\":{\"is_product_recalled\":false},\"tax_category\":{\"tax_class\":\"G\",\"tax_code_id\":99999,\"tax_code\":\"99999\"},\"display_option\":{\"is_size_chart\":false},\"fulfillment\":{\"is_po_box_prohibited\":true,\"po_box_prohibited_message\":\"We regret that this item cannot be shipped to PO Boxes.\",\"box_percent_filled_by_volume\":0.27,\"box_percent_filled_by_weight\":0.43,\"box_percent_filled_display\":0.43},\"package_dimensions\":{\"weight\":\"0.18\",\"weight_unit_of_measure\":\"POUND\",\"width\":\"5.33\",\"depth\":\"6.65\",\"height\":\"0.46\",\"dimension_unit_of_measure\":\"INCH\"},\"environmental_segmentation\":{\"is_lead_disclosure\":false},\"manufacturer\":{},\"product_vendors\":[{\"id\":\"1984811\",\"manufacturer_style\":\"025192110306\",\"vendor_name\":\"Ingram Entertainment\"},{\"id\":\"4667999\",\"manufacturer_style\":\"61119422\",\"vendor_name\":\"UNIVERSAL HOME VIDEO\"},{\"id\":\"1979650\",\"manufacturer_style\":\"61119422\",\"vendor_name\":\"Universal Home Ent PFS\"}],\"product_classification\":{\"product_type\":\"542\",\"product_type_name\":\"ELECTRONICS\",\"item_type_name\":\"Movies\",\"item_type\":{\"category_type\":\"Item Type: MMBV\",\"type\":300752,\"name\":\"movies\"}},\"product_brand\":{\"brand\":\"Universal Home Video\",\"manufacturer_brand\":\"Universal Home Video\",\"facet_id\":\"55zki\"},\"item_state\":\"READY_FOR_LAUNCH\",\"specifications\":[],\"attributes\":{\"gift_wrapable\":\"N\",\"has_prop65\":\"N\",\"is_hazmat\":\"N\",\"manufacturing_brand\":\"Universal Home Video\",\"max_order_qty\":10,\"street_date\":\"2011-11-15\",\"media_format\":\"Blu-ray\",\"merch_class\":\"MOVIES\",\"merch_classid\":58,\"merch_subclass\":34,\"return_method\":\"This item can be returned to any Target store or Target.com.\",\"ship_to_restriction\":\"United States Minor Outlying Islands,American Samoa (see also separate entry under AS),Puerto Rico (see also separate entry under PR),Northern Mariana Islands,Virgin Islands, U.S.,APO/FPO,Guam (see also separate entry under GU)\"},\"country_of_origin\":\"US\",\"relationship_type_code\":\"Stand Alone\",\"subscription_eligible\":false,\"ribbons\":[],\"tags\":[],\"ship_to_restriction\":\"This item cannot be shipped to the following locations: United States Minor Outlying Islands, American Samoa, Puerto Rico, Northern Mariana Islands, Virgin Islands, U.S., APO/FPO, Guam\",\"estore_item_status_code\":\"A\",\"is_proposition_65\":false,\"return_policies\":{\"user\":\"Regular Guest\",\"policyDays\":\"30\",\"guestMessage\":\"This item must be returned within 30 days of the ship date. See return policy for details.\"},\"gifting_enabled\":false,\"packaging\":{\"is_retail_ticketed\":false}},\"circle_offers\":{\"universal_offer_exists\":false,\"non_universal_offer_exists\":true}}}";
		return returnJson;
	}
}