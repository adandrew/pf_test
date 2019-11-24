package com.pf.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pf.service.CartService;
import com.pf.service.impl.CartServiceImpl;

public class CartServiceTest {
	
	CartService cartService = new CartServiceImpl();
	
	@Test
	public void testAddItems() {
		cartService.addItems("0001", 3);
		assertEquals(3, cartService.getFinalProductsInCart().get(0).getQuantity());
	}
	
	@Test
	public void testRemoveItems() {
		cartService.addItems("0001", 3);
		cartService.removeItems("0001", 2);
		assertEquals(1, cartService.getFinalProductsInCart().get(0).getQuantity());
	}
	
	@Test
	public void testFindProductByCode() {
		assertTrue(cartService.findProductByCode("0001"));
		assertFalse(cartService.findProductByCode("0001111"));
	}

}
