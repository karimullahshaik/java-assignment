package com.maybank.wordcount.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.maybank.wordcount.util.WordCountUtil;

/**
 * @author Karimullah Shaik
 * Class for Unique word extraction as well as multiple delimiter split (Whitespace, - and exclude stopwords)
 *
 */
public class UniqueWordCountServiceImpl extends WordCountExcludingStopWordsImpl {
	
	static List<String> stopWords;
	
	static {
		try {
			stopWords = readStopWordsFromFile("stopwords.txt");
		} catch (IOException e) {
			log.info("Exception processing the wordcount: " + e.getMessage());
		}
	}
	
	@Override
	public long count(String text) {
			if(WordCountUtil.checkForEmptyString(text)) {
				return 0;
			}
			String[] parts = WordCountUtil.splitString(text, "[-\\s]");
			return Arrays.stream(parts).filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s)).count();
	}
	
	@Override
	public long uniqueCount(final String text) {
			if(WordCountUtil.checkForEmptyString(text)) {
				return 0;
			}
			String[] parts = WordCountUtil.splitString(text, "[-\\s]");
			return Arrays.stream(parts).filter(s -> WordCountUtil.isWord(s))
					.filter(s -> notAStopWord(s)).distinct().count();
	}

}
