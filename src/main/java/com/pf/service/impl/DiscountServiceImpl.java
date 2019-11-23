package com.pf.service.impl;

import com.pf.constants.DataConstants;
import com.pf.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {

	public void freeOffer(int payQuantity, int freeQuantity, int actualQuantity, int productId) {
		
		if(payQuantity == freeQuantity) {
			calculateOneForOne(actualQuantity, productId);
		}else {
			calculateMixed(payQuantity, freeQuantity, actualQuantity, productId);
		}
		
	}
	//BOGOF
	private float calculateOneForOne(int actualQuantity, int productId) {
		
		int payableQuantity = 0;
		float totalAmount = 0.0f;
		int quotient = actualQuantity/2;
		
		if(actualQuantity%2 == 0) {
			payableQuantity = quotient;
		}else {
			payableQuantity = actualQuantity - quotient;
		}
		float productPrice = DataConstants.buildPrice().get(productId);
		totalAmount = payableQuantity * productPrice;
		
		System.out.println("Total Amount for BOGOF product id "+productId+" = "+totalAmount);
		
		return totalAmount;
	}
	
	private float calculateMixed(int payQuantity, int freeQuantity, int actualQuantity, int productId) {
		
		int payableQuantity = 0;
		float totalAmount = 0.0f;
		
		int divisor = payQuantity + freeQuantity;
		int quotient = actualQuantity/divisor;
		
		if(actualQuantity%divisor == 0) {
			payableQuantity = quotient * payQuantity;
		}else {
			payableQuantity = actualQuantity - quotient;
		}
		
		float productPrice = DataConstants.buildPrice().get(productId);
		totalAmount = payableQuantity * productPrice;
		
		System.out.println("Total Amount for product id "+productId+" = "+totalAmount);
		
		return totalAmount;
	}

}
