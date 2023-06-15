package calcproject.engine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalcExpressionTokenizerTest {

	private CalcExpressionTokenizer calcExpressionTokenizer;

	@BeforeEach
	void beforeEach() {
		this.calcExpressionTokenizer = new CalcExpressionTokenizer();
	}

	@Test
	@DisplayName("식을 토큰 단위로 나누는 테스트")
	void tokenizeExpression() {
		//given
		String expression = "1 + 2 * 3 / 4";
		List<String> expectedTokens = Arrays.asList("1", "+", "2", "*", "3", "/", "4");

		//when
		List<String> resultTokens = calcExpressionTokenizer.tokenizeExpression(expression);

		//then
		Assertions.assertThat(resultTokens)
			.containsExactlyInAnyOrderElementsOf(expectedTokens);
	}
}