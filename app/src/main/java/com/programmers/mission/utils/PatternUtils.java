package com.programmers.mission.utils;

import java.util.regex.Pattern;

public class PatternUtils {

	private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");
	private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+*\\-/]");

	private PatternUtils() {

	}

	public static boolean isNumeric(String number) {
		return NUMERIC_PATTERN.matcher(number).matches();
	}

	public static boolean isOperator(String operator) {
		return OPERATOR_PATTERN.matcher(operator).matches();
	}

}
