package com.pf.service.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pf.constants.DataConstants;
import com.pf.domain.Cart;
import com.pf.domain.ProductDescription;
import com.pf.domain.Rule;
import com.pf.service.CheckoutService;
import com.pf.service.DiscountService;
import com.pf.service.impl.CheckoutServiceImpl;
import com.pf.service.impl.DiscountServiceImpl;

public class CheckoutServiceTest {
	
	@Test
	public void testCalculatePrice() {
		
		CheckoutService checkoutService = new CheckoutServiceImpl();
		
		List<Cart> carts = new ArrayList<Cart>();
		
		Cart cart1 = new Cart();
		cart1.setProductCode("0001");
		cart1.setQuantity(5);
		cart1.setRuleId(1);
		
		Cart cart2 = new Cart();
		cart2.setProductCode("0002");
		cart2.setQuantity(8);
		cart2.setRuleId(1);
		
		carts.add(cart1);
		carts.add(cart2);
		
		float total = checkoutService.calculateDiscountedPrice(carts);
		assertEquals(3.30, total,0.002);
	}

}
