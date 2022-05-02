package com.maybank.wordcount.util;

/**
 * 
 * @Author: Karimullah Shaik 
 * 
 */
public class WordCountUtil {
	
	public static boolean checkForEmptyString(final String text) {
		return text == null || text.isEmpty();
	}
	
	
	public static boolean isWord(final String text) {
		return text.matches("[a-zA-Z]+");
	}

}
