package com.maybank.wordcount;

import java.util.Scanner;
import com.maybank.wordcount.service.WordCountService;

/**
 * 
 * @Author: Karimullah Shaik
 * 
 *          Class for Reading the Input (Both Keyboard & File Input) and
 *          instantiate the service Implementation object.
 * 
 */
public final class ScannedWords {

	/**
	 * Scanner class to read the Input.
	 */
	private final Scanner scan;

	/**
	 * The Service Implementation to use.
	 */
	private WordCountService text;

	/**
	 * Constructor.
	 * 
	 * @param scan            Given scanner
	 * @param serviceInstance serviceImplementation Reference.
	 */
    public ScannedWords(final Scanner scan, final WordCountService serviceInstance) {
        this.scan = scan;
        this.text = serviceInstance;
    }

    /**
     * Method to Read the Input and Print the required output as per the Service Instance passed
     * 
     */
    public void readAndPrintTheWords() {
        String input = this.scan.nextLine();
        System.out.println(String.format("Number of Words: %s, Unique: %s; average word length: %s characters", 
        		this.text.count(input), this.text.uniqueCount(input), this.text.averageWordLength(input)));
    }
    
    /**
     * 
     * @param optionalPrintIndexes Optional parameter to Print/Not Printing the Index Words from the given input.
     * 
     */
    public void readAndPrintTheWordsOptionalIndexes(boolean optionalPrintIndexes) {
        String input = this.scan.nextLine();
        System.out.println(String.format("Number of Words: %s, Unique: %s; average word length: %s characters", 
        		this.text.count(input), this.text.uniqueCount(input), this.text.averageWordLength(input)));
        
        if(optionalPrintIndexes) {
        	System.out.println("Index: ");
        	this.text.extractIndexWords(input).forEach(System.out::println);
        }
    }

}
