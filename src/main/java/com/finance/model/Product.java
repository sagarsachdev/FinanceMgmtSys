package com.finance.model;

public class Product {
	private int productId;
	private String productName;
	private String productDetails;
	private double Cost;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public double getCost() {
		return Cost;
	}
	public void setCost(double cost) {
		Cost = cost;
	}

}
