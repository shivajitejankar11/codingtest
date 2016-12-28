package boku.codingtest.shoppingcart;


import boku.codingtest.TestData;
import boku.codingtest.exceptions.InputValidationException;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class ShoppingCartTest {

	@Test
	public void testGetTotalCartAmout(){
		try{
			
			ShoppingCartInterface shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList1);
			Assert.assertEquals(new BigDecimal("29.83"), shoppingCart.getTotalCartAmout());
			
			shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList2);
			Assert.assertEquals(new BigDecimal("65.15"), shoppingCart.getTotalCartAmout());
			
		}catch(InputValidationException ive){
			ive.printStackTrace();
		}
	}
	
	@Test
	public void testGetTotalSalesTax(){
		try{
			
			ShoppingCartInterface shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList1);
			Assert.assertEquals(new BigDecimal("1.50"), shoppingCart.getTotalSalesTax());
			
			shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList2);
			Assert.assertEquals(new BigDecimal("7.65"), shoppingCart.getTotalSalesTax());
			
		}catch(InputValidationException ive){
			ive.printStackTrace();
		}
	}
	
	
	
}
