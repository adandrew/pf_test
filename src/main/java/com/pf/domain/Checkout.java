package com.pf.domain;

public class Checkout {
	
	private float actualPrice;
	private float discountedPrice;
	private float actualPaid;
	
	public float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public float getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(float discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public float getActualPaid() {
		return actualPaid;
	}
	public void setActualPaid(float actualPaid) {
		this.actualPaid = actualPaid;
	}
}
