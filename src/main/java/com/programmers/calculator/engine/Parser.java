package com.programmers.calculator.engine;

import java.util.Objects;
import java.util.regex.Pattern;

public class Parser {
	private static final String NUM_GAP_PATTERN = "(\\d+\\s(\\+|\\-|\\*|\\%)\\s)";
	private static final String FORMULA_PATTERN = NUM_GAP_PATTERN + "+\\d+";

	/**
	 * 정규표현식을 통해 입력값을 겁사해서 패턴과 맞는지 판단하는 메서드
	 *
	 * @param formula
	 * @return 입력된 값이 formula 패턴과 일치하면 true, 불일치하면 false
	 */
	public static boolean parse(String formula) {
		Objects.requireNonNull(formula);

		return Pattern.matches(FORMULA_PATTERN, formula);
	}

}
