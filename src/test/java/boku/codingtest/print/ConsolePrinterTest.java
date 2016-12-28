package boku.codingtest.print;


import boku.codingtest.TestData;
import boku.codingtest.exceptions.InputValidationException;
import boku.codingtest.shoppingcart.ShoppingCartHelper;
import boku.codingtest.shoppingcart.ShoppingCartInterface;

import org.junit.Assert;
import org.junit.Test;

public class ConsolePrinterTest {

	@Test
	public void testGetPrintData(){
		
		try{
			
			ShoppingCartInterface shoppingCart = ShoppingCartHelper.buildShoppingCart(TestData.inputList1);
			
			String expectedString = "1 book: 12.49\n1 music CD: 16.49\n1 chocolate bar: 0.85\n\nSales Taxes: 1.50\nTotal: 29.83";
			
			PrinterInterface printer = PrinterFactory.getPrinter(PrintType.CONSOLE);
			
			Assert.assertEquals(expectedString, printer.getPrintData(shoppingCart));
			
		}catch(InputValidationException ive){
			ive.printStackTrace();
		}
	}
	
}
