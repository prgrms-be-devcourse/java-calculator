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

	public String validateFormula(String formula) {
		String[] tokens = formula.split("((?=[^0-9])|(?<=[^0-9]))");

		validateTokenIsCorrectType(tokens);
		validateFormulaNotEmpty(tokens);
		validateBracketIsCouple(tokens);
		validateFormulaOrderIsCorrect(tokens);

		return formula;
	}

	private void validateTokenIsCorrectType(String[] tokens) {
		for (String token : tokens) {
			if (!(Numbers.isNumbers(token)
				|| Operator.isOperator(token)
				|| token.equals("(")
				|| token.equals(")"))) {
				throw new WrongTokenTypeException();
			}
		}
	}

	private void validateFormulaNotEmpty(String[] tokens) {
		if (tokens == null) {
			throw new EmptyFormulaException();
		}
	}

	private void validateBracketIsCouple(String[] tokens) {
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

	private void validateFormulaOrderIsCorrect(String[] tokens) {
		validateFirstOrderIsCorrect(tokens);
		validateMiddleOrderIsCorrect(tokens);
		validateLastOrderIsCorrect(tokens);
	}

	private void validateFirstOrderIsCorrect(String[] tokens) {
		if (!(tokens[0].equals("(") || Numbers.isNumbers(tokens[0]))) {
			throw new WrongTokenOrderException();
		}
	}

	private void validateMiddleOrderIsCorrect(String[] tokens) {
		for (int i = 0; i < tokens.length - 1; i++) {
			TokenType curToken = tokenFactory.createTokenType(tokens[i]);

			if (!curToken.checkNextTokenCorrect(tokens[i + 1])) {
				throw new WrongTokenOrderException();
			}
		}
	}

	private void validateLastOrderIsCorrect(String[] tokens) {
		if (!(Numbers.isNumbers(tokens[tokens.length - 1]) || tokens[tokens.length - 1].equals(")"))) {
			throw new WrongTokenOrderException();
		}
	}
}
