package com.pf.service;

import java.util.List;

import com.pf.domain.Product;

public interface CheckoutService {
	
	public void addItems(List<Product> products);
	public void updateItems(List<Product> updatedProducts);
	public void calculatePrice(List<Product> updatedProducts);

}
