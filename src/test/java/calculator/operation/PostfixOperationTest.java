package calculator.operation;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.validator.FormulaValidator;

class PostfixOperationTest {

	PostfixOperation postfixOperation = new PostfixOperation(new FormulaValidator());

	@Test
	@DisplayName("연산")
	void test1() {

		//given
		List<String> origin = Arrays.asList("3", "+", "2", "*", "4", "-", "1");
		String answer = "10.0";

		//when
		String result = postfixOperation.calculate(origin);

		//then
		Assertions.assertEquals(result, answer);

	}

}