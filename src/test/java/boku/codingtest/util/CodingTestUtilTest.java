package boku.codingtest.util;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;


public class CodingTestUtilTest {

	@Test
	public void testRoundToNearestIncrement(){
		
		Assert.assertEquals(new BigDecimal("6.60"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.565"), new BigDecimal("0.05"), RoundingMode.UP));
		Assert.assertEquals(new BigDecimal("4.60"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("4.587"), new BigDecimal("0.05"), RoundingMode.UP));
		Assert.assertEquals(new BigDecimal("6.55"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.545"), new BigDecimal("0.05"), RoundingMode.UP));
		Assert.assertEquals(new BigDecimal("12.35"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("12.3456"), new BigDecimal("0.05"), RoundingMode.UP));
		Assert.assertEquals(new BigDecimal("6.55"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.55"), new BigDecimal("0.05"), RoundingMode.UP));
		Assert.assertEquals(new BigDecimal("6.60"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.556"), new BigDecimal("0.05"), RoundingMode.UP));
		Assert.assertEquals(new BigDecimal("6.60"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.60"), new BigDecimal("0.05"), RoundingMode.UP));
		
		Assert.assertEquals(new BigDecimal("6.55"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.565"), new BigDecimal("0.05"), RoundingMode.HALF_UP));
		Assert.assertEquals(new BigDecimal("4.60"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("4.587"), new BigDecimal("0.05"), RoundingMode.HALF_UP));
		Assert.assertEquals(new BigDecimal("6.55"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.545"), new BigDecimal("0.05"), RoundingMode.HALF_UP));
		Assert.assertEquals(new BigDecimal("12.35"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("12.3456"), new BigDecimal("0.05"), RoundingMode.HALF_UP));
		Assert.assertEquals(new BigDecimal("6.55"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.55"), new BigDecimal("0.05"), RoundingMode.HALF_UP));
		Assert.assertEquals(new BigDecimal("6.55"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.556"), new BigDecimal("0.05"), RoundingMode.HALF_UP));
		Assert.assertEquals(new BigDecimal("6.60"),CodingTestUtil.roundToNearestIncrement(new BigDecimal("6.60"), new BigDecimal("0.05"), RoundingMode.HALF_UP));
		
	}
	
	@Test
	public void testGetRegExMatcher(){
		Assert.assertThat(CodingTestUtil.getRegExMatcher("test", "(a-z)"), CoreMatchers.instanceOf(Matcher.class));
	}
	
}
