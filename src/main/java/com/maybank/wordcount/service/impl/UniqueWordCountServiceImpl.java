/**
 * 
 * @Author: Karimullah Shaik
 * 
 */
package com.maybank.wordcount.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.maybank.wordcount.util.WordCountUtil;

/**
 * @author Karimullah Shaik
 * Class for Unique word extraction as well as multiple delimiter split (Whitespace, - and exclude stopwords)
 *
 */
public class UniqueWordCountServiceImpl extends WordCountExcludingStopWordsImpl {
	
	private List<String> collectedWords;
	
	@Override
	public long count(String text) {
		try {
			List<String> stopWords = readStopWordsFromFile("stopwords.txt");
			if(WordCountUtil.checkForEmptyString(text)) {
				return 0;
			}
			String[] parts = WordCountUtil.splitString(text, "[-\\s]");
			return Arrays.stream(parts).filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s, stopWords)).count();
			
		} catch (IOException e) {
			log.info("Exception processing the wordcount: " + e.getMessage());
			
		}
		return 0;
		
	}
	
	@Override
	public long uniqueCount(final String text) {
		if(WordCountUtil.checkForEmptyString(text)) {
			return 0;
		}
		return new HashSet<>(collectedWords).size();
			
	}
	
}
