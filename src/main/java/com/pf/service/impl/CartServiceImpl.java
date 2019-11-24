package com.pf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pf.constants.DataConstants;
import com.pf.domain.Cart;
import com.pf.domain.ProductDescription;
import com.pf.exceptions.ProductNotFoundException;
import com.pf.service.CartService;

public class CartServiceImpl implements CartService {
	
	List<Cart> cartProducts = new ArrayList<Cart>();
	
	List<ProductDescription> products = DataConstants.buildStoreProducts();
	
	@Override
	public void addItems(String productCode, int quantity) {
		
		if(quantity > 0) {
			Optional<Cart> filteredProducts	 = cartProducts.stream().filter(p -> p.getProductCode().equals(productCode)).findFirst();
			
			if(filteredProducts.isPresent()) {
				
				Cart cart = filteredProducts.get();
				int originalQuantity = cart.getQuantity();
				int updatedQuantity = originalQuantity + quantity;
				cartProducts.stream().filter(p -> p.getProductCode().equals(productCode)).forEach(p -> p.setQuantity(updatedQuantity));
			}else {
				Cart cart = new Cart();
				cart.setProductCode(productCode);
				cart.setQuantity(quantity);
				cart.setRuleId(getRuleId(productCode));
				cartProducts.add(cart);
			}
		}
	}
	
	@Override
	public void removeItems(String productCode, int quantity) {
		if(quantity > 0) {
			try {
				Optional<Cart> filteredProducts	 = cartProducts.stream().filter(p -> p.getProductCode().equals(productCode)).findFirst();
				
				if(filteredProducts.isPresent()) {
					Cart cart = filteredProducts.get();
					
					int originalQuantity = cart.getQuantity();
					int updatedQuantity = 0;
					if(quantity <= originalQuantity) {
						updatedQuantity = originalQuantity - quantity;
					}else {
						updatedQuantity = 0;
					}
					cart.setQuantity(updatedQuantity);
					if(updatedQuantity > 0)
						cartProducts.stream().filter(p -> p.getProductCode().equals(productCode)).forEach(p -> p.setQuantity(cart.getQuantity()));
					else {
						List<Cart> operatedList = new ArrayList<Cart>();
						cartProducts.stream().filter(p -> p.getProductCode().equals(productCode)).forEach(p -> {
							operatedList.add(p);
						});
						cartProducts.removeAll(operatedList);
					}
						
				}else
					throw new ProductNotFoundException("Product was not in the cart");
			}catch (ProductNotFoundException pnfe) {
				System.err.println(pnfe.getMessage());
			}
			
		}
	}
	
	@Override
	public List<Cart> getFinalProductsInCart() {
		return cartProducts;
	}
	
	@Override
	public boolean findProductByCode(String code) {
		
		
		Optional<ProductDescription> matchingObject = products.stream().filter(p -> p.getProductId().equals(code)).findFirst();
		
		if(matchingObject.isPresent())
			return true;
		
		return false;
	}
	
	private int getRuleId(String code) {
		
		Optional<ProductDescription> matchingObject = products.stream().filter(p -> p.getProductId().equals(code)).findFirst();
		
		if(matchingObject.isPresent()) {
			ProductDescription product = matchingObject.get();
			
			return product.getRule().getRuleId();
		}
		return 0;
	}

}
