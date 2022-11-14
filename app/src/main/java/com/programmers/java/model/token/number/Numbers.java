package com.programmers.java.model.token.number;

import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.letter.Operator;

public class Numbers implements TokenType {

	private String value;

	public Numbers(String value) {
		this.value = value;
	}

	public static boolean isNumbers(String token) {
		if (!token.equals("") && token.chars().allMatch(Character::isDigit)) {
			return true;
		}
		return false;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public boolean checkNextTokenCorrect(String nextToken) {
		if (Operator.isOperator(nextToken) || nextToken.equals(")")) {
			return true;
		} else {
			return false;
		}
	}
}
