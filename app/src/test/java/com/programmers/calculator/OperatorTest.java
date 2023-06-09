package com.programmers.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {
	
	@Test
	@DisplayName("연산자에 따라 제대로 계산")
	void exactlyCalc() {
		// given
		Integer op1 = 6; Integer op2 = 2;
		String[] operators = { "+", "-", "*", "/" };
		Integer[] results = { 8, 4, 12, 3 };
		
		for (int i = 0; i < 4; i++) {
			// when
			Operator calc = Operator.of(operators[i]);
			BiFunction<Integer, Integer, Integer> func = calc.getFunc();
			
			// then
			assertThat(func.apply(op1, op2))
					.isEqualTo(results[i]);
		}
	}
	
	@Test
	@DisplayName("이상한 연산자가 들어갈 경우 NullPointException 던짐")
	void throwNullPointerExceptionWhenoddOperator() {
		// given
		String oddOperator = "!";
		
		assertThatThrownBy(() -> {
			// when
			Operator.of(oddOperator);
		// then
		}).isExactlyInstanceOf(NullPointerException.class);
	}
	
	@Test
	@DisplayName("0으로 나누는 경우 ArithmeticException 던짐")
	void throwWhenDivideZero() {
		// given
		Integer op1 = 4; Integer op2 = 0;
		Operator calc = Operator.of("/");
		BiFunction<Integer, Integer, Integer> func = calc.getFunc();
		
		assertThatThrownBy(() -> {
			// when
			func.apply(op1, op2);
		// then
		}).isExactlyInstanceOf(ArithmeticException.class);
	}

}