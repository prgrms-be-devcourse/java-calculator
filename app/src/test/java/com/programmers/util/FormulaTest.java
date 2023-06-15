package com.programmers.util;

import com.programmers.exception.InvalidFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FormulaTest {
	
	@Test
	@DisplayName("문자열 연산을 리스트 연산으로 바꾸어준다.")
	void changeStrFormulaToListFormula() {
		// given
		String strExpression = "3 * 4 / 2";
		
		// when
		Formula formula = new Formula(strExpression);
		List<String> listExpression = formula.getInfixFormula();
		
		// then
		assertThat(listExpression)
				.containsExactly("3", "*", "4", "/", "2");
	}
	
	@Test
	@DisplayName("리스트 연산을 문자열 연산으로 변환한다.")
	void changeListFormulaToStrFormula() {
		// given
		Formula formula = new Formula("3 * 4 / 2");
		Integer result = 6;
		
		// when
		String strExpression = formula.toString(result);
		
		// then
		assertThat(strExpression)
				.isEqualTo("3 * 4 / 2 = 6");
	}
	
	@ParameterizedTest
	@DisplayName("잘못된 입력은 예외를 던진다.")
	@ValueSource(strings = {"1      + 1", "1 + ", "1 ! 1", " + 1", " ", "111 + 111"})
	void throwWhenInvalidInput(String invalidInput) {
		assertThatThrownBy(() -> {
			// when
			Formula formula = new Formula(invalidInput);
		// then
		}).isExactlyInstanceOf(InvalidFormulaException.class)
		  .hasMessage("유효하지 않은 수식 입력입니다.");
	}
	
}