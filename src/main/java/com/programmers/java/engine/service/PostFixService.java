package com.programmers.java.engine.service;

import java.util.Stack;

public class PostFixService {
	public String[] makePostFixFormula(String validFormula) {
		Stack<String> operatorStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		String[] separatedBySpaces = validFormula.split(" ");

		for (int i = 0; i < separatedBySpaces.length; i++) {
			String str = separatedBySpaces[i];

			if (i % 2 == 0) {
				sb.append(str).append(" ");
				continue;
			}
			if (operatorStack.isEmpty()) {
				operatorStack.push(str);

				continue;
			}

			if (checkPriority(str) >= checkPriority(operatorStack.peek())) {
				reverseOperator(sb, operatorStack, str);
				operatorStack.push(str);

				continue;
			}
			operatorStack.push(str);
		}

		while (!operatorStack.isEmpty()) {
			sb.append(operatorStack.pop()).append(" ");
		}

		return sb.toString().split(" ");
	}

	private void reverseOperator(StringBuilder sb, Stack<String> operatorStack, String str) {
		while (!operatorStack.isEmpty() && checkPriority(str) >= checkPriority(operatorStack.peek())) {
			sb.append(operatorStack.pop()).append(" ");
		}
	}

	public int checkPriority(String operator) {
		int priority = 0;
		switch (operator) {
			case "+":
			case "-": {
				priority = 2;
				break;
			}
			case "*":
			case "/": {
				priority = 1;
				break;
			}
			default:
				throw new IllegalStateException("Unexpected Operator: " + operator);
		}

		return priority;
	}
}