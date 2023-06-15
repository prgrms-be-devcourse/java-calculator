import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import co.programmers.domain.Calculation;
import co.programmers.domain.Expression;
import co.programmers.domain.Operator;

class CalculatorTest {

	static ArrayList<String>[] generateData() {
		return new ArrayList[] {
				new ArrayList<>(Arrays.asList("+", "*", "*", "-", "/")),
		};
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"1 + 25 % 4",
			"3 ^ 3 - 22 / 3",
			"22 # 3 - 4 + 15",
			"2 ! 3"
	})
	@DisplayName("입력된 수식이 사칙 연산 이외의 연산 기호를 포함하는 경우 예외를 던진다.")
	void ExpressionTest(String input) {
		assertThatThrownBy(() -> new Expression(input)).isInstanceOf(ArithmeticException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"1 + 25 % 4 + A",
			"AB2 * 3 - 22 + 3",
			"22 + A - 4 + 15",
			"[ 2 * 3 / ]"
	})
	@DisplayName("입력된 수식이 숫자와 사칙 연산 기호 이외의 문자를 포함하는 경우 예외를 던진다.")
	void ExpressionWithInvalidCharactersTest(String input) {
		assertThatThrownBy(() -> new Expression(input)).isInstanceOf(ArithmeticException.class);
	}

	@ParameterizedTest
	@MethodSource("generateData")
	@DisplayName("여러 연산자들이 주어졌을 때 연산 순서를 올바르게 결정할 수 있다")
	void OperatordecideCalculationOrderTest(ArrayList<String> operators) {
		ArrayList<String> operatorOrder = new ArrayList<>(Arrays.asList("*", "*", "/", "+", "-"));
		Operator.decideCalculationOrder(operators);
		assertThat(operators).containsExactlyElementsOf(operatorOrder);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("입력된 수식이 null 이거나 빈 공백인 경우 예외를 던진다.")
	void ExpressionNullAndEmptyTest(String expression) {
		assertThatThrownBy(() -> new Expression(expression))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"1 + 25 * 4 / 0",
			"3 / 0",
			"22 - 3 + 4 / 0",
	})
	@DisplayName("0으로 나누는 경우 예외를 던진다")
	void calculateDividedByZeroTest(String inputExpression) {
		Expression expression = new Expression(inputExpression);
		Calculation calculation = new Calculation(expression);
		assertThatThrownBy(() -> calculation.calculate())
				.isInstanceOf(ArithmeticException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {
			"1111 + 10000 : 11111.0",
			"200 - 100 : 100.0",
			"20 / 5 : 4.0",
			"30 * 3 : 90.0",
			"2 + 6 * 2 / 8 : 3.5",
			"21 + 3 * 4 - 33 / 2 : 16.5",
			"42 / 3 * 4 - 2 : 54.0"},
			delimiter = ':')
	@DisplayName("주어진 수식에 대해 정확한 계산을 할 수 있다")
	void OperatorCalculateTest(String input, final Double result) {
		Expression expression = new Expression(input);
		Calculation calculation = new Calculation(expression);
		assertThat(calculation.calculate()).isEqualTo(result);
	}
}
