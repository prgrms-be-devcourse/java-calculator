package com.programmers.calculator;

import java.util.List;

public class Calculator {
	
	private final PostfixConversion postfixConversion;
	private final PostfixCalculator postfixCalculator;
	
	public Calculator() {
		postfixConversion = new PostfixConversion();
		postfixCalculator = new PostfixCalculator();
	}
	
	public Integer calculate(Formula formula) {
		List<String> postfix = postfixConversion.changeInfixToPostfix(formula.getInfixListFormula());
		return postfixCalculator.calculatePostfix(postfix);
	}
	
}
