package com.programmers.java.model.token.letter.operator;

import com.programmers.java.exception.DivideByZeroException;
import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.Letter;
import com.programmers.java.model.token.letter.bracket.OpenBracket;
import com.programmers.java.model.token.number.Number;

public interface Operator extends Letter {

	@Override
	default boolean checkNextTokenCorrect(Token nextToken) {
		if (nextToken instanceof Number || nextToken instanceof OpenBracket) {
			return true;
		}
		return false;
	}

	int calculate(int num1, int num2) throws DivideByZeroException;
}
