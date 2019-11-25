package com.pf.service;

import java.util.List;

import com.pf.domain.Cart;
import com.pf.domain.Checkout;

public interface CheckoutService {
	
	public float calculateDiscountedPrice(List<Cart> updatedProducts);
	public Checkout calculatePrice(List<Cart> updatedProducts);

}
