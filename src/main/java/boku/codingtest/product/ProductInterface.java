package boku.codingtest.product;

import java.math.BigDecimal;

public interface ProductInterface {

	public BigDecimal getCostBeforeTax();
	
	public boolean isExempted();
	
	public boolean isImported();
	
	
}
