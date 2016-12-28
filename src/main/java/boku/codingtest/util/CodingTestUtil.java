package boku.codingtest.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodingTestUtil {

	/**
	 * Following method will return a RegEx matcher for the given value and RegEx.
	 * @param value Value on which RegEx needs to be applied
	 * @param regEx RegEx
	 * @return Matcher object for the given value and RegEx
	 */
	public static Matcher getRegExMatcher(String value,String regEx){
		Pattern pattern = Pattern.compile(regEx);
		return pattern.matcher(value);
	}
	
	/**
	 * Following method will round to the given value to the nearest value given in increment as per rounding mode.
	 * @param value Value to be rounded
	 * @param increment Increment value to be used in rounding
	 * @param roundingMode Direction of rounding
	 * @return Rounded value
	 */
	public static BigDecimal roundToNearestIncrement(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
		if (increment.signum() == 0) { // Prevent division by 0
			return value;
		} else {
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			BigDecimal result = divided.multiply(increment);
			return result;
		}
	}
}
