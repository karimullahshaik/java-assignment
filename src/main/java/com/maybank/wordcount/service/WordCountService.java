/**
 * 
 * @Author: Karimullah_117730 
 * 
 */
package com.maybank.wordcount.service;


public interface WordCountService {
	
   /**
    * Method to retrieve the word count by passing the input String
    * @param text The text to count.
    */
    long count(final String text);

}
