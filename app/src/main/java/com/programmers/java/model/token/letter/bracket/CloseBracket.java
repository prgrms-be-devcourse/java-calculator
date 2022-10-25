package com.programmers.java.model.token.letter.bracket;

import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.letter.Letter;
import com.programmers.java.model.token.letter.operator.Operator;

public class CloseBracket implements Letter {

	private final int priority = 0;

	public CloseBracket(String token) {
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public boolean checkNextTokenCorrect(TokenType nextToken) {
		if (nextToken instanceof Operator || nextToken instanceof CloseBracket) {
			return true;
		}
		return false;
	}
}
