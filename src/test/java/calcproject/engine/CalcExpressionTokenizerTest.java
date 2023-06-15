package calcproject.engine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalcExpressionTokenizerTest {

	private CalcExpressionTokenizer calcExpressionTokenizer;

	@BeforeEach
	void beforeEach() {
		this.calcExpressionTokenizer = new CalcExpressionTokenizer();
	}

	@ParameterizedTest
	@DisplayName("식을 토큰 단위로 나누는 테스트")
	@MethodSource("expressionProvider")
	void tokenizeExpression(String expression, List<String> expectedTokens) {
		//when
		List<String> resultTokens = calcExpressionTokenizer.tokenizeExpression(expression);

		//then
		Assertions.assertThat(resultTokens)
			.containsExactlyInAnyOrderElementsOf(expectedTokens);
	}

	private static Stream<Arguments> expressionProvider() {
		return Stream.of(
			Arguments.of("1 + 2 * 3 / 4", Arrays.asList("1", "+", "2", "*", "3", "/", "4")),
			Arguments.of("10 * 4 / 1", Arrays.asList("10", "*", "4", "/", "1")),
			Arguments.of("4 * 3 / 2 - 1", Arrays.asList("4", "*", "3", "/", "2", "-", "1"))
		);
	}
}