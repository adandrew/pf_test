package com.pf.constants;

import java.util.HashMap;
import java.util.Map;

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

}
