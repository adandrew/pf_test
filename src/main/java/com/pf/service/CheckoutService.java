package com.pf.service;

import java.util.List;

import com.pf.domain.Cart;

public interface CheckoutService {
	
	public void calculatePrice(List<Cart> updatedProducts);

}
