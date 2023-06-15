package calcproject.engine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import calcproject.engine.tokenaction.TokenAction;

class CalculatorTest {

	private static CalcExpressionTokenizer tokenizer;
	private static Calculator calculator;

	@BeforeAll
	public static void beforeAll() {
		tokenizer = new CalcExpressionTokenizer();
		calculator = new Calculator(tokenizer);
	}

	@Test
	void tokensToPostfixNotation() {
		//given
		String expression = "1+2*3";
		List<String> tokens = tokenizer.tokenizeExpression(expression);
		List<String> expectedTokens = Arrays.asList("1", "2", "3", "*", "+");

		//when
		List<String> resultTokens = calculator.tokensToPostfixNotation(tokens);

		//then
		Assertions.assertThat(resultTokens)
			.containsExactlyInAnyOrderElementsOf(expectedTokens);

	}

	@Test
	void calculateExpression() {
		//given
		String expression = "1+2*3";
		List<String> tokens = tokenizer.tokenizeExpression(expression);
		List<String> postfixNotationTokens = calculator.tokensToPostfixNotation(tokens);
		double expectedResult = 7;

		//when
		double calcResult = calculator.calculatePostfixNotation(postfixNotationTokens);

		//
		Assertions.assertThat(calcResult)
			.isEqualTo(expectedResult);
	}
}