package boku.codingtest.print;

import boku.codingtest.product.Product;
import boku.codingtest.shoppingcart.ShoppingCartInterface;

public class ConsolePrinter implements PrinterInterface {

	@Override
	public void print(ShoppingCartInterface shoppingCart) {
	
		StringBuilder shoppingCartStringBuilder = new StringBuilder();
		
		for(Product product : shoppingCart.getListOfProducts()){
			shoppingCartStringBuilder.append(product.getQuantity());
			shoppingCartStringBuilder.append(" " + product.getProductName());
			shoppingCartStringBuilder.append(": " + product.getCostAfterTax());
			shoppingCartStringBuilder.append("\n");
		}
		shoppingCartStringBuilder.append("\nSales Taxes: " + shoppingCart.getTotalSalesTax());
		shoppingCartStringBuilder.append("\nTotal: " + shoppingCart.getTotalCartAmout());
		System.out.println(shoppingCartStringBuilder.toString());
		
	}

}
