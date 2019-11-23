package com.pf.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtils {
	
	public static String getCurrencyDisplay(Locale definedLocale, float amount) {
		NumberFormat currencyFormatter  = NumberFormat.getCurrencyInstance(definedLocale);
		
		String formattedAmount = currencyFormatter.format(amount);
		
		return formattedAmount;
	}

}
