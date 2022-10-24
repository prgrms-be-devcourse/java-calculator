package com.programmers.java;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.util.Validator;

class ValidateTest {
	Validator validator = new Validator();

	@Test
	void formulaInputValidate() {
		String[] formula = new String[9];
		formula[0] = "(1*3)?5"; // 연산자, 숫자. 괄호가 아닌 다른 문자가 들어옴
		formula[1] = "AAAbbb"; // 연산자, 숫자. 괄호가 아닌 다른 문자가 들어옴
		formula[2] = ""; // 공백
		formula[3] = "1*3+((1-3)"; // 괄호 짝이 안맞음
		formula[4] = "*1"; // 첫 문자에 들어올 수 없는 것이 입력됨
		formula[5] = ")-1"; // 첫 문자에 들어올 수 없는 것이 입력됨
		formula[6] = "1++34-5"; // 연산자와 숫자의 순서가 잘못됨
		formula[7] = "1+3+4-"; // 마지막 문자 잘못됨
		formula[8] = "(1+3+4)3"; // 마지막 문자 잘못됨

		Arrays.stream(formula)
			.forEach(i -> Assertions.assertThrows(FormulaInputException.class, () -> validator.validateFormula(i)));
	}
}