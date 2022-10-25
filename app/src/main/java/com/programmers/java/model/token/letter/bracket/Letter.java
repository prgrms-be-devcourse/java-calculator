package com.programmers.java.model.token.letter.bracket;

import com.programmers.java.model.token.Token;

public interface Letter extends Token {

	default boolean haveLowerPriority(Letter token) {
		return getPriority() <= token.getPriority();
	}

	int getPriority();
}
