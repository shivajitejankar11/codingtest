package boku.codingtest.product;


import boku.codingtest.product.ProductDefinition.ProductType;
import boku.codingtest.product.ProductHelper;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class ProductHelperTest {

	@Test
	public void testParseName(){
		Assert.assertEquals("book", ProductHelper.parseName("1 book at 12.49"));
		Assert.assertEquals("music CD", ProductHelper.parseName("1 music CD at 14.99"));
		Assert.assertEquals("chocolate bar", ProductHelper.parseName("1 chocolate bar at 0.85"));
		Assert.assertEquals("imported box of chocolates", ProductHelper.parseName("1 imported box of chocolates at 10.00"));
	}
	
	@Test
	public void testParseQuantity(){
		Assert.assertEquals(1, ProductHelper.parseQuantity("1 book at 12.49"));
		Assert.assertEquals(1, ProductHelper.parseQuantity("1 music CD at 14.99"));
		Assert.assertEquals(1543, ProductHelper.parseQuantity("1543 chocolate bar at 0.85"));
		Assert.assertEquals(1, ProductHelper.parseQuantity("1 imported box of chocolates at 10.00"));
	}
	
	@Test
	public void testParseProductType(){
		Assert.assertEquals(ProductType.BOOK, ProductHelper.parseProductType("1 book at 12.49"));
		Assert.assertEquals(ProductType.BOOK, ProductHelper.parseProductType("1 BoOK at 12.49"));
		Assert.assertEquals(ProductType.FOOD, ProductHelper.parseProductType("1543 chocolate bar at 0.85"));
		Assert.assertEquals(ProductType.FOOD, ProductHelper.parseProductType("1 imported box of chocolates at 10.00"));
		Assert.assertEquals(ProductType.MEDICAL, ProductHelper.parseProductType("1 packet of headache pills at 9.75"));
	}
	
	@Test
	public void testParseIsImported(){
		Assert.assertEquals(false, ProductHelper.parseIsImported("1 book at 12.49"));
		Assert.assertEquals(false, ProductHelper.parseIsImported("1 BoOK at 12.49"));
		Assert.assertEquals(false, ProductHelper.parseIsImported("1543 chocolate bar at 0.85"));
		Assert.assertEquals(true, ProductHelper.parseIsImported("1 imported box of chocolates at 10.00"));
		Assert.assertEquals(false, ProductHelper.parseIsImported("1 packet of headache pills at 9.75"));
		Assert.assertEquals(true, ProductHelper.parseIsImported("1 box of imported chocolates at 11.25"));
	}
	
	@Test
	public void testParseCostBeforeTax(){
		Assert.assertEquals(new BigDecimal("12.49"), ProductHelper.parseCostBeforeTax("1 book at 12.49"));
	}
}
