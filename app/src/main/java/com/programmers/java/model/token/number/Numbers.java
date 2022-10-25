package com.programmers.java.model.token.number;

import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.letter.bracket.CloseBracket;
import com.programmers.java.model.token.letter.operator.Operator;

public class Numbers implements TokenType {

	public Numbers(String token) {
	}

	@Override
	public boolean checkNextTokenCorrect(TokenType nextToken) {
		if (nextToken instanceof Operator || nextToken instanceof CloseBracket) {
			return true;
		} else {
			return false;
		}
	}
}
