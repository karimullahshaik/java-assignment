
package com.maybank.wordcount.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.maybank.wordcount.service.WordCountService;
import com.maybank.wordcount.util.WordCountUtil;

/**
 * 
 * @Author: Karimullah Shaik 
 * 
 */
public class WordCountExcludingStopWordsImpl implements WordCountService {
	Logger log = Logger.getLogger(WordCountExcludingStopWordsImpl.class.getName());

	@Override
	public long count(String text) {
		try {
			List<String> stopWords = readStopWordsFromFile("stopwords.txt");
			long count = 0;
			
			if(WordCountUtil.checkForEmptyString(text)) {
				return count;
			}
			String[] parts = text.trim().split("\\s");
			return Arrays.stream(parts).filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s, stopWords)).count();
			
			
		} catch (IOException e) {
			log.info("Exception processing the wordcount: " + e.getMessage());
			
		}
		
		return 0;
	}
	
	private List<String> readStopWordsFromFile(String path) throws IOException {
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
	
	private boolean notAStopWord(String word, List<String> stopwords) {
		return stopwords == null || !stopwords.contains(word);
	}

}
