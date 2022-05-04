
package com.maybank.wordcount.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.maybank.wordcount.service.WordCountService;
import com.maybank.wordcount.util.WordCountUtil;

/**
 * 
 * @Author: Karimullah Shaik 
 * 
 */
public class WordCountExcludingStopWordsImpl implements WordCountService {
	Logger log = Logger.getLogger(WordCountExcludingStopWordsImpl.class.getName());
	
	private List<String> stopWords;
	
	private List<String> collectedWords;
	
	private static final String DELIMITER_FOR_WORD_SPLIT = "\\s";

	@Override
	public long count(String text) {
		try {
			if(WordCountUtil.checkForEmptyString(text)) {
				return 0;
			}
			stopWords = readStopWordsFromFile("stopwords.txt");
			String[] parts = WordCountUtil.splitString(text, DELIMITER_FOR_WORD_SPLIT);
			collectedWords = Arrays.stream(parts).filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s, stopWords)).collect(Collectors.toList());
			return collectedWords.size();
			
		} catch (IOException e) {
			log.info("Exception processing the wordcount: " + e.getMessage());
			
		}
		return 0;
	}
	
	protected List<String> readStopWordsFromFile(String path) throws IOException {
		File file = new File(getClass().getClassLoader().getResource(path).getFile());
		FileReader fileReader = new FileReader(file);
		try (BufferedReader br = new BufferedReader(fileReader)) {
			String line;
			List<String> excludedStopWords = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				excludedStopWords.add(line);
			}
			return excludedStopWords;
		}
	}
	
	protected boolean notAStopWord(String word, List<String> stopwords) {
		return stopwords == null || !stopwords.contains(word);
	}
	
	
	@Override
	public long uniqueCount(final String text) {
		if(WordCountUtil.checkForEmptyString(text)) {
			return 0;
		}
		return new HashSet<>(collectedWords).size();
	}
	
	@Override
	public double averageWordLenght(String text) {
		if(WordCountUtil.checkForEmptyString(text)) {
			return 0;
		}
		double totalLengthOfWords = Arrays.stream(WordCountUtil.splitString(text, DELIMITER_FOR_WORD_SPLIT)).filter(s->
		WordCountUtil.isWord(s))
        .filter(s-> notAStopWord(s, stopWords))
        .map(String::length).reduce(0, (a,b) -> a+b).doubleValue();
		
		return totalLengthOfWords/collectedWords.size();
	}

}
