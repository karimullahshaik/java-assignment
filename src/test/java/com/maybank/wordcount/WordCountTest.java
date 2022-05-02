/**
 * 
 * @Author: Karimullah_117730 
 * 
 */
package com.maybank.wordcount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maybank.wordcount.service.WordCountService;
import com.maybank.wordcount.service.impl.WordCountExcludingStopWordsImpl;

/**
 * @author Karimullah Shaik
 *
 */
public class WordCountTest {
	
	@Test
	public void countWords() {
		WordCountService counterService = new WordCountExcludingStopWordsImpl();
		assertEquals(4l, counterService.count("Mary had a little Lamb"));
	}
	
	@Test
	public void countWordsWithLeadingAndTrailingSpaces() {
		WordCountService counterService = new WordCountExcludingStopWordsImpl();
		assertEquals(7l, counterService.count(" There is a ON and off switch for the FAN "));
	}
	
	@Test
	public void countWordsEmptyString() {
		WordCountService counterService = new WordCountExcludingStopWordsImpl();
		assertEquals(0l, counterService.count(""));
	}
	

}
