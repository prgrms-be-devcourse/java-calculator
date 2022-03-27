package com.programmers.calculator.engine;

import java.util.Objects;
import java.util.regex.Pattern;

public class Parser {
	private static final String NUM_GAP_PATTERN = "(\\d+\\s(\\+|\\-|\\*|\\%)\\s)";
	private static final String FORMULA_PATTERN = NUM_GAP_PATTERN + "+\\d+";

	public static boolean parse(String formula) {
		Objects.requireNonNull(formula);

		return Pattern.matches(FORMULA_PATTERN, formula);
	}

}
