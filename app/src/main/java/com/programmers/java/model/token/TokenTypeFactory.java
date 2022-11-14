package com.programmers.java.model.token;

import com.programmers.java.model.token.letter.Bracket;
import com.programmers.java.model.token.letter.Operator;
import com.programmers.java.model.token.number.Numbers;

public class TokenTypeFactory {
	public TokenType createTokenType(String token) {
		TokenType tokenType;

		if (Numbers.isNumbers(token)) {
			tokenType = new Numbers(token);
		} else if (Operator.isOperator(token)) {
			tokenType = Operator.getOperatorType(token);
		} else {
			tokenType = Bracket.getBracketType(token);
		}

		return tokenType;
	}
}
