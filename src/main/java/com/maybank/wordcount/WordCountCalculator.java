package com.maybank.wordcount;

import java.io.IOException;
import java.util.Scanner;

import com.maybank.wordcount.service.impl.UniqueWordCountServiceImpl;

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
	public static void main(String[] args) {
		
		ScannedWords inputString = new ScannedWords(
					new Scanner(System.in),  new UniqueWordCountServiceImpl());
		inputString.readAndPrintTheWords();

	}

}
