package com.pf.service.impl;

import java.util.List;

import com.pf.constants.DataConstants;
import com.pf.domain.Cart;
import com.pf.domain.ProductDescription;
import com.pf.service.CheckoutService;
import com.pf.service.DiscountService;

public class CheckoutServiceImpl implements CheckoutService{
	
	List<ProductDescription> products = DataConstants.buildStoreProducts();
	DiscountService discountService = new DiscountServiceImpl();
	
	@Override
	public void calculatePrice(List<Cart> updatedProducts) {
		
		for(ProductDescription product:products) {
			for(Cart cart:updatedProducts) {
				if(cart.getProductCode().equals(product.getProductId())) {
					
				}
			}
		}
	}
}
