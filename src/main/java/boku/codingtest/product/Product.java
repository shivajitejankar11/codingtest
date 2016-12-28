package boku.codingtest.product;

import boku.codingtest.product.ProductDefinition.ProductType;
import boku.codingtest.tax.TaxCalculatorFactory;
import boku.codingtest.tax.TaxCalculatorInterface;
import boku.codingtest.tax.TaxType;

import java.math.BigDecimal;


/**
 * Javabean to hold product attributes.
 * @author darshan
 *
 */
public class Product implements ProductInterface {

	private ProductType productType;
	
	private String productName;
	
	private int quantity;

	private BigDecimal costBeforeTax;
	
	private BigDecimal salesTax;
	
	private boolean isImported;
	
	TaxCalculatorInterface taxCalculator;
	
	/**
	 * Constructor to build a product object.
	 * @param productType Product Category
	 * @param productname Product name
	 * @param quantity Quantity of the product
	 * @param costBeforeTax Total Price of the product
	 * @param isImported Is product imported?
	 */
	public Product(ProductType productType, String productname, int quantity, BigDecimal costBeforeTax, boolean isImported){
		
		this.productType = productType;
		this.productName = productname;
		this.quantity = quantity;
		this.costBeforeTax = costBeforeTax;
		this.isImported = isImported;
		
		this.taxCalculator = TaxCalculatorFactory.getTaxCalculator(TaxType.SALES);
	}
	
	public ProductType getProductType() {
		return productType;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCostBeforeTax() {
		return costBeforeTax;
	}

	public boolean isImported() {
		return isImported;
	}

	public BigDecimal getSalesTax() {
		return salesTax;
	}

	private void setSalesTax(BigDecimal salesTax) {
		this.salesTax = salesTax;
	}

	public void calculateSalesTax(){
		// Calculate sales tax from the provided tax calculator and set the sales tax property of the current product
		setSalesTax(taxCalculator.calculateTax(this));
	}
	
	public BigDecimal getCostAfterTax() {
		// Add sales tax in cost before tax and return Total Cost after tax
		return getCostBeforeTax().add(getSalesTax());
	}
	

	@Override
	public boolean isExempted() {
		return productType.isExempted();		
	}
}
