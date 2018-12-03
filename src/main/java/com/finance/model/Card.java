package com.finance.model;

public class Card {
	private long cardNo;
	private String uname;
	private String cardType;
	private String validity;
	private float value;
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public long getCardNo() {
		return cardNo;
	}
	public Card() {
		super();
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public Card(long cardNo, String uname, String cardType, String validity, int value) {
		super();
		this.cardNo = cardNo;
		this.uname = uname;
		this.cardType = cardType;
		this.validity = validity;
		this.value = value;
	}
	
}
