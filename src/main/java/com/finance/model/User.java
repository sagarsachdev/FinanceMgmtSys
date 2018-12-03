package com.finance.model;

public class User {
	private int id;
	private String name;
	private long phone;
	private String email;
	private String address;
	private String uname;
	private String password;
	private String card;
	private long accountNo;
	private String bank;
	private String ifsc;
	private String verified;
	public User() {
		super();
	}
	public User(int id, String name, long phone, String email, String address, String uname, String password, String card,
			long accountNo, String bank, String ifsc, String verified) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.uname = uname;
		this.password = password;
		this.card = card;
		this.accountNo = accountNo;
		this.bank = bank;
		this.ifsc = ifsc;
		this.verified = verified;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = MD5.getMd5(password);
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	  
	}
