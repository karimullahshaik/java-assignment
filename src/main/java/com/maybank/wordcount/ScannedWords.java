package com.maybank.wordcount;

import java.util.Scanner;
import com.maybank.wordcount.service.WordCountService;

/**
 * 
 * @Author: Karimullah_117730 
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
     * @param scan Given scanner
     * @param .
     */
    public ScannedWords(final Scanner scan, final WordCountService serviceInstance) {
        this.scan = scan;
        this.text = serviceInstance;
    }


    public void readAndPrintTheWords() {
    	System.out.println("Enter Input: ");
        String input = this.scan.nextLine();
        System.out.println("Number of Words: " + this.text.count(input));
    }

}
