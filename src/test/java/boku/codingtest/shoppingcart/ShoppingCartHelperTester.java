package boku.codingtest.shoppingcart;


import boku.codingtest.TestData;
import boku.codingtest.exceptions.InputValidationException;
import boku.codingtest.shoppingcart.ShoppingCartHelper;
import boku.codingtest.shoppingcart.ShoppingCartInterface;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartHelperTester {

	@Test
	public void testBuildShoppingCart(){
		
		// Provide different input strings
		try{
			
			ShoppingCartInterface shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList1);
			Assert.assertEquals(TestData.inputList1.size(), shoppingCart.getListOfProducts().size());
			
			shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList2);
			Assert.assertEquals(TestData.inputList2.size(), shoppingCart.getListOfProducts().size());
			
			shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList3);
			Assert.assertEquals(TestData.inputList3.size(), shoppingCart.getListOfProducts().size());

			
			// Validate invalid data
			boolean isInputTestDataValid = true;
			try{
				TestData.inputList3.add("invalid input");
				shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList3);
			}catch(InputValidationException ive){
				isInputTestDataValid = false;
				Assert.assertEquals(false,isInputTestDataValid);
			}
			
			
		}catch(InputValidationException ive){
			System.out.println("Invalid Input");
		}
		
	}
	
	//@Test
	public void buildShoppingCartsFromDir(){
		Assert.assertEquals(3, ShoppingCartHelper.buildShoppingCarts("../../../../test/java/boku/codingtest/inputfiles").size());
	}
	
}
