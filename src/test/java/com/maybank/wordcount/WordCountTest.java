/**
 * 
 * @Author: Karimullah_117730 
 * 
 */
package com.maybank.wordcount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maybank.wordcount.service.WordCountService;
import com.maybank.wordcount.service.impl.UniqueWordCountServiceImpl;

/**
 * @author Karimullah Shaik
 *
 */
public class WordCountTest {
	
	@Test
	public void countWords() {
		WordCountService counterService = new UniqueWordCountServiceImpl();
		assertEquals(4l, counterService.count("Mary had a little Lamb"));
		assertEquals(4l, counterService.uniqueCount("Mary had a little Lamb"));
	}
	
	@Test
	public void countWordsWithLeadingAndTrailingSpaces() {
		WordCountService counterService = new UniqueWordCountServiceImpl();
		assertEquals(7l, counterService.count(" There is a ON and off switch for the FAN "));
		assertEquals(7l, counterService.uniqueCount(" There is a ON and off switch for the FAN "));
	}
	
	@Test
	public void countWordsEmptyString() {
		WordCountService counterService = new UniqueWordCountServiceImpl();
		assertEquals(0l, counterService.count(""));
		assertEquals(0l, counterService.uniqueCount(""));
	}
	
	@Test
	public void countWordsWithWhitespaceAndHyphenDelimiter() {
		WordCountService counterService = new UniqueWordCountServiceImpl();
		assertEquals(9l, counterService.count("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
		assertEquals(7l, counterService.uniqueCount("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
	}
	

}
