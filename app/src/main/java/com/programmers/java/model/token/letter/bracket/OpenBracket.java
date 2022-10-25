package com.programmers.java.model.token.letter.bracket;

import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.letter.Letter;
import com.programmers.java.model.token.number.Numbers;

public class OpenBracket implements Letter {

	private final int priority = 0;

	public OpenBracket(String token) {
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public boolean checkNextTokenCorrect(TokenType nextToken) {
		if (nextToken instanceof Numbers || nextToken instanceof OpenBracket) {
			return true;
		}
		return false;
	}
}
