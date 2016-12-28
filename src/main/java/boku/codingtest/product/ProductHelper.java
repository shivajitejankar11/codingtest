package boku.codingtest.product;



import boku.codingtest.product.ProductDefinition.ProductType;
import boku.codingtest.util.CodingTestUtil;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Following class will act as an helper class to perform product related activities.
 * @author darshan
 *
 */
public class ProductHelper {

	/**
	 * Following method will build a product objects from the provided raw lines of product description.
	 * @param rawProductData String containing product information
	 * @return Product object
	 */
	public static Product getStructuredProduct(String rawProductData) {
		
		return new Product(parseProductType(rawProductData),parseName(rawProductData),
									parseQuantity(rawProductData),parseCostBeforeTax(rawProductData),parseIsImported(rawProductData));
		
	}
	
	/**
	 * Following method will parse the provided string and return quantity from the provided input string.
	 * @param rawProductData input string
	 * @return value of quantity
	 */
	public static int parseQuantity(String rawProductData){
		
		int quantity = -1;
		
		// Get the digits from the starting character of the line until the first space character is encountered
		String regEx = "(\\d+)\\s";
		
		Matcher matcher = CodingTestUtil.getRegExMatcher(rawProductData, regEx);
		if (matcher.find()) {
			 quantity = Integer.parseInt(matcher.group(1).trim());
		}
		
		return quantity;
	}
	
	/**
	 * Following method will parse the provided string and return Name of the product from the provided input string.
	 * @param rawProductData input string
	 * @return Name of the product
	 */
	public static String parseName(String rawProductData){
		
		String name = "";
		
		// Get the value between first space and word 'at'.
		String regEx = "\\s(.+)at.+";
		
		Matcher matcher = CodingTestUtil.getRegExMatcher(rawProductData, regEx);
		if (matcher.find()) {
			name = matcher.group(1).trim();
		}

		return name;
	}
	
	/**
	 * Following method will parse the provided string and return cost of the product from the provided input string.
	 * @param rawProductData input string
	 * @return Cost of product
	 */
	public static BigDecimal parseCostBeforeTax(String rawProductData){
		
		BigDecimal totalProce = null;
		
		//Get the digits and decimal points between space character after 'at' word until the end of string
		String regEx = "at\\s(\\d+\\.*\\d*)";
		
		Matcher matcher = CodingTestUtil.getRegExMatcher(rawProductData, regEx);
		if (matcher.find()) {
			totalProce = new BigDecimal(matcher.group(1).trim());
		}
		
		return totalProce;
	}
	
	/**
	 * Following method will parse the provided string and return the imported indicator from the provided input string.
	 * @param rawProductData input string
	 * @return Indicator if product is imported or not
	 */
	public static boolean parseIsImported(String rawProductData){
		
		// If input string contains a word imported
		String regEx = ".+(?i)(imported).+";
		return Pattern.matches(regEx, rawProductData);
	}
	
	/**
	 * Following method will parse the provided string and return Product Type from the provided input string.
	 * @param rawProductData input string
	 * @return Product Type
	 */
	public static ProductType parseProductType(String rawProductData){

		//Default to Others
		ProductType productType = ProductType.OTHERS;
		
		// Iterate Product Type matcher map and match the string with each Regx.
		Iterator<String> productTypeMatcherMapIterator = ProductDefinition.productTypeMatcherMap.keySet().iterator();
		
		String regEx="";
		
		// If any match found then get the Product Type stored for the matched Regx and return it.
		while(productTypeMatcherMapIterator.hasNext()){
			regEx = productTypeMatcherMapIterator.next();
			if(Pattern.matches(regEx, rawProductData)){
				productType = ProductDefinition.productTypeMatcherMap.get(regEx);
				break;
			}
		}
		
		return productType;
		
	}
	
}
