package boku.codingtest.print;

public class PrinterFactory {

	private PrinterFactory(){}
	
	/**
	 * Following method will get an object of the printer based on provided print type.
	 * @param printType Print Type
	 * @return Printer object
	 */
	public static PrinterInterface getPrinter(PrintType printType){
		PrinterInterface printInterface = null;
		
		if(printType == PrintType.CONSOLE){
			printInterface = new ConsolePrinter();
		}
		return printInterface;
	}
	
}
