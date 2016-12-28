package boku.codingtest.validation;

import boku.codingtest.validation.InputValidator;

import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTest {

	@Test
	public void testIsInputValid(){
		
		// Valid Inputs
		Assert.assertEquals(true, InputValidator.isInputValid("1 book at 12.49"));
		Assert.assertEquals(true, InputValidator.isInputValid("1 music CD at 14.99"));
		Assert.assertEquals(true, InputValidator.isInputValid("1 chocolate bar at 0.85"));
		Assert.assertEquals(true, InputValidator.isInputValid("1 imported box of chocolates at 10.00"));
		Assert.assertEquals(true, InputValidator.isInputValid("1 imported bottle of perfume at 47.50"));
		Assert.assertEquals(true, InputValidator.isInputValid("1 imported bottle of perfume at 27.99"));
		Assert.assertEquals(true, InputValidator.isInputValid("1 bottle of perfume at 18.99"));
		Assert.assertEquals(true, InputValidator.isInputValid("1 packet of headache pills at 9.75"));
		Assert.assertEquals(true, InputValidator.isInputValid("1 box of imported chocolates at 11.25"));
		
		// Invalid Inputs
		Assert.assertEquals(false, InputValidator.isInputValid("box of imported chocolates at 11.25"));
		Assert.assertEquals(false, InputValidator.isInputValid("1 box of imported chocolates at "));
		Assert.assertEquals(false, InputValidator.isInputValid("1 box of imported chocolates 11.25"));
	}
	
}
