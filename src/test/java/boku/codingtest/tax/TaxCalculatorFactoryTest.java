package boku.codingtest.tax;

import boku.codingtest.tax.SalesTaxCalculator;
import boku.codingtest.tax.TaxCalculatorFactory;
import boku.codingtest.tax.TaxCalculatorInterface;
import boku.codingtest.tax.TaxType;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TaxCalculatorFactoryTest {

	@Test
	public void testGetTaxCalculator(){
		
		TaxCalculatorInterface taxCalculator = TaxCalculatorFactory.getTaxCalculator(TaxType.SALES);
		Assert.assertThat(taxCalculator, CoreMatchers.instanceOf(SalesTaxCalculator.class));
	}
	
}
