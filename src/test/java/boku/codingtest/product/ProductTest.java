package boku.codingtest.product;

import boku.codingtest.exceptions.InputValidationException;
import boku.codingtest.shoppingcart.ShoppingCartHelper;
import boku.codingtest.shoppingcart.ShoppingCartInterface;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ProductTest {

	@Test
	public void testGetCostAfterTax(){
		
		try{
			
			List<String> rawProductList = new ArrayList<String>();
			rawProductList.add("1 book at 12.49");
			
			ShoppingCartInterface shoppingCart = ShoppingCartHelper.buildShoppingCart(rawProductList);
			
			for(Product product : shoppingCart.getListOfProducts()){
				Assert.assertEquals(new BigDecimal("12.49"), product.getCostAfterTax());
			}
			
			rawProductList.clear();
			rawProductList.add("1 imported bottle of perfume at 47.5");
			
			shoppingCart = ShoppingCartHelper.buildShoppingCart(rawProductList);
			
			for(Product product : shoppingCart.getListOfProducts()){
				Assert.assertEquals(new BigDecimal("54.65"), product.getCostAfterTax());
			}
			
		}catch(InputValidationException ive){
			ive.printStackTrace();
		}
	}
	
}
