package com.pf.service;

import java.util.List;

import com.pf.domain.Cart;

public interface CheckoutService {
	
	public float calculatePrice(List<Cart> updatedProducts);

}
