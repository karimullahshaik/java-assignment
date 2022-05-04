package com.maybank.wordcount.util;

/**
 * 
 * @Author: Karimullah Shaik Utility Class for Word Count
 * 
 */
public class WordCountUtil {
	
	/**
	 * 
	 * @param text
	 * @return boolean (true -> if the text is null or empty; false -> if the text
	 *         is not empty)
	 */
	public static boolean checkForEmptyString(final String text) {
		return text == null || text.isEmpty();
	}
	
	/**
	 * 
	 * @param text
	 * @return boolean (true -> if text param have characters containing the regex
	 *         a-z, A-Z, . and -)
	 */
	public static boolean isWord(final String text) {
		return text.matches("[a-zA-Z.]+");
	}
	
	
	/**
	 * 
	 * @param text
	 * @param delimiter
	 * @return String[] String split by the delimiter set passed.
	 */
	public static String[] splitString(String text, String delimiter) {
		return text.trim().split(delimiter);
	}

}
