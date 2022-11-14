package com.programmers.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.programmers.java.model.token.TokenTypeFactory;
import com.programmers.java.model.token.letter.Letter;
import com.programmers.java.model.token.letter.Operator;

public class PostfixParser {
	TokenTypeFactory tokenFactory;

	public PostfixParser(TokenTypeFactory tokenFactory) {
		this.tokenFactory = tokenFactory;
	}

	public String[] changeInfixToPostfix(String formula) {
		Stack<String> stack = new Stack<>();
		String[] tokens = formula.split("((?=[-+/*()])|(?<=[-+/*()]))");
		List<String> postfixFormula = new ArrayList<>();

		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];

			if (Operator.isOperator(token)) {
				Operator operator = Operator.getOperatorType(token);
				while (!stack.isEmpty() && operator.haveLowerPriority(
					(Letter)(tokenFactory.createTokenType(stack.peek())))) {
					postfixFormula.add(stack.pop());
				}
				stack.push(token);
			} else if (token.equals("(")) {
				stack.push(token);
			} else if (token.equals(")")) {
				while (!stack.isEmpty() && !(stack.peek()).equals("(")) {
					postfixFormula.add(stack.pop());
				}
				stack.pop();
			} else {
				postfixFormula.add(token);
			}
		}

		while (!stack.isEmpty()) {
			postfixFormula.add(stack.pop());
		}

		return postfixFormula.toArray(String[]::new);
	}
}
