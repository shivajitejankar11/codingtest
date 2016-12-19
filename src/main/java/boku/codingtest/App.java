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
    
    List<ShoppingCartInterface> listOfShoppingCarts = ShoppingCartHelper.buildShoppingCarts(args[0]); 
    
    int index = 1;
    for(ShoppingCartInterface shoppingCart : listOfShoppingCarts){
    	System.out.println("\nOutput : " + index++ + "\n");
    	shoppingCart.printReceipt(PrintType.CONSOLE);
    }
    
    appLogger.debug("Receipt Print App Ends");
  }
}
