package com.maybank.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.maybank.wordcount.service.impl.UniqueWordCountServiceImpl;
import com.maybank.wordcount.service.impl.WordCountExcludingStopWordsImpl;

/**
 * 
 * @Author: Karimullah Shaik 
 * 
 * Program Entry point for Word Count Kata
 * 
 */
public class WordCountCalculator {

	/**
	 * Main Method for the program to calculate the word count
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		if(args.length == 0) {
			System.err.println("Please Pass the Absolute path of the File to process the word count.");
			System.exit(0);
		}
		
		final ScannedWords inputString = new ScannedWords(
				new Scanner(Files.newInputStream(Paths.get(args[0]))),  new WordCountExcludingStopWordsImpl());
		inputString.readAndPrintTheWords();

	}

}
