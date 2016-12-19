package boku.codingtest.tax;

public class TaxCalculatorFactory {

	private TaxCalculatorFactory(){};
	
	/**
	 * Following method will return Implementation of Tax Calculator based on provided Tax Type. 
	 * @param taxType Tax Type for which calculator is looked up
	 * @return Tax Calculator object of provided tax type
	 */
	public static TaxCalculatorInterface getTaxCalculator(TaxType taxType){
		
		TaxCalculatorInterface taxCalculator = null;
		
		if(taxType == TaxType.SALES){
			taxCalculator = SalesTaxCalculator.getInstance();
		}
		
		return taxCalculator;
	}
	
}

