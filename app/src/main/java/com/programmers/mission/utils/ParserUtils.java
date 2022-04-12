package com.programmers.mission.utils;

import java.util.Arrays;
import java.util.List;

public class ParserUtils{

	private static final String CALCULATOR_EXPRESSION_INPUT_POLICY = " ";

	private ParserUtils() {

	}

	public static List<String> getSplitExpression(String expression) {
		return Arrays.stream(expression.split(CALCULATOR_EXPRESSION_INPUT_POLICY)).toList();
	}

}
