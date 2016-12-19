package boku.codingtest.validation;

import java.util.regex.Pattern;

public class InputValidator {

	/**
	 * Following method will validate each input to make sure the application is able to identify minimum required data to process.
	 * @param input input string
	 * @return Validation indicator
	 */
	public static boolean isInputValid(String input){
		
		boolean isValid = false;
		
		// Verify if the input has at least quantity, name and price
		String regEx = "\\d+.*\\s.+\\s+(at)+\\s+\\d+.*";
		
		if(Pattern.matches(regEx, input)){
			isValid = true;
		}
		
		return isValid;
	}
	
}
