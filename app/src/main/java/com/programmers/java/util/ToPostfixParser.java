package com.programmers.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.letter.Letter;

public class ToPostfixParser {

	private Validator validator;

	public ToPostfixParser(Validator validator) {
		this.validator = validator;
	}

	public String[] changeInfixToPostfix(String formula) {
		Stack<String> stack = new Stack<>();
		String[] tokens = formula.split("((?=[-+/*()])|(?<=[-+/*()]))");
		List<String> postfixFormula = new ArrayList<>();

		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];

			if (validator.isOperator(token)) {
				TokenType operator = validator.validateTokenType(token);
				TokenType stackPeek = validator.validateTokenType(stack.peek());
				while (!stack.isEmpty() && ((Letter)operator).haveLowerPriority((Letter)stackPeek)) {
					postfixFormula.add(stack.pop());
				}
				stack.push(token);
			} else if (validator.isOpenBracket(token)) {
				stack.push(token);
			} else if (validator.isCloseBracket(token)) {
				while (!stack.isEmpty() && !validator.isOpenBracket(stack.peek())) {
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
