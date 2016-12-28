package boku.codingtest.print;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PrinterFactoryTest {

	@Test
	public void testGetTaxCalculator(){
		
		PrinterInterface printer = PrinterFactory.getPrinter(PrintType.CONSOLE);
		Assert.assertThat(printer, CoreMatchers.instanceOf(ConsolePrinter.class));
	}
	
}
