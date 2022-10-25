package com.programmers.java.model.token.letter;

import com.programmers.java.model.token.TokenType;

public interface Letter extends TokenType {

	default boolean haveLowerPriority(Letter token) {
		return getPriority() <= token.getPriority();
	}

	int getPriority();
}
