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
		assertEquals(4l, counterService.uniqueCount("Mary had a little Lamb"));
		assertEquals(4.25d, counterService.averageWordLength("Mary had a little Lamb"), 0.0d);
	}
	
	@Test
	public void countWordsWithLeadingAndTrailingSpaces() {
		WordCountService counterService = new WordCountExcludingStopWordsImpl();
		assertEquals(7l, counterService.count(" There is a ON and off switch for the FAN "));
		assertEquals(7l, counterService.uniqueCount(" There is a ON and off switch for the FAN "));
		assertEquals(3.43d, counterService.averageWordLength(" There is a ON and off switch for the FAN "), 0.0d);
	}
	
	@Test
	public void countWordsEmptyString() {
		WordCountService counterService = new WordCountExcludingStopWordsImpl();
		assertEquals(0l, counterService.count(""));
		assertEquals(0l, counterService.uniqueCount(""));
		assertEquals(0.0d, counterService.averageWordLength(""), 0.0d);
	}
	
	@Test
	public void countWordsWithWhitespaceAndHyphenDelimiter() {
		WordCountService counterService = new WordCountExcludingStopWordsImpl();
		assertEquals(7l, counterService.count("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
		assertEquals(6l, counterService.uniqueCount("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
		assertEquals(6.71d, counterService.averageWordLength("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), 0.0d);
	}
	

}
