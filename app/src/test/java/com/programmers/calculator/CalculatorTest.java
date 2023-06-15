package com.programmers.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
	
	Calculator calculator = new Calculator();
	
	@Test
	@DisplayName("중위 표기식을 후위 표기식으로 변환")
	void infixTopostfix() {
		// given
		List<String> infix1 = List.of("1", "*", "2", "+", "3", "/", "4");
		
		// when
		List<String> postfix = calculator.changeInfixToPostfix(infix1);
		
		// then
		assertThat(postfix)
				// 순서도 똑같이
				.containsExactly("1", "2", "*", "3", "4", "/", "+");
	}
	
	@Test
	@DisplayName("후위 표기식을 계산")
	void calcPostfix() {
		// given
		List<String> postfix = List.of("1", "2", "*", "4", "2", "/", "+");
		
		// when
		Integer answer = calculator.calculatePostfix(postfix);
		
		// then
		assertThat(answer).isEqualTo(4);
	}
	
}