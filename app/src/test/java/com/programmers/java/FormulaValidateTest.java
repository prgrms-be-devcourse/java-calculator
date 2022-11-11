package com.programmers.java;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.programmers.java.exception.WrongBracketCountException;
import com.programmers.java.exception.WrongTokenOrderException;
import com.programmers.java.exception.WrongTokenTypeException;
import com.programmers.java.model.token.TokenTypeFactory;
import com.programmers.java.util.FormulaValidator;

class FormulaValidateTest {
	FormulaValidator validator = new FormulaValidator(new TokenTypeFactory());

	@Test
	void validateTokenIsCorrectTypeTest() { // 연산자, 숫자. 괄호가 아닌 다른 문자가 들어옴
		ArrayList<String> formula = new ArrayList<>();
		formula.add("(1*3)?5");
		formula.add("AAAbbb");
		formula.add("");
		formula.add(" ");

		formula.stream()
			.forEach(i -> Assertions.assertThrows(WrongTokenTypeException.class, () -> validator.validateFormula(i)));
	}

	@Test
	void validateBracketIsCouple() { // 괄호 짝이 안맞음
		ArrayList<String> formula = new ArrayList<>();
		formula.add("1*3+((1-3)");

		formula.stream()
			.forEach(
				i -> Assertions.assertThrows(WrongBracketCountException.class, () -> validator.validateFormula(i)));
	}

	@Test
	void validateFirstOrderIsCorrectTest() { // 첫 문자에 들어올 수 없는 것이 입력됨
		ArrayList<String> formula = new ArrayList<>();
		formula.add("*1");
		formula.add("/1");

		formula.stream()
			.forEach(i -> Assertions.assertThrows(WrongTokenOrderException.class, () -> validator.validateFormula(i)));
	}

	@Test
	void validateMiddleOrderIsCorrect() { // 가운데 부분 순서가 잘못됨
		ArrayList<String> formula = new ArrayList<>();
		formula.add("1++34-5");
		formula.add("1+()3+5()");

		formula.stream()
			.forEach(i -> Assertions.assertThrows(WrongTokenOrderException.class, () -> validator.validateFormula(i)));
	}

	@Test
	void validateLastOrderIsCorrect() { // 마지막 문자 잘못됨
		ArrayList<String> formula = new ArrayList<>();
		formula.add("1+3+4-");
		formula.add("(1+3+4)3");

		formula.stream()
			.forEach(i -> Assertions.assertThrows(WrongTokenOrderException.class, () -> validator.validateFormula(i)));
	}

	@Test
	void validateCorrectFormulaTest() {
		ArrayList<String> formula = new ArrayList<>();
		formula.add("1*(2+3)");
		formula.add("((2+3))*3+3");
		formula.add("1*(3+4)/2");

		formula.stream()
			.forEach(i -> Assertions.assertDoesNotThrow(() -> validator.validateFormula(i)));
	}
}