/**
 * 
 * @Author: Karimullah_117730 
 * 
 */
package com.maybank.wordcount.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
		try {
			List<String> stopWords = readStopWordsFromFile("stopwords.txt");
			if(WordCountUtil.checkForEmptyString(text)) {
				return 0;
			}
			String[] parts = WordCountUtil.splitString(text, "[-\\s]");
			collectedWords = Arrays.stream(parts).filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s, stopWords)).collect(Collectors.toList());
			return new HashSet<>(collectedWords).size();
			
		} catch (IOException e) {
			log.info("Exception processing the unique wordcount: " + e.getMessage());
			
		}
		
		return collectedWords.size();
	}

}
