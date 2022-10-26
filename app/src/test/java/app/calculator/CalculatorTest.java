package app.calculator;

import app.io.Console;
import app.storage.MapStorage;
import app.validator.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator(new Console(), new Console(), new MapStorage(), new BasicPostfixMaker(), new InputValidator());

    @DisplayName("덧셈 확인")
    @Test
    void plusCalculationTest() {
        // given
        List<String> expression = List.of("1", "2", "+");
        Integer answer = 3;

        // when
        int result = calculator.calculate(expression).getCorrectAnswer();

        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("뺄셈 확인")
    @Test
    void minusCalculationTest() {
        // given
        List<String> expression = List.of("5", "2", "-");
        Integer answer = 3;

        // when
        int result = calculator.calculate(expression).getCorrectAnswer();

        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("곱셈 확인")
    @Test
    void multiplicationCalculationTest() {
        // given
        List<String> expression = List.of("10", "2", "*");
        Integer answer = 20;

        // when
        int result = calculator.calculate(expression).getCorrectAnswer();

        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("나눗셈 확인")
    @Test
    void divisionCalculationTest() {
        // given
        List<String> expression = List.of("10", "2", "/");
        Integer answer = 5;

        // when
        int result = calculator.calculate(expression).getCorrectAnswer();

        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("사칙연산 확인")
    @Test
    void arithmeticOperationTest() {
        // given
        List<String> expression = List.of("1", "2", "3", "*", "+", "10", "5", "/", "-");
        Integer answer = 5;

        // when
        int result = calculator.calculate(expression).getCorrectAnswer();

        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("분모, 분자에 0이 들어간 나눗셈인 경우 예외 확인")
    @Test
    void divisionContainZeroTest() {
        // given
        List<String> momZero = List.of("1", "0", "/");
        List<String> sonZero = List.of("0", "1", "/");

        // when
        Answer momZeroResult = calculator.calculate(momZero);
        Answer sonZeroResult = calculator.calculate(sonZero);

        // then
        assertFalse(momZeroResult.isCorrectAnswer());
        assertFalse(sonZeroResult.isCorrectAnswer());
    }

}
