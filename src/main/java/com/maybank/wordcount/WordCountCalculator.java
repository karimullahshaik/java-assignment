package com.maybank.wordcount;

import java.util.Scanner;
import com.maybank.wordcount.service.impl.WordCountServiceImpl;

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
	 */
	public static void main(String[] args) {
		final ScannedWords inputString = new ScannedWords(
	            new Scanner(System.in),  new WordCountServiceImpl());
		inputString.readAndPrintTheWords();

	}

}
