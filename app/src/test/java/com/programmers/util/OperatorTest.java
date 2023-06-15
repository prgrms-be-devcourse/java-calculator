package com.programmers.util;

import com.programmers.exception.DivisionByZeroException;
import com.programmers.exception.NotFoundOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {
	
	@ParameterizedTest
	@DisplayName("연산자에 따라 제대로 계산")
	@CsvSource(value={"+ 8", "- 4", "* 12", "/ 3"}, delimiter = ' ')
	void exactlyCalc(String operator, Integer result) {
		// given
		Integer op1 = 6; Integer op2 = 2;
		
		// when
		Operator calc = Operator.of(operator);
			
		// then
		assertThat(calc.calculateOperation(op1, op2))
				.isEqualTo(result);
	}
	
	@Test
	@DisplayName("이상한 연산자가 들어갈 경우 NotFoundOperatorException 던짐")
	void throwNullPointerExceptionWhenoddOperator() {
		// given
		String oddOperator = "!";
		
		assertThatThrownBy(() -> {
			// when
			Operator.of(oddOperator);
		// then
		}).isExactlyInstanceOf(NotFoundOperatorException.class)
		  .hasMessage("찾을 수 없는 연산자입니다.");
	}
	
	@Test
	@DisplayName("0으로 나누는 경우 DivisionByZeroException 던짐")
	void throwWhenDivideZero() {
		// given
		Integer op1 = 4; Integer op2 = 0;
		Operator calc = Operator.of("/");
		
		assertThatThrownBy(() -> {
			// when
			calc.calculateOperation(op1, op2);
		// then
		}).isExactlyInstanceOf(DivisionByZeroException.class)
		  .hasMessage("0으로 나눌 수 없습니다.");
	}

}