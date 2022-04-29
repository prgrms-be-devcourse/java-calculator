package com.programmers.calculator.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.programmers.calculator.engine.util.ArithmeticUnit;

class ArithmeticUnitTest {

	@DisplayName("1. 계산 테스트( +, -) 순차적 계산")
	@Test
	public void calculate_test() throws Exception{
		assertEquals("6", ArithmeticUnit.calculate("1 + 2 + 3"));
		assertEquals("0",ArithmeticUnit.calculate("1 + 2 - 3"));
		assertEquals("99",ArithmeticUnit.calculate("50 + 51 - 2"));
	}

	@DisplayName("2. 우선순위 만족 계산(*,  %) 테스트")
	@Test
	public void test() throws Exception{
		assertEquals("2548",ArithmeticUnit.calculate("50 * 51 - 2"));
		assertEquals("30",ArithmeticUnit.calculate("40 - 2 * 5"));
		assertEquals("42.5",ArithmeticUnit.calculate("40 - 2 * 5 + 25 % 2"));

	}

}
