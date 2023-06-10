package com.programmers.expression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
	
	private List<String> expression;
	
	public Expression(String expression) {
		isValid(expression);
		this.expression = Arrays.stream(expression.split(" "))
			                  .collect(Collectors.toList());
	}
	
	public List<String> getExpression() {
		return expression;
	}
	
	public void isValid(String expression) {
		if (!expression.matches("([0-9] [+|-|*|/] )+[0-9]")) throw new IllegalArgumentException();
	}
	
	public String toString() {
		return expression.stream()
						.collect(Collectors.joining(" "));
	}
	
}
