package com.product.myretail.dto;

public class ProductDTO {

	private int id;
	private String productName;
	private PriceDTO current_price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String name) {
		this.productName = name;
	}
	public PriceDTO getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(PriceDTO current_price) {
		this.current_price = current_price;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productName=" + productName + ", current_price=" + current_price + "]";
	}
	
	
}
