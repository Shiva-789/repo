package com.product.myretail.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Product {
	@PrimaryKey
	private int id;
	private String productName;
	private double currencyValue;
	private String currencyCode;
	
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
	public double getCurrencyValue() {
		return currencyValue;
	}
	public void setCurrencyValue(double currencyValue) {
		this.currencyValue = currencyValue;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Product(int id, String productName, double currencyValue, String currencyCode) {
		super();
		this.id = id;
		this.productName = productName;
		this.currencyValue = currencyValue;
		this.currencyCode = currencyCode;
	}
}