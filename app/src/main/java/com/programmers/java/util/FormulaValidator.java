package com.programmers.java.util;

import java.util.Stack;

import com.programmers.java.exception.EmptyFormulaException;
import com.programmers.java.exception.WrongBracketCountException;
import com.programmers.java.exception.WrongTokenOrderException;
import com.programmers.java.exception.WrongTokenTypeException;
import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.TokenTypeFactory;
import com.programmers.java.model.token.letter.Operator;
import com.programmers.java.model.token.number.Numbers;

public class FormulaValidator {

	TokenTypeFactory tokenFactory;

	public FormulaValidator(TokenTypeFactory tokenFactory) {
		this.tokenFactory = tokenFactory;
	}

	public String validateFormula(String formula) throws
		WrongTokenTypeException,
		EmptyFormulaException,
		WrongBracketCountException,
		WrongTokenOrderException {
		String[] tokens = formula.split("((?=[^0-9])|(?<=[^0-9]))");

		try {
			validateTokenIsCorrectType(tokens);
			validateFormulaNotEmpty(tokens);
			validateBracketIsCouple(tokens);
			validateFormulaOrderIsCorrect(tokens);
		} catch (Exception e) {
			throw e;
		}

		return formula;
	}

	private void validateTokenIsCorrectType(String[] tokens) throws WrongTokenTypeException {
		for (String token : tokens) {
			if (!(Numbers.isNumbers(token)
				|| Operator.isOperator(token)
				|| token.equals("(")
				|| token.equals(")"))) {
				throw new WrongTokenTypeException();
			}
		}
	}

	private void validateFormulaNotEmpty(String[] tokens) throws EmptyFormulaException {
		if (tokens == null) {
			throw new EmptyFormulaException();
		}
	}

	private void validateBracketIsCouple(String[] tokens) throws WrongBracketCountException {
		Stack<String> openBracketStack = new Stack<>();

		for (String token : tokens) {
			if (token.equals("(")) {
				openBracketStack.push(token);
			} else if (token.equals(")")) {
				if (openBracketStack.isEmpty()) {
					throw new WrongBracketCountException();
				} else {
					if (openBracketStack.peek().equals("(")) {
						openBracketStack.pop();
					}
				}
			}
		}
		if (!openBracketStack.isEmpty()) {
			throw new WrongBracketCountException();
		}
	}

	private void validateFormulaOrderIsCorrect(String[] tokens) throws WrongTokenOrderException {
		validateFirstOrderIsCorrect(tokens);
		validateMiddleOrderIsCorrect(tokens);
		validateLastOrderIsCorrect(tokens);
	}

	private void validateFirstOrderIsCorrect(String[] tokens) throws WrongTokenOrderException {
		if (!(tokens[0].equals("(") || Numbers.isNumbers(tokens[0]))) {
			throw new WrongTokenOrderException();
		}
	}

	private void validateMiddleOrderIsCorrect(String[] tokens) throws WrongTokenOrderException {
		for (int i = 0; i < tokens.length - 1; i++) {
			TokenType curToken = tokenFactory.createTokenType(tokens[i]);
			TokenType nextToken = tokenFactory.createTokenType(tokens[i + 1]);

			if (!curToken.checkNextTokenCorrect(nextToken)) {
				throw new WrongTokenOrderException();
			}
		}
	}

	private void validateLastOrderIsCorrect(String[] tokens) throws WrongTokenOrderException {
		if (!(Numbers.isNumbers(tokens[tokens.length - 1]) || tokens[tokens.length - 1].equals(")"))) {
			throw new WrongTokenOrderException();
		}
	}
}
