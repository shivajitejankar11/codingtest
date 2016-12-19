package boku.codingtest.shoppingcart;


import boku.codingtest.exceptions.InputValidationException;
import boku.codingtest.product.ProductHelper;
import boku.codingtest.util.FileUtil;
import boku.codingtest.validation.InputValidator;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartHelper {

	
	/**
	 * Following method will read all the input files given at provided directory and build shopping cart for each one of them.
	 * @param dirPath directory path containing all input files
	 * @return List of shopping carts for each product
	 */
	public static List<ShoppingCartInterface> buildShoppingCarts(String dirPath){
		
		
		
		List<ShoppingCartInterface> listOfShoppingCarts = new ArrayList<ShoppingCartInterface>();
		
		// Retrieve all input files from the provided directory
		List<Path> listOfFiles = FileUtil.getAllFilesFromDir(dirPath);
		
		// Iterate each input file and build a cart for each input file.
		for(Path filePath : listOfFiles){
			try{
				listOfShoppingCarts.add(buildShoppingCart(FileUtil.readFileLines(filePath)));
			}catch(InputValidationException ive){
				System.out.println("Input data in file : " + filePath.getFileName() + " is invalid. Please verify the format.");
			}
			
		}
		
		return listOfShoppingCarts;
	}
	
	/**
	 * Following method will build a shopping cart from given products data.
	 * @param rawProductListData List containing all purchased products
	 * @return ShoppingCart with list of products
	 */
	public static ShoppingCartInterface buildShoppingCart(List<String> rawProductListData) throws InputValidationException{
		
		ShoppingCartInterface shoppingCart = new ShoppingCart();
		
		// Iterate each line item which consist of product and its purchase detail.
		for(String rawProductData : rawProductListData){
			// Build a product object form raw data and add it into the cart
			if(InputValidator.isInputValid(rawProductData)){
				shoppingCart.addProductToCart(ProductHelper.getStructuredProduct(rawProductData));
			}else{
				throw new InputValidationException("Please enter valid input data");
			}
		}
		
		return shoppingCart;
	}
	
}
