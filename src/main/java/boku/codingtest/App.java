package boku.codingtest;



import boku.codingtest.print.PrintType;
import boku.codingtest.shoppingcart.ShoppingCartHelper;
import boku.codingtest.shoppingcart.ShoppingCartInterface;
import boku.codingtest.util.AppLogger;


import java.util.List;


/**
 * This is an entry class to the App which consist of main method to execute this App.
 * @author darshan
 *
 */
public class App {

  private static final AppLogger appLogger = AppLogger.getLogger(App.class);

  /**Main Method to execute the program.
   * @param args Program arguments
   */
  public static void main(String[] args) {
	  
    appLogger.debug("Receipt Print App Started");
    
    // Validate if minimum required arguments are provided to the program or not
    if(args.length < 1) { 
      throw new RuntimeException("Please enter input file directory path");
    }
    
    // Build shopping carts from each of the input file available in provided input directory
    List<ShoppingCartInterface> listOfShoppingCarts = ShoppingCartHelper.buildShoppingCarts(args[0]); 
    
    // Iterate over all built carts and print receipt for each of them
    int index = 1;
    for(ShoppingCartInterface shoppingCart : listOfShoppingCarts){
    	System.out.println("\nOutput : " + index++ + "\n");
    	shoppingCart.printReceipt(PrintType.CONSOLE);
    }
    
    // If the directory is empty and no shopping cart has been built then print the message.
    if(listOfShoppingCarts == null || listOfShoppingCarts.size() == 0){
    	System.out.println("No receipt to print at this time.");
    }
    
    appLogger.debug("Receipt Print App Ends");
  }
}
