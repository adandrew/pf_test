package com.pf.service;

import java.util.List;

import com.pf.domain.Cart;

public interface CartService {
	
	public void addItems(String productCode, int quantity);
	public void removeItems(String productCode, int quantity);
	public boolean findProductByCode(String code);
	public List<Cart> getFinalProductsInCart();
}
