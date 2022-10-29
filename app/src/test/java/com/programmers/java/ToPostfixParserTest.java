package com.programmers.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.programmers.java.model.token.TokenTypeFactory;
import com.programmers.java.util.PostfixParser;

class ToPostfixParserTest {
	@Test
	void changeInfixToPostfix() {
		PostfixParser parser = new PostfixParser(new TokenTypeFactory());
		String infixFormula1 = "1+2*3";
		String infixFormula2 = "(1+2)/3";

		String[] postfixFormula1 = parser.changeInfixToPostfix(infixFormula1);
		String[] postfixFormula2 = parser.changeInfixToPostfix(infixFormula2);

		Assertions.assertEquals(postfixFormula1.length, 5);
		Assertions.assertEquals(postfixFormula2.length, 5);
	}
}