package com.maybank.wordcount.service;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @Author: Karimullah Shaik
 * Service Interface for Word Count
 * 
 */
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
     * @param text Input String
     * @return average word length in double datatype
     */
    default double averageWordLength(final String text) {
    	return 0.0d;
    }
    
    /**
     * Default implementation for extracting Index words from the Input
     * @param text
     * @return List<String>  List of Index words
     */
    default List<String> extractIndexWords(final String text){
    	return Collections.emptyList();
    }

}
