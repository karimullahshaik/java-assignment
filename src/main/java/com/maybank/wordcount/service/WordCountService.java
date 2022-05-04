package com.maybank.wordcount.service;

/**
 * 
 * @Author: Karimullah Shaik
 * 
 *          Interface for Word Count
 * 
 */
public interface WordCountService {

	/**
	 * Method to retrieve the word count by passing the input String
	 * 
	 * @param text The text to count.
	 */
	long count(final String text);

}
