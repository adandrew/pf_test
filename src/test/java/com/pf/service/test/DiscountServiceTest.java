package com.pf.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pf.domain.Cart;
import com.pf.domain.ProductDescription;
import com.pf.domain.Rule;
import com.pf.service.DiscountService;
import com.pf.service.impl.DiscountServiceImpl;

public class DiscountServiceTest {
	
	@Test
	public void testFreeOffer() {
		
		DiscountService discountService = new DiscountServiceImpl();
		
		Rule rule1 = new Rule(1,1,1);
		Rule rule2 = new Rule(2,2,1);
		
		ProductDescription product1 = new ProductDescription("0001", "Apples", 0.60f, rule1);
		ProductDescription product2 = new ProductDescription("0002", "Oranges", 0.25f, rule2);
		
		Cart cart1 = new Cart();
		cart1.setProductCode("0001");
		cart1.setQuantity(5);
		cart1.setRuleId(1);
		
		Cart cart2 = new Cart();
		cart2.setProductCode("0002");
		cart2.setQuantity(8);
		cart2.setRuleId(1);
		
		float amount = discountService.freeOffer(product1, cart1);
		assertEquals(1.80, amount,0.002);
		
		amount = discountService.freeOffer(product2, cart2);
		assertEquals(1.50, amount,0.002);
	}

}
