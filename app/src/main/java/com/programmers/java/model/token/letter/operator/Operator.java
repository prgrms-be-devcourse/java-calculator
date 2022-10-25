package com.programmers.java.model.token.letter.operator;

import com.programmers.java.exception.DivideByZeroException;
import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.letter.Letter;
import com.programmers.java.model.token.letter.bracket.OpenBracket;
import com.programmers.java.model.token.number.Numbers;

public interface Operator extends Letter {

	@Override
	default boolean checkNextTokenCorrect(TokenType nextToken) {
		if (nextToken instanceof Numbers || nextToken instanceof OpenBracket) {
			return true;
		}
		return false;
	}

	int calculate(int num1, int num2) throws DivideByZeroException;
}
