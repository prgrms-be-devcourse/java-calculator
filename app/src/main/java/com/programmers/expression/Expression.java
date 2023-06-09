package com.programmers.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
	
	private List<String> expression;
	
	public Expression(String expression) {
		this.expression = Arrays.stream(expression.split(" "))
			                  .collect(Collectors.toList());
	}
	
	public List<String> getExpression() {
		return expression;
	}
	
	public String toString() {
		return expression.stream()
						.collect(Collectors.joining(" "));
	}
	
}
