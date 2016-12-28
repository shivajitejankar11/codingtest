package boku.codingtest.tax;


import boku.codingtest.product.ProductInterface;
import boku.codingtest.util.CodingTestUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesTaxCalculator implements TaxCalculatorInterface{

	public static final BigDecimal ROUND_OFF = new BigDecimal("0.05");
	
	public static final BigDecimal PEERCENTAGE_DIVISOR = new BigDecimal("100");
	
	public static final BigDecimal SALES_TAX_PERCENTAGE_NON_EXEMPT = new BigDecimal("10.00");
	
	public static final BigDecimal SALES_TAX_PERCENTAGE_ADDITIONAL_IMPORTED = new BigDecimal("5.00");
	
	private static SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator();
	
	private SalesTaxCalculator() {}
	
	public static SalesTaxCalculator getInstance(){
		return salesTaxCalculator;
	}

	@Override
	public BigDecimal calculateTax(ProductInterface product) {
		return calculateTax(product.getCostBeforeTax(),calculateTaxRate(product));
	}

	/**
	 * Following method will calculate the tax based on provided product cost and tax rate.
	 * @param cost Product Cost
	 * @param taxRate Tax Rate
	 * @return returns the calculated tax
	 */
	public BigDecimal calculateTax(BigDecimal cost, BigDecimal taxRate) {
		return CodingTestUtil.roundToNearestIncrement(cost.multiply(taxRate).divide(PEERCENTAGE_DIVISOR) , ROUND_OFF, RoundingMode.UP);
	}
	
	@Override
	public BigDecimal calculateTaxRate(ProductInterface product) {
		
		// Initialize with 0
		BigDecimal taxRate = new BigDecimal("0.00");
		
		// If product is not in exempt category then add Non Exempt tax rate
		if(!product.isExempted()){
			taxRate = taxRate.add(SALES_TAX_PERCENTAGE_NON_EXEMPT);
		}
		
		// If product is imported then add Imported product tax rate regardless of product is exempted domestically or not
		if(product.isImported()){
			taxRate = taxRate.add(SALES_TAX_PERCENTAGE_ADDITIONAL_IMPORTED);
		}
		
		return taxRate;
	}
	

}
