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


    public void readAndPrintTheWords() {
    	System.out.println("Enter Input: ");
        String input = this.scan.nextLine();
        System.out.println(String.format("Number of Words: %s, Unique: %s", this.text.count(input), this.text.uniqueCount(input)));
    }

}
