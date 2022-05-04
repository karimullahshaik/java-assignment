
package com.maybank.wordcount.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
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
 *          Service Implementation Class to count the words excluding the
 *          specified stop words read from the file.
 * 
 */
public class WordCountExcludingStopWordsImpl implements WordCountService {
	static Logger log = Logger.getLogger(WordCountExcludingStopWordsImpl.class.getName());

	static List<String> stopWords;

	private static final String DELIMITER_FOR_WORD_SPLIT = "\\s";

	static {
		try {
			stopWords = readStopWordsFromFile("stopwords.txt");
		} catch (IOException e) {
			log.info("Exception processing the wordcount: " + e.getMessage());
		}
	}

	@Override
	public long count(String text) {
		if (WordCountUtil.checkForEmptyString(text)) {
			return 0;
		}
		String[] parts = WordCountUtil.splitString(text, DELIMITER_FOR_WORD_SPLIT);
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

	protected boolean notAStopWord(String word) {
		return stopWords == null || !stopWords.contains(word);
	}

	@Override
	public long uniqueCount(final String text) {
		if (WordCountUtil.checkForEmptyString(text)) {
			return 0;
		}
		String[] parts = WordCountUtil.splitString(text, DELIMITER_FOR_WORD_SPLIT);
		return Arrays.stream(parts).filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s)).distinct()
				.count();
	}

	@Override
	public double averageWordLength(String text) {
		if (WordCountUtil.checkForEmptyString(text)) {
			return 0;
		}
		long totalCollectedWords = Arrays.stream(WordCountUtil.splitString(text, DELIMITER_FOR_WORD_SPLIT))
				.filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s)).count();
		
		double totalLengthOfWords = Arrays.stream(WordCountUtil.splitString(text, DELIMITER_FOR_WORD_SPLIT))
				.filter(s -> WordCountUtil.isWord(s)).filter(s -> notAStopWord(s)).map(String::length)
				.reduce(0, (a, b) -> a + b).doubleValue();

		return WordCountUtil.roundToTwoDecimalPlaces((totalLengthOfWords / totalCollectedWords), 2,
				RoundingMode.HALF_UP);
	}

}
