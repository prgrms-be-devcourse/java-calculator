package calculation.calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NormalArithmeticLogicTest {

  ArithmeticLogic arithmeticLogic = new NormalArithmeticLogic();

  @DisplayName("연산자 우선 순위 테스트")
  @Test
  void getPriorityTest() {
    int priorityMul = arithmeticLogic.getPriority("*");
    int priorityDiv = arithmeticLogic.getPriority("/");
    int priorityAdd = arithmeticLogic.getPriority("+");
    int prioritySub = arithmeticLogic.getPriority("-");

    Assertions.assertTrue(priorityAdd == prioritySub);
    Assertions.assertTrue(priorityMul == priorityDiv);
    Assertions.assertTrue(priorityMul > priorityAdd);
    Assertions.assertTrue(priorityMul > prioritySub);
    Assertions.assertTrue(priorityDiv > priorityAdd);
    Assertions.assertTrue(priorityDiv > prioritySub);
  }

  @DisplayName("정수 계산 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "+:1:2:3",
      "-:5:15:-10",
      "*:5:9:45",
      "/:10:2:5",
      "/:11:2:5.5"
  }, delimiter = ':')
  public void BasicCalcTest(String operator, BigDecimal operandA, BigDecimal operandB, BigDecimal expected) {
    //when
    BigDecimal result = arithmeticLogic.calculate(operator, operandA, operandB);

    //then
    assertThat(result).isEqualTo(expected);
  }

  @DisplayName("실수 계산 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "+:1.5:1.2:2.7",
      "-:1.6:1.2:0.4",
      "/:1.3:1.4:0.9285714285714285714285714285714286",
      "*:1.1:1.2:1.32"
  }, delimiter = ':')
  public void actualNumCalcTest(String operator, BigDecimal operandA, BigDecimal operandB, BigDecimal expected) {
    //when
    BigDecimal result = arithmeticLogic.calculate(operator, operandA, operandB);

    //then
    assertThat(result).isEqualTo(expected);
  }

  @DisplayName("큰 숫자 계산 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "+:2147483647:2147483647:4294967294",
      "*:1000000000000:1000000000000:1000000000000000000000000",
  }, delimiter = ':')
  public void bigNumCalcTest(String operator, BigDecimal operandA, BigDecimal operandB, BigDecimal expected) {
    //when
    BigDecimal result = arithmeticLogic.calculate(operator, operandA, operandB);

    //then
    assertThat(result).isEqualTo(expected);
  }

  @DisplayName("0으로 나누기 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "/:1:0",
      "/:10000:0",
  }, delimiter = ':')
  public void divideByZeroTest(String operator, BigDecimal operandA, BigDecimal operandB) {
    //when, then
    assertThatThrownBy(()->arithmeticLogic.calculate(operator,operandA,operandB)).isInstanceOf(ArithmeticException.class);
  }
}