package calcproject.engine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

	private static CalcExpressionTokenizer tokenizer;
	private static Calculator calculator;

	@BeforeAll
	public static void beforeAll() {
		tokenizer = new CalcExpressionTokenizer();
		calculator = new Calculator(tokenizer);
	}





	private static Stream<Arguments> tokensToPostfixNotationProvider() {
		return Stream.of(
			Arguments.of(Arrays.asList("1", "+", "2", "*", "3", "/", "4"),
				Arrays.asList("1", "2", "3", "*", "4", "/", "+")),
			Arguments.of(Arrays.asList("10", "*", "4", "/", "1"), Arrays.asList("/", "*", "10", "4", "1")),
			Arguments.of(Arrays.asList("4", "*", "3", "/", "2", "-", "1"),
				Arrays.asList("-", "/", "*", "4", "3", "2", "1"))
		);
	}

	@ParameterizedTest
	@DisplayName("후위 표기법 변환 테스트")
	@MethodSource("tokensToPostfixNotationProvider")
	void tokensToPostfixNotation(List<String> tokens, List<String> expectedTokens) {
		//when
		List<String> resultTokens = calculator.toPostfixNotation(tokens);

		//then
		Assertions.assertThat(resultTokens)
			.containsExactlyInAnyOrderElementsOf(expectedTokens);
	}

	@ParameterizedTest
	@DisplayName("식 계산 테스트")
	@MethodSource("calculateExpressionProvider")
	void calculateExpression(String expression, double expectedResult) {
		//given
		List<String> tokens = tokenizer.tokenizeExpression(expression);
		List<String> postfixNotationTokens = calculator.toPostfixNotation(tokens);

		//when
		double calcResult = calculator.calculatePostfixNotation(postfixNotationTokens);

		//then
		Assertions.assertThat(calcResult)
			.isEqualTo(expectedResult);
	}

	private static Stream<Arguments> calculateExpressionProvider() {
		return Stream.of(
			Arguments.of("1 + 2 * 3 / 4", "2.5"),
			Arguments.of("10 * 4 / 1", "40"),
			Arguments.of("4 * 3 / 2 - 1", "5")
		);
	}
}
