package com.programmers.java.model.token.number;

import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.CloseBracket;
import com.programmers.java.model.token.letter.operator.Operator;

public class Number implements Token {

	public Number(String token) {
	}

	@Override
	public boolean checkNextTokenCorrect(Token nextToken) {
		if (nextToken instanceof Operator || nextToken instanceof CloseBracket) {
			return true;
		} else {
			return false;
		}
	}
}
