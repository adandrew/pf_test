package com.pf.ui;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.pf.constants.DataConstants;
import com.pf.domain.Cart;
import com.pf.domain.ProductDescription;
import com.pf.exceptions.InvalidInputException;
import com.pf.service.CartService;
import com.pf.service.CheckoutService;
import com.pf.service.impl.CartServiceImpl;
import com.pf.service.impl.CheckoutServiceImpl;
import com.pf.utils.CurrencyUtils;

public class StoreUI {

	CartService cartService = new CartServiceImpl();
	CheckoutService checkoutService = new CheckoutServiceImpl();

	private int inputCh = 0;

	private List<ProductDescription> products = DataConstants.buildStoreProducts();

	public StoreUI() {
		showMenu();
	}

	public void showMenu() {

		do {
			mainMenu();
			getUserInput();

			switch (inputCh) {
			case 1:
				displayStoreProducts();
				shoppingCartMenu();
				getUserInput();
				productsMenu();
				getUserInput();
				break;
			case 2:
				displayCart();
				break;
			case 3:
				checkoutCart();
				break;
			case 0:
				System.exit(0);
				break;
			case 100:
				
				break;
			default:
				break;
			}
		} while (inputCh != 0);
	}

	public void mainMenu() {
		System.out.println("#############Main Menu###############");
		System.out.println("1. Display Store Products");
		System.out.println("2. Display Cart");
		System.out.println("3. Checkout Cart");
		System.out.println("0. Exit");
		System.out.println("########################################");
	}

	private void displayStoreProducts() {

		System.out.println("#############Displaying the products in the store############");
		System.out.println("Code ---- Name ---- Price");
		products.stream().forEach(p -> System.out
				.println(p.getProductId() + "---- " + p.getProductName() + " ---- " + p.getProductPrice()));

		System.out.println("########################################");
	}

	public void shoppingCartMenu() {
		System.out.println("#############Shopping Cart############");
		System.out.println("1. Add to Cart");
		System.out.println("2. Remove From Cart");
		System.out.println("0. Exit");
		System.out.println("########################################");
	}

	private void productsMenu() {
		switch (inputCh) {
		case 1:
			addToCart();
			break;
		case 2:
			removeFromCart();
			break;
		case 0:
			showMenu();
			break;
		default:
			break;
		}
	}

	private void addToCart() {
		System.out.println("############Adding to Cart############");
		System.out.println("Enter the product code : ");
		String code = getUserInputForProduct();
		boolean isProductAvailable = cartService.findProductByCode(code);
		if (isProductAvailable) {
			System.out.println("Enter the quantity : ");
			int quantity = getUserInput();
			if (quantity > 0) {
				cartService.addItems(code, quantity);
				System.out.println("############Product added to cart############## ");
				shoppingCartMenu();
				getUserInput();
				productsMenu();
				getUserInput();
			}
		} else {
			System.err.println("Product does not exist for the given code. Let's try again");
			displayStoreProducts();
			shoppingCartMenu();
			getUserInput();
			productsMenu();
			getUserInput();
		}
	}

	private void removeFromCart() {
		System.out.println("############Removing from Cart############");
		System.out.println("Enter the product code : ");
		String code = getUserInputForProduct();
		boolean isProductAvailable = cartService.findProductByCode(code);
		if (isProductAvailable) {
			System.out.println("Enter the quantity : ");
			int quantity = getUserInput();
			if (quantity > 0) {
				cartService.removeItems(code, quantity);
				System.out.println("############Product removed from cart############## ");
				shoppingCartMenu();
				getUserInput();
				productsMenu();
				getUserInput();
			}
		} else {
			System.err.println("Product does not exist for the given code. Let's try again");
			displayStoreProducts();
			shoppingCartMenu();
			getUserInput();
			productsMenu();
			getUserInput();
		}
	}

	private void displayCart() {
		List<Cart> carts = cartService.getFinalProductsInCart();
		
		if(carts != null && !carts.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			System.out.println("####################Displaying cart####################");
			builder.append("You cart contains : ").append("\n");
			for (ProductDescription product : products) {
				for (Cart cart : carts) {
					if (cart.getProductCode().equals(product.getProductId())) {
						builder.append(product.getProductName()).append("-----").append(cart.getQuantity()).append("\n");
					}
				}
			}
			System.err.println(builder.toString());
			
		}else {
			System.err.println("########## Your cart is empty ###############");
		}
		showMenu();
	}

	public void checkoutCart() {
		List<Cart> carts = cartService.getFinalProductsInCart();
		if(carts != null && !carts.isEmpty()) {
			float totalAmount = checkoutService.calculatePrice(carts);
			Locale enGBLocale = new Locale.Builder().setLanguage("en").setRegion("GB").build();

			String amountDisplay = CurrencyUtils.getCurrencyDisplay(enGBLocale, totalAmount);

			System.err.println("############ Total Paid today = " + amountDisplay
					+ "  #################. Thank you see you soon #########");
			System.exit(0);
		}else {
			System.err.println("############## Your cart is empty. Please add items to checkout ################");
			showMenu();
		}
	}

	private int getUserInput() {
		try {
			Scanner in = new Scanner(System.in);
			String value = in.nextLine();
			if(StringUtils.isNumeric(value))
				inputCh = Integer.parseInt(value);
			else {
				inputCh = 100;
				showMenu();
				throw new InvalidInputException("Invalid Input. Try again");
			}
				
		}catch (InvalidInputException ive) {
			System.err.println(ive.getMessage());
			
		}
		return inputCh;
	}

	private String getUserInputForProduct() {

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();

		return input;
	}
}
