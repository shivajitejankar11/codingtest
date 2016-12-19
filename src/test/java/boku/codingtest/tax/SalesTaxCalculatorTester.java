package boku.codingtest.tax;



import boku.codingtest.product.ProductHelper;
import boku.codingtest.product.ProductInterface;
import boku.codingtest.tax.TaxCalculatorFactory;
import boku.codingtest.tax.TaxCalculatorInterface;
import boku.codingtest.tax.TaxType;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class SalesTaxCalculatorTester {

	@Test
	public void testCalculateSalesTax(){
		
		TaxCalculatorInterface taxCalculator = TaxCalculatorFactory.getTaxCalculator(TaxType.SALES);
		
		ProductInterface product1 = ProductHelper.getStructuredProduct("1 book at 12.49");
		ProductInterface product2 = ProductHelper.getStructuredProduct("1 book at 12.49");
		ProductInterface product3 = ProductHelper.getStructuredProduct("1 book at 12.49");
		ProductInterface product4 = ProductHelper.getStructuredProduct("1 book at 12.49");
		ProductInterface product5 = ProductHelper.getStructuredProduct("1 book at 12.49");
		
		Assert.assertEquals(new BigDecimal("0.60"), taxCalculator.calculateTax(product1));
	}
	
}
