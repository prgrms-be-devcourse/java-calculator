package com.programmers.java.engine.service.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.programmers.java.engine.utils.Function;

public class FunctionTest {

	@Test
	public void 숫자가_아닌경우_false가_나와야함() {
		// given
		String errorNum = "ab";
		//when
		boolean testBool = Function.isStrDigit(errorNum);
		//then
		Assertions.assertFalse(testBool);
	}

	@Test
	public void 잘못된_숫자형식일경우_false가_나와야함() {
		// given
		String errorNum = "1-";
		//when
		boolean testBool = Function.isStrDigit(errorNum);
		//then
		Assertions.assertFalse(testBool);
	}

	@Test
	public void 음수가_들어올경우_true가_나와야함() {
		// given
		String correctNum = "-1";
		//when
		boolean testBool = Function.isStrDigit(correctNum);
		//then
		Assertions.assertTrue(testBool);
	}

	@Test
	public void 지정된_연산자가_아닌경우_false가_나와야함() {
		// given
		String correctNum = "%";
		//when
		boolean testBool = Function.isOperator(correctNum);
		//then
		Assertions.assertFalse(testBool);
	}

	@Test
	public void 길이가_1이_아닌경우_false가_나와야함() {
		// given
		String correctNum = "+-";
		//when
		boolean testBool = Function.isOperator(correctNum);
		//then
		Assertions.assertFalse(testBool);
	}
}
