/**
 * 
 * @Author: Karimullah Shaik
 * 
 */
package com.maybank.wordcount.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.maybank.wordcount.util.WordCountUtil;

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
    
    default double averageWordLength(final String text) {
    	return 0.0d;
    }
    
    default List<String> extractIndexWords(final String text){
    	return Collections.emptyList();
    }

}
