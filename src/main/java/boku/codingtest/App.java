package boku.codingtest;

import boku.codingtest.util.AppLogger;

/**
 * This is an entry class to the App which consist of main method to execute this App.
 * @author darshan
 *
 */
public class App {
		
	private static final AppLogger appLogger = AppLogger.getLogger(App.class);
	
	/**
	 * Main Method to execute the program
	 * @param args
	 */
    public static void main(String[] args){
    	
        appLogger.debug("Receipt Print App Started");
        
        
        
        appLogger.debug("Receipt Print App Ends");
    }
}
