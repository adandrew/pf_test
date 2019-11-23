package com.pf.service;

import com.pf.domain.Cart;
import com.pf.domain.ProductDescription;

public interface DiscountService {
	
	public float freeOffer(ProductDescription product, Cart cart);

}
