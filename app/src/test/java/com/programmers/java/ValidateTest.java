package com.programmers.java;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.programmers.java.model.token.TokenTypeFactory;
import com.programmers.java.util.FormulaValidator;

class ValidateTest {
	FormulaValidator validator = new FormulaValidator(new TokenTypeFactory());

	@Test
	void validateWrongFormula() {
		ArrayList<String> formula = new ArrayList<>();
		formula.add("(1*3)?5"); // 연산자, 숫자. 괄호가 아닌 다른 문자가 들어옴
		formula.add("AAAbbb"); // 연산자, 숫자. 괄호가 아닌 다른 문자가 들어옴
		formula.add(""); // 공백
		formula.add("1*3+((1-3)"); // 괄호 짝이 안맞음
		formula.add("*1"); // 첫 문자에 들어올 수 없는 것이 입력됨
		formula.add(")-1"); // 첫 문자에 들어올 수 없는 것이 입력됨
		formula.add("1++34-5"); // 가운데 부분 순서가 잘못됨
		formula.add("1+)(3+5)(");
		formula.add("1+3+4-"); // 마지막 문자 잘못됨
		formula.add("(1+3+4)3"); // 마지막 문자 잘못됨

		formula.stream()
			.forEach(i -> Assertions.assertThrows(Exception.class, () -> validator.validateFormula(i)));
	}

	@Test
	void validateCorrectFormula() {
		ArrayList<String> formula = new ArrayList<>();
		formula.add("1*(2+3)");
		formula.add("((2+3))*3+3");
		formula.add("1*(3+4)/2");

		formula.stream()
			.forEach(i -> Assertions.assertDoesNotThrow(() -> validator.validateFormula(i)));
	}
}