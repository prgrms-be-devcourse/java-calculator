package com.programmers.java.model.token.letter.bracket;

import com.programmers.java.model.token.Token;

public class OpenBracket implements Letter {

	private final int priority = 0;

	public OpenBracket(String token) {
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public boolean checkNextTokenCorrect(Token nextToken) {
		if (nextToken instanceof Number || nextToken instanceof OpenBracket) {
			return true;
		}
		return false;
	}
}
