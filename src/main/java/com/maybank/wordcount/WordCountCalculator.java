package com.maybank.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
		
		// request the file name as a command line argument, if no command line argument enter text 
		ScannedWords inputString = null;
		if(args.length == 0) {
			inputString = new ScannedWords(
					new Scanner(System.in),  new WordCountExcludingStopWordsImpl());
		} else {
			inputString = new ScannedWords(
					new Scanner(Files.newInputStream(Paths.get(args[0]))),  new WordCountExcludingStopWordsImpl());
		}
			
		inputString.readAndPrintTheWords();

	}

}
