package com.pf.service.impl;

import java.util.List;

import com.pf.constants.DataConstants;
import com.pf.domain.Cart;
import com.pf.domain.Checkout;
import com.pf.domain.ProductDescription;
import com.pf.service.CheckoutService;
import com.pf.service.DiscountService;

public class CheckoutServiceImpl implements CheckoutService{
	
	List<ProductDescription> products = DataConstants.buildStoreProducts();
	DiscountService discountService = new DiscountServiceImpl();
	
	@Override
	public float calculateDiscountedPrice(List<Cart> updatedProducts) {
		
		float totalAmount = 0.0f;
		
		for(ProductDescription product:products) {
			for(Cart cart:updatedProducts) {
				if(cart.getProductCode().equals(product.getProductId())) {
					totalAmount += discountService.freeOffer(product, cart);
				}
			}
		}
		return totalAmount;
	}

	@Override
	public Checkout calculatePrice(List<Cart> updatedProducts) {
		Checkout checkout = new Checkout();
		
		float totalDiscountAmount = 0.0f;
		float totalAmount = 0.0f;
		for(ProductDescription product:products) {
			for(Cart cart:updatedProducts) {
				if(cart.getProductCode().equals(product.getProductId())) {
					totalAmount += calulateTotalAmount(product, cart);
					if(cart.getRuleId() == product.getRule().getRuleId())
						totalDiscountAmount += discountService.freeOffer(product, cart);
				}
			}
		}
		checkout.setActualPrice(totalAmount);
		if(totalDiscountAmount == 0.0f) {
			checkout.setDiscountedPrice(0.0f);
			checkout.setActualPaid(totalAmount);
		}
		else {
			checkout.setDiscountedPrice(totalDiscountAmount);
			checkout.setActualPaid(totalDiscountAmount);
		}
			
		
		return checkout;
	}
	
	private float calulateTotalAmount(ProductDescription product,Cart cart) {
		float totalAmount = 0.0f;
		
			totalAmount = cart.getQuantity() * product.getProductPrice();
			
		return totalAmount;
	}
}
