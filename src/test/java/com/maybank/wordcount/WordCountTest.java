/**
 * 
 * @Author: Karimullah_117730 
 * 
 */
package com.maybank.wordcount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maybank.wordcount.service.WordCountService;
import com.maybank.wordcount.service.impl.WordCountServiceImpl;

/**
 * @author Karimullah Shaik
 *
 */
public class WordCountTest {
	
	@Test
	public void countWords() {
		WordCountService counterService = new WordCountServiceImpl();
		assertEquals(5l, counterService.count("Mary had a little Lamb"));
	}
	
	@Test
	public void countWordsWithLeadingAndTrailingSpaces() {
		WordCountService counterService = new WordCountServiceImpl();
		assertEquals(5l, counterService.count(" Mary had a little Lamb "));
	}
	
	@Test
	public void countWordsEmptyString() {
		WordCountService counterService = new WordCountServiceImpl();
		assertEquals(5l, counterService.count(""));
	}
	

}
