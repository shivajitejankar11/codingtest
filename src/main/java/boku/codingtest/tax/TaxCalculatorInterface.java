package boku.codingtest.tax;

import boku.codingtest.product.ProductInterface;

import java.math.BigDecimal;

public interface TaxCalculatorInterface {
	
	public BigDecimal calculateTax(ProductInterface product);
	
	public BigDecimal calculateTaxRate(ProductInterface product);
}
