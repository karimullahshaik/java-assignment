/**
 * 
 * @Author: Karimullah Shaik
 * 
 */
package com.maybank.wordcount.service;


public interface WordCountService {
	
   /**
    * Method to retrieve the word count by passing the input String
    * @param text The text to count.
    */
    long count(final String text);
    
    /**
     * Default Method to retrieve the unique word count by passing the input String
     * @param text The text to count.
     */
    default long uniqueCount(final String text) {
    	return 0l;
    }
    
    /**
     * 
     * @param text
     * @return average word length in double datatype
     */
    default double averageWordLength(final String text) {
    	return 0.0d;
    }

}
