package com.programmers.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.Letter;

public class FormulaParser {

	private Validator validator;

	public FormulaParser(Validator validator) {
		this.validator = validator;
	}

	public String[] changeInfixToPostfix(String formula) {
		Stack<String> stack = new Stack<>();
		String[] tokens = formula.split("((?=[-+/*()])|(?<=[-+/*()]))");
		List<String> postfixFormula = new ArrayList<>();

		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];

			if (validator.isOperator(token)) {
				Token operator = validator.validateCorrectToken(token);
				Token stackPeek = validator.validateCorrectToken(stack.peek());
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
