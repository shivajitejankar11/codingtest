package boku.codingtest.tax;



import boku.codingtest.product.ProductHelper;
import boku.codingtest.product.ProductInterface;
import boku.codingtest.tax.TaxCalculatorFactory;
import boku.codingtest.tax.TaxCalculatorInterface;
import boku.codingtest.tax.TaxType;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class SalesTaxCalculatorTest {

	@Test
	public void testCalculateSalesTaxFromProduct(){
		
		TaxCalculatorInterface taxCalculator = TaxCalculatorFactory.getTaxCalculator(TaxType.SALES);
		
		ProductInterface product1 = ProductHelper.getStructuredProduct("1 book at 12.49");
		ProductInterface product2 = ProductHelper.getStructuredProduct("1 music CD at 14.99");
		ProductInterface product3 = ProductHelper.getStructuredProduct("1 chocolate bar at 0.85");
		ProductInterface product4 = ProductHelper.getStructuredProduct("1 imported box of chocolates at 10.00");
		ProductInterface product5 = ProductHelper.getStructuredProduct("1 imported bottle of perfume at 47.50");
		
		
		Assert.assertEquals(new BigDecimal("0.00"), taxCalculator.calculateTax(product1));
		Assert.assertEquals(new BigDecimal("1.50"), taxCalculator.calculateTax(product2));
		Assert.assertEquals(new BigDecimal("0.00"), taxCalculator.calculateTax(product3));
		Assert.assertEquals(new BigDecimal("0.50"), taxCalculator.calculateTax(product4));
		Assert.assertEquals(new BigDecimal("7.15"), taxCalculator.calculateTax(product5));
	}
	
	@Test
	public void testCalculateTaxRate(){
		
		TaxCalculatorInterface taxCalculator = TaxCalculatorFactory.getTaxCalculator(TaxType.SALES);
		
		ProductInterface product1 = ProductHelper.getStructuredProduct("1 book at 12.49");
		ProductInterface product2 = ProductHelper.getStructuredProduct("1 music CD at 14.99");
		ProductInterface product3 = ProductHelper.getStructuredProduct("1 chocolate bar at 0.85");
		ProductInterface product4 = ProductHelper.getStructuredProduct("1 imported box of chocolates at 10.00");
		ProductInterface product5 = ProductHelper.getStructuredProduct("1 imported bottle of perfume at 47.50");
		
		Assert.assertEquals(new BigDecimal("0.00"), taxCalculator.calculateTaxRate(product1));
		Assert.assertEquals(new BigDecimal("10.00"), taxCalculator.calculateTaxRate(product2));
		Assert.assertEquals(new BigDecimal("0.00"), taxCalculator.calculateTaxRate(product3));
		Assert.assertEquals(new BigDecimal("5.00"), taxCalculator.calculateTaxRate(product4));
		Assert.assertEquals(new BigDecimal("15.00"), taxCalculator.calculateTaxRate(product5));
	}
	
	
}
