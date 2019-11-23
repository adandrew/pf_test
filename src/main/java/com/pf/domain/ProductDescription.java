package com.pf.domain;

public class ProductDescription {
	
	private String productId;
	private String productName;
	private float productPrice;
	private Rule rule;
	
	public ProductDescription(String productId,String productName, float productPrice, Rule rule) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.setRule(rule);
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}
}
