package com.maybank.wordcount.service.impl;

import com.maybank.wordcount.service.WordCountService;
import com.maybank.wordcount.util.WordCountUtil;

/**
 * 
 * Simple Word Count Extraction (Iteration 1)
 * Input: Mary had a little lamb
 * Output: 5
 * 
 * @Author: Karimullah_117730 
 * 
 */
public class WordCountServiceImpl implements WordCountService {

	@Override
	public long count(String text) {
		return WordCountUtil.checkForEmptyString(text)?0:text.trim().split(" ").length;
	}

}
