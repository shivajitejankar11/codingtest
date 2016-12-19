package boku.codingtest.product;

import java.util.HashMap;
import java.util.Map;

/**
 * Following class defines type of products and also defines its properties.
 * @author darshan
 *
 */
public class ProductDefinition {

	public enum ProductType{
		
		BOOK(true),
		MEDICAL(true),
		FOOD(true),
		OTHERS (false);
		
		private boolean isExempted;
		
		private ProductType(boolean exepmted){
			isExempted = exepmted;
		}

		public boolean isExempted(){
			return isExempted;
		}

	}
	
	static Map<String,ProductType> productTypeMatcherMap = new HashMap<String,ProductType>();
	
	static {
		productTypeMatcherMap.put(".*(?i)(book).*", ProductType.BOOK);
		productTypeMatcherMap.put(".*(chocolate)(?i).*", ProductType.FOOD);
		productTypeMatcherMap.put(".*(pill)(?i).*", ProductType.MEDICAL);
	}
}
