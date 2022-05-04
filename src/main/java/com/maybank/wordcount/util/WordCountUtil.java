package com.maybank.wordcount.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @Author: Karimullah Shaik 
 * Utility Class for Word Count 
 * 
 */
public class WordCountUtil {
	
	/**
	 * 
	 * @param text
	 * @return boolean (true -> if the text is null or empty; false -> if the text is not empty)
	 */
	public static boolean checkForEmptyString(final String text) {
		return text == null || text.isEmpty();
	}
	
	/**
	 * 
	 * @param text
	 * @return boolean (true -> if text param have characters containing the regex a-z, A-Z, . and -)
	 */
	public static boolean isWord(final String text) {
		return text.matches("[a-zA-Z.-]+");
	}
	
	/**
	 * 
	 * @param text
	 * @param delimiter
	 * @return Array of String objects
	 */
	public static String[] splitString(String text, String delimiter) {
		return text.trim().split(delimiter);
	}
	
	
	/**
	 * 
	 * @param inputNumber - Number to be rounded
	 * @param scalingDecimals - Digits required after decimal point
	 * @param mode - Rounding Algorithm required
	 * @return Calculated Rounded value based on the Rounding mode, digits
	 */
	public static double roundToTwoDecimalPlaces(double inputNumber, int scalingDecimals, RoundingMode mode) {
		BigDecimal bd = new BigDecimal(Double.toString(inputNumber));
        bd = bd.setScale(scalingDecimals, mode);
        return bd.doubleValue();
	}

}
