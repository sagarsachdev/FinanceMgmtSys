package com.finance.model;

public class Purchase {
	private int id;
	private int productId;
	private String buyingDate;
	private int period;
	private float cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getBuyingDate() {
		return buyingDate;
	}
	public void setBuyingDate(String buyingDate) {
		this.buyingDate = buyingDate;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}
