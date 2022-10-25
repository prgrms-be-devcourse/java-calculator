package com.programmers.java.util;

import java.util.Stack;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.CloseBracket;
import com.programmers.java.model.token.letter.bracket.OpenBracket;
import com.programmers.java.model.token.letter.operator.DivideOperator;
import com.programmers.java.model.token.letter.operator.MinusOperator;
import com.programmers.java.model.token.letter.operator.MultiplyOperator;
import com.programmers.java.model.token.letter.operator.PlusOperator;
import com.programmers.java.model.token.number.Number;

public class Validator {

	public String validateFormula(String formula) throws FormulaInputException {
		String[] tokens = formula.split("((?=[^0-9])|(?<=[^0-9]))");

		if (validateTokenIsCorrectLetter(tokens)
			&& validateFormulaNotEmpty(tokens)
			&& validateBracketIsCouple(tokens)
			&& validateFormulaOrderIsCorrect(tokens)) {
			return formula;
		}
		throw new FormulaInputException();
	}

	private boolean validateTokenIsCorrectLetter(String[] tokens) {
		for (String token : tokens) {
			if (!(isNumber(token)
				|| isOperator(token)
				|| isOpenBracket(token)
				|| isCloseBracket(token))) {
				return false;
			}
		}
		return true;
	}

	private boolean validateFormulaNotEmpty(String[] tokens) {
		if (tokens == null) {
			return false;
		}
		return true;
	}

	private boolean validateBracketIsCouple(String[] tokens) {
		Stack<String> openBracketStack = new Stack<>();

		for (String token : tokens) {
			if (isOpenBracket(token)) {
				openBracketStack.push(token);
			} else if (isCloseBracket(token)) {
				if (openBracketStack.isEmpty()) {
					return false;
				} else {
					if (isOpenBracket(openBracketStack.peek())) {
						openBracketStack.pop();
					}
				}
			}
		}
		if (!openBracketStack.isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean validateFormulaOrderIsCorrect(String[] tokens) {
		return validateFirstTokenIsCorrect(tokens)
			&& validateMiddleTokenIsCorrect(tokens)
			&& validateLastTokenIsCorrect(tokens);
	}

	private boolean validateMiddleTokenIsCorrect(String[] tokens) {
		for (int i = 0; i < tokens.length - 1; i++) {
			Token curToken = validateCorrectToken(tokens[i]);
			Token nextToken = validateCorrectToken(tokens[i + 1]);

			if (!curToken.checkNextTokenCorrect(nextToken)) {
				return false;
			}
		}
		return true;
	}

	private boolean validateFirstTokenIsCorrect(String[] tokens) {
		if (isOpenBracket(tokens[0]) || isNumber(tokens[0])) {
			return true;
		}
		return false;
	}

	private boolean validateLastTokenIsCorrect(String[] tokens) {
		if (isNumber(tokens[tokens.length - 1]) || isCloseBracket(tokens[tokens.length - 1])) {
			return true;
		}
		return false;
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

	public Token validateCorrectToken(String token) {
		if (isNumber(token)) {
			return new Number(token);
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
