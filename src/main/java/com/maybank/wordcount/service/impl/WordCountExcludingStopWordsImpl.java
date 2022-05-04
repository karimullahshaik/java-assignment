
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
 *          Service Implementation Class to count the words excluding the
 *          specified stop words read from the file.
 * 
 */
public class WordCountExcludingStopWordsImpl implements WordCountService {
	static Logger log = Logger.getLogger(WordCountExcludingStopWordsImpl.class.getName());

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
		long count = 0;
		if (WordCountUtil.checkForEmptyString(text)) {
			return count;
		}
		String[] parts = text.trim().split("\\s");
		return Arrays.stream(parts).filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s)).count();

	}

	
	protected static List<String> readStopWordsFromFile(String path) throws IOException {
		File file = new File(WordCountExcludingStopWordsImpl.class.getClassLoader().getResource(path).getFile());
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
	
	/**
	 * 
	 * @param word Input Word
	 * @return true/false based on the input passed.
	 */
	protected boolean notAStopWord(String word) {
		return stopWords == null || !stopWords.contains(word);
	}
	

}
