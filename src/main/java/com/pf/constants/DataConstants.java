package com.pf.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pf.domain.ProductDescription;
import com.pf.domain.Rule;

public class DataConstants {
	
	public static Map<Integer,String> buildProduct() {
		Map<Integer,String> productMap = new HashMap<Integer, String>();
		productMap.put(1, "Apples");
		productMap.put(2,"Oranges");
		
		return productMap;
	}
	
	public static Map<Integer,Float> buildPrice() {
		
		Map<Integer,Float> productPriceMap = new HashMap<Integer, Float>();
		productPriceMap.put(1, .60f);
		productPriceMap.put(2, .25f);
		
		return productPriceMap;
	}
	
	public static List<ProductDescription> buildStoreProducts() {
		List<ProductDescription> products = new ArrayList<ProductDescription>();
		String [] productIds = {"0001","0002"};
		String [] productNames = {"Apples","Oranges"};
		float [] productPrices = {0.60f,0.25f};
		Rule [] rules = {new Rule(1,1,1,"Buy 1 get 1 free"), new Rule(2,2,1,"Buy 3 for the price of 2")};
		
		for(int i=0;i<productIds.length;i++) {
			products.add(new ProductDescription(productIds[i], productNames[i], productPrices[i],rules[i]));
		}
		
		return products;
	}

}
