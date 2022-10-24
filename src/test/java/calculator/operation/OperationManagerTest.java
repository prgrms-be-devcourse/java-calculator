package calculator.operation;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.validator.FormulaValidator;

class OperationManagerTest {

	OperationManager operationManager = new OperationManager(new FormulaValidator());

	@Test
	@DisplayName("연산")
	void test1() {

		//given
		List<String> origin = Arrays.asList("3", "2", "4", "*", "1", "-", "+");
		String answer = "10.0";

		//when
		String result = operationManager.calculate(origin);

		//then
		Assertions.assertEquals(result, answer);

	}

	@Test
	@DisplayName("후위 표기법 변환")
	void test2() {

		//given
		List<String> origin = Arrays.asList("3", "+", "2", "*", "4", "-", "1");
		List<String> expect = Arrays.asList("3", "2", "4", "*", "1", "-", "+");

		//when
		List<String> postFix = operationManager.toPostFix(origin);

		//then
		Assertions.assertEquals(postFix, expect);

	}

	@Test
	@DisplayName("나누기 0")
	void test3() {

		//given
		List<String> origin = Arrays.asList("3", "/", "0");
		List<String> postFix = operationManager.toPostFix(origin);

		//expect
		Assertions.assertThrows(ArithmeticException.class, () -> operationManager.calculate(postFix));
	}

	@Test
	@DisplayName("나누기 0이 아닌 값")
	void test4() {

		//given
		List<String> origin = Arrays.asList("3", "/", "1", "*", "5");
		List<String> postFix = operationManager.toPostFix(origin);

		//expect
		Assertions.assertDoesNotThrow(() -> operationManager.calculate(postFix));
	}

}