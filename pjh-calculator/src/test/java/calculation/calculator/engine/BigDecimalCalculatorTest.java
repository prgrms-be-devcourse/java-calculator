package calculation.calculator.engine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculation.calculator.expression.NormalArithmeticLogic;
import calculation.calculator.expression.NormalExpressionService;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BigDecimalCalculatorTest {

  BigDecimalCalculator calculator = new BigDecimalCalculator
      (new NormalExpressionService(new NormalArithmeticLogic()));

  @DisplayName("잘못된 연산식 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"1 + 2+ 3", " 1 + 2 + 3", "1 + 2 + 3 ", "1 ? 2 + 3", "1 ++ 2 + 3", " 1 * * 2 + 3", "1", "+", "a + b"})
  public void badExpressionTest(String expression) {
    /**
     * 1. 연산자와 숫자사이에 공백이 없을 때
     * 2. 맨 앞에 공백이 있을 때
     * 3. 맨 뒤에 공백이 있을 때
     * 4. 연산자가 잘못 됐을 때
     * 5. 연산자가 공백 없이 연속으로 있을 때
     * 6. 연산자가 올 위치가 아닐 때
     * 7. 연산 식이 아닐 때 - 숫자 한 개
     * 8. 연산 식이 아닐 때 - 연산자 한개
     * 9. 숫자가 아닌 다른 문자가 피연산자로 들어올 때
     **/
    assertThatThrownBy(() -> calculator.execute(expression)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("정수 계산 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1 + 2:3",
      "5 - 15:-10",
      "5 * 9:45",
      "10 / 2:5",
      "11 / 2:5.5"}, delimiter = ':')
  public void basicCalculationTest(String expression, BigDecimal expected) {
    //when
    BigDecimal answer = calculator.execute(expression).getAns();

    //then
    assertThat(answer).isEqualTo(expected);
  }

  @DisplayName("실수 계산 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "1.5 + 1.2:2.7",
      "1.6 - 1.2:0.4",
      "1.3 / 1.4:0.9285714285714285714285714285714286",
      "1.1 * 1.2:1.32"}, delimiter = ':')
  public void actualNumberCalculationTest(String expression, BigDecimal expected) {
    //when
    BigDecimal answer = calculator.execute(expression).getAns();

    //then
    assertThat(answer).isEqualTo(expected);
  }

  @DisplayName("복잡한 계산식 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "1 + 2 * 3:7",
      "0 * 1 / 1:0",
      "1 * 2 + 1 / 1 * 10:12"}, delimiter = ':')
  public void complexCalculationTest(String expression, BigDecimal expected) {
    //when
    BigDecimal answer = calculator.execute(expression).getAns();

    //then
    assertThat(answer).isEqualTo(expected);
  }

  @DisplayName("큰 숫자 계산 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "2147483647 + 2147483647:4294967294",
      "1000000000000 * 1000000000000:1000000000000000000000000"
  }, delimiter = ':')
  public void bigNumberCalculationTest(String expression, BigDecimal expected) {
    //when
    BigDecimal answer = calculator.execute(expression).getAns();

    //then
    assertThat(answer).isEqualTo(expected);
  }

  @DisplayName("0으로 나누기 테스트")
  @ParameterizedTest
  @ValueSource(strings = {
      "1 / 0",
      "1 + 2 / 0"
  })
  public void divideByZeroTest(String expression) {
    assertThatThrownBy(() -> calculator.execute(expression)).isInstanceOf(ArithmeticException.class);
  }
}