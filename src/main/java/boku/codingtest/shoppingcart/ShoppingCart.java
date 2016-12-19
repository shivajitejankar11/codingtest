package boku.codingtest.shoppingcart;



import boku.codingtest.print.PrintType;
import boku.codingtest.print.PrinterFactory;
import boku.codingtest.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart implements ShoppingCartInterface {

	private	List<Product> listOfProducts = null;
	
	public ShoppingCart(){
		listOfProducts = new ArrayList<>();
	}
	
	
	@Override
	public List<Product> getListOfProducts() {
		return listOfProducts;
	}



	@Override
	public void addProductToCart(Product product) {
		product.calculateSalesTax();
		listOfProducts.add(product);
	}

	@Override
	public BigDecimal getTotalCartAmout() {
		BigDecimal totalCartAmount = new BigDecimal("0.00");
		for(Product product : listOfProducts){
			totalCartAmount = totalCartAmount.add(product.getCostAfterTax());
		}
		return totalCartAmount;
	}

	@Override
	public BigDecimal getTotalSalesTax() {
		BigDecimal totalSalesTax = new BigDecimal("0.00");
		for(Product product : listOfProducts){
			totalSalesTax = totalSalesTax.add(product.getSalesTax());
		}
		return totalSalesTax;
		
	}

	@Override
	public void printReceipt(PrintType printType) {
		PrinterFactory.getPrinter(printType).print(this);
	}

	@Override
	public String toString(){
		StringBuilder shoppingCartStringBuilder = new StringBuilder();
		
		for(Product product : listOfProducts){
			shoppingCartStringBuilder.append(product.getQuantity());
			shoppingCartStringBuilder.append(" " + product.getProductName());
			shoppingCartStringBuilder.append(" : " + product.getCostAfterTax());
			shoppingCartStringBuilder.append(" Type:" + product.getProductType());
			shoppingCartStringBuilder.append(" Imported:" + product.isImported());
			shoppingCartStringBuilder.append(" Exempted:" + product.getProductType().isExempted());
			shoppingCartStringBuilder.append("\n");
		}
		
		return shoppingCartStringBuilder.toString();
	}
}
