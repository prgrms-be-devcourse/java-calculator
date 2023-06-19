package com.programmers.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixCalculatorTest {
	
	PostfixCalculator postfixCalculator = new PostfixCalculator();
	
	@Test
	@DisplayName("후위 표기식을 계산")
	void calcPostfix() {
		// given
		List<String> postfix = List.of("1", "2", "*", "4", "2", "/", "+");
		
		// when
		Integer answer = postfixCalculator.calculatePostfix(postfix);
		
		// then
		assertThat(answer).isEqualTo(4);
	}
	
	
}