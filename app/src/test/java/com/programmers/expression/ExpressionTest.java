package com.programmers.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ExpressionTest {
	
	@Test
	@DisplayName("문자열 연산을 리스트 연산으로 바꾸어준다.")
	void changeStrExpressionToListExpression() {
		// given
		String strExpression = "3 * 4 / 2";
		
		// when
		Expression expression = new Expression(strExpression);
		List<String> listExpression = expression.getExpression();
		
		// then
		assertThat(listExpression)
				.containsExactly("3", "*", "4", "/", "2");
	}
	
	@Test
	@DisplayName("리스트 연산을 문자열 연산으로 변환한다.")
	void changeListExpressionToStrExpression() {
		// given
		Expression expression = new Expression("3 * 4 / 2");
		
		// when
		String strExpression = expression.toString();
		
		// then
		assertThat(strExpression)
				.isEqualTo("3 * 4 / 2");
	}
	
	@Test
	@DisplayName("잘못된 입력은 예외를 던진다.")
	void throwWhenInvalidInput() {
		// given
		String[] invalidInput = {
				"1     + 1",
				"1 + ",
				" + 1",
				" "
		};
		
		for (String s : invalidInput) {
			assertThatThrownBy(() -> {
				// when
				Expression expression = new Expression(s);
			// then
			}).isExactlyInstanceOf(IllegalArgumentException.class);
		}
	}
	
}