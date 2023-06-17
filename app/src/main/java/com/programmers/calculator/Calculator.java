package com.programmers.calculator;

import java.util.List;

public class Calculator {
	
	private final PostfixConversion postfixConversion;
	private final PostfixCalculator postfixCalculator;
	
	public Calculator() {
		postfixConversion = new PostfixConversion();
		postfixCalculator = new PostfixCalculator();
	}
	
	public Integer calculate(List<String> infix) {
		List<String> postfix = postfixConversion.changeInfixToPostfix(infix);
		return postfixCalculator.calculatePostfix(postfix);
	}
	
}
