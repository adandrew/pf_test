package com.pf.exceptions;

public class ProductNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9033304414622278779L;

	public ProductNotFoundException(String errString) {
		super(errString);
	}
}
