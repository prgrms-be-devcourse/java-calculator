import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @ValueSource(strings = {"", "        ", "@#@$%", "3 // 3", "3 + @#!"})
    @DisplayName("입력값이 숫자도 아니고 연산자도 아닌 경우")
    void throwExceptionIfNoValidInput3(String exp) {
        assertThatThrownBy(() -> calculator.calculate(exp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바른 숫자 혹은 연산자를 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"3 + 4:7", "3 + 5 + 7:15"}, delimiter = ':')
    @DisplayName("덧셈 테스트")
    void testAddition(String expression, String expectedResult) {
        //given
        int expected = Integer.parseInt(expectedResult);
        // when
        int actual = calculator.calculate(expression);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3 - 5 - 7:-9"}, delimiter = ':')
    @DisplayName("뺄셈 테스트")
    void testSubtraction(String expression, String expectedResult) {
        //given
        int expected = Integer.parseInt(expectedResult);
        // when
        int actual = calculator.calculate(expression);
        // then
        assertThat(actual).isEqualTo(expected);
    }

}
