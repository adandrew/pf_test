package com.pf.service.impl;

import com.pf.domain.Cart;
import com.pf.domain.ProductDescription;
import com.pf.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {
	
	@Override
	public float freeOffer(ProductDescription product, Cart cart) {
		int payQuantity = product.getRule().getPaidQuantity();
		int freeQuantity =  product.getRule().getFreeQuantity();
		int actualQuantity = cart.getQuantity();
		float productPrice = product.getProductPrice();
		
		int sum = payQuantity + freeQuantity;
		
		float totalAmount = 0.0f;
		if(sum%2 == 0) {
			totalAmount = calculateOneForOne(actualQuantity, productPrice,cart.getProductCode());
		}else {
			totalAmount = calculateMixed(payQuantity, freeQuantity, actualQuantity, productPrice,cart.getProductCode());
		}
		
		return totalAmount;
	}
	//BOGOF
	private float calculateOneForOne(final int actualQuantity, final float productPrice, final String productCode) {
		
		int totalPayableQuantity = 0;
		float totalAmount = 0.0f;
		int quotient = actualQuantity/2;
		
		if(actualQuantity%2 == 0) {
			totalPayableQuantity = quotient;
		}else {
			totalPayableQuantity = actualQuantity - quotient;
		}
		totalAmount = totalPayableQuantity * productPrice;
		
		System.out.println("Total Amount for BOGOF product id "+productCode+" = "+totalAmount);
		
		return totalAmount;
	}
	
	private float calculateMixed(final int payQuantity, final int freeQuantity, final int actualQuantity, final float productPrice, final String productCode) {
		
		int totalPayableQuantity = 0;
		float totalAmount = 0.0f;
		
		int divisor = payQuantity + freeQuantity;
		int quotient = actualQuantity/divisor;
		
		if(actualQuantity%divisor == 0) {
			totalPayableQuantity = quotient * payQuantity;
		}else {
			totalPayableQuantity = actualQuantity - quotient;
		}
		totalAmount = totalPayableQuantity * productPrice;
		
		System.out.println("Total Amount for product id "+productCode+" = "+totalAmount);
		
		return totalAmount;
	}
	

}
