package com.maybank.wordcount;

import java.util.Scanner;
import com.maybank.wordcount.service.WordCountService;

/**
 * 
 * @Author: Karimullah Shaik 
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
        String input = this.scan.nextLine();
        System.out.println(String.format("Number of Words: %s, Unique: %s; average word length: %s", 
        		this.text.count(input), this.text.uniqueCount(input), this.text.averageWordLenght(input)));
    }

}
