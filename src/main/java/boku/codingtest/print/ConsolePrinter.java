package boku.codingtest.print;

import boku.codingtest.product.Product;
import boku.codingtest.shoppingcart.ShoppingCartInterface;

/**
 * Following class will provide implementation to print data on console.
 * @author darshan
 *
 */
public class ConsolePrinter implements PrinterInterface {

	@Override
	public void print(ShoppingCartInterface shoppingCart) {
		System.out.println(getPrintData(shoppingCart));
		
	}
	
	@Override
	public String getPrintData(ShoppingCartInterface shoppingCart){
		
		StringBuilder shoppingCartStringBuilder = new StringBuilder();
		
		// Iterate each product and prepare the printing data from its properties
		for(Product product : shoppingCart.getListOfProducts()){
			shoppingCartStringBuilder.append(product.getQuantity());
			shoppingCartStringBuilder.append(" " + product.getProductName());
			shoppingCartStringBuilder.append(": " + product.getCostAfterTax());
			shoppingCartStringBuilder.append("\n");
		}
		
		shoppingCartStringBuilder.append("\nSales Taxes: " + shoppingCart.getTotalSalesTax());
		shoppingCartStringBuilder.append("\nTotal: " + shoppingCart.getTotalCartAmout());
		
		return shoppingCartStringBuilder.toString();
	}

}
