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
	public boolean checkNextTokenCorrect(TokenType nextToken) {
		if (nextToken instanceof Operator || nextToken.getValue().equals(")")) {
			return true;
		} else {
			return false;
		}
	}
}
