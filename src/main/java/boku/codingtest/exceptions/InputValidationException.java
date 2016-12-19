package boku.codingtest.exceptions;

public class InputValidationException extends Exception{

	public InputValidationException(){}
	
	public InputValidationException(String message){
		super(message);
	}
	
	public InputValidationException(Throwable cause){
		super(cause);
	}
	
	public InputValidationException(String message,Throwable cause){
		super(message,cause);
	}
}
