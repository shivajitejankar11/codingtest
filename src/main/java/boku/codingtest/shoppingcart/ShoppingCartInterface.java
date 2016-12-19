package boku.codingtest.shoppingcart;


import boku.codingtest.print.PrintType;
import boku.codingtest.product.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCartInterface {

	public List<Product> getListOfProducts();
	
	public void addProductToCart(Product product);
	
	public BigDecimal getTotalCartAmout();
	
	public BigDecimal getTotalSalesTax(); 
	
	public void printReceipt(PrintType printType);
}
