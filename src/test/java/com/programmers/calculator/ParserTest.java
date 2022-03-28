package com.programmers.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.programmers.calculator.engine.Parser;

class ParserTest {

	@DisplayName("1. formula parse 테스트")
	@Test
	public void foluma_test() throws Exception{
		assertTrue(Parser.parse("1 + 2"));
		assertTrue(Parser.parse("1 + 2 + 3"));
		assertTrue(Parser.parse("1 + 2 + 3 * 3 % 2222"));
		assertTrue(Parser.parse("2222 + 2 - 3333 * 3 % 2222"));
		assertFalse(Parser.parse("1 +2"));
		assertFalse(Parser.parse("1+ 2 + 3 + 4"));

	}

}
