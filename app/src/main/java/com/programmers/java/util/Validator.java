package com.programmers.java.util;

import java.util.Stack;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.letter.bracket.CloseBracket;
import com.programmers.java.model.token.letter.bracket.OpenBracket;
import com.programmers.java.model.token.letter.operator.DivideOperator;
import com.programmers.java.model.token.letter.operator.MinusOperator;
import com.programmers.java.model.token.letter.operator.MultiplyOperator;
import com.programmers.java.model.token.letter.operator.PlusOperator;
import com.programmers.java.model.token.number.Numbers;

public class Validator {

	public String validateFormula(String formula) throws FormulaInputException {
		String[] tokens = formula.split("((?=[^0-9])|(?<=[^0-9]))");

		try {
			validateTokenIsCorrectType(tokens);
			validateFormulaNotEmpty(tokens);
			validateBracketIsCouple(tokens);
			validateFormulaOrderIsCorrect(tokens);
		} catch (Exception e) {
			throw new FormulaInputException();
		}

		return formula;
	}

	private void validateTokenIsCorrectType(String[] tokens) throws FormulaInputException {
		for (String token : tokens) {
			if (!(isNumber(token)
				|| isOperator(token)
				|| isOpenBracket(token)
				|| isCloseBracket(token))) {
				throw new FormulaInputException();
			}
		}
	}

	private void validateFormulaNotEmpty(String[] tokens) throws FormulaInputException {
		if (tokens == null) {
			throw new FormulaInputException();
		}
	}

	private void validateBracketIsCouple(String[] tokens) throws FormulaInputException {
		Stack<String> openBracketStack = new Stack<>();

		for (String token : tokens) {
			if (isOpenBracket(token)) {
				openBracketStack.push(token);
			} else if (isCloseBracket(token)) {
				if (openBracketStack.isEmpty()) {
					throw new FormulaInputException();
				} else {
					if (isOpenBracket(openBracketStack.peek())) {
						openBracketStack.pop();
					}
				}
			}
		}
		if (!openBracketStack.isEmpty()) {
			throw new FormulaInputException();
		}
	}

	private void validateFormulaOrderIsCorrect(String[] tokens) throws FormulaInputException {
		validateFirstOrderIsCorrect(tokens);
		validateMiddleOrderIsCorrect(tokens);
		validateLastOrderIsCorrect(tokens);
	}

	private void validateFirstOrderIsCorrect(String[] tokens) throws FormulaInputException {
		if (!(isOpenBracket(tokens[0]) || isNumber(tokens[0]))) {
			throw new FormulaInputException();
		}
	}

	private void validateMiddleOrderIsCorrect(String[] tokens) throws FormulaInputException {
		for (int i = 0; i < tokens.length - 1; i++) {
			TokenType curToken = makeTokenType(tokens[i]);
			TokenType nextToken = makeTokenType(tokens[i + 1]);

			if (!curToken.checkNextTokenCorrect(nextToken)) {
				throw new FormulaInputException();
			}
		}
	}

	private void validateLastOrderIsCorrect(String[] tokens) throws FormulaInputException {
		if (!(isNumber(tokens[tokens.length - 1]) || isCloseBracket(tokens[tokens.length - 1]))) {
			throw new FormulaInputException();
		}
	}

	public boolean isNumber(String token) {
		if (Character.isDigit(token.charAt(0))) {
			return true;
		}

		return false;
	}

	public boolean isOperator(String token) {
		if (isPlus(token)
			|| isMinus(token)
			|| isMultiply(token)
			|| isDivide(token)) {
			return true;
		}
		return false;
	}

	public boolean isPlus(String token) {
		if (token.equals("+")) {
			return true;
		}
		return false;
	}

	public boolean isMinus(String token) {
		if (token.equals("-")) {
			return true;
		}
		return false;
	}

	public boolean isMultiply(String token) {
		if (token.equals("*")) {
			return true;
		}
		return false;
	}

	public boolean isDivide(String token) {
		if (token.equals("/")) {
			return true;
		}
		return false;
	}

	public boolean isOpenBracket(String token) {
		if (token.equals("(")) {
			return true;
		}
		return false;
	}

	public boolean isCloseBracket(String token) {
		if (token.equals(")")) {
			return true;
		}
		return false;
	}

	public TokenType makeTokenType(String token) {
		if (isNumber(token)) {
			return new Numbers(token);
		} else if (isPlus(token)) {
			return new PlusOperator(token);
		} else if (isMinus(token)) {
			return new MinusOperator(token);
		} else if (isMultiply(token)) {
			return new MultiplyOperator(token);
		} else if (isDivide(token)) {
			return new DivideOperator(token);
		} else if (isOpenBracket(token)) {
			return new OpenBracket(token);
		} else {
			return new CloseBracket(token);
		}
	}
}
