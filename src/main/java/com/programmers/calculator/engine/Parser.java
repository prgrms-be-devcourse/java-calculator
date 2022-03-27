package com.programmers.calculator.engine;

import java.util.regex.Pattern;

public class Parser {
	private static final String NUM_GAP = "(\\d+\\s(\\+|\\-|\\*|\\%)\\s)";
	private static final String REGREX =  NUM_GAP + "+\\d+";

	public static boolean parse(String str){
		return Pattern.matches(REGREX, str);
	}

}
