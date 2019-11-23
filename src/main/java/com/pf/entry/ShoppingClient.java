package com.pf.entry;

import com.pf.service.DiscountService;
import com.pf.service.impl.DiscountServiceImpl;

public class ShoppingClient {

	public static void main(String[] args) {
		DiscountService discountService = new DiscountServiceImpl();
		discountService.freeOffer(1, 1, 1, 1);
		discountService.freeOffer(1, 1, 2, 1);
		discountService.freeOffer(1, 1, 3, 1);
		discountService.freeOffer(1, 1, 4, 1);
		discountService.freeOffer(1, 1, 5, 1);
		discountService.freeOffer(1, 1, 6, 1);
		
		discountService.freeOffer(2, 1, 1, 2);
		discountService.freeOffer(2, 1, 2, 2);
		discountService.freeOffer(2, 1, 3, 2);
		discountService.freeOffer(2, 1, 4, 2);
		discountService.freeOffer(2, 1, 5, 2);
		discountService.freeOffer(2, 1, 6, 2);

	}

}
