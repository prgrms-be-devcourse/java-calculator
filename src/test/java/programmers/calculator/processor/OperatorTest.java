package programmers.calculator.processor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static programmers.calculator.processor.arithmetic.Operator.ADD;
import static programmers.calculator.processor.arithmetic.Operator.DIVIDE;
import static programmers.calculator.processor.arithmetic.Operator.MULTIPLY;
import static programmers.calculator.processor.arithmetic.Operator.SUBTRACT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import programmers.calculator.processor.arithmetic.Operator;

class OperatorTest {

  Operator add = ADD;
  Operator subtract = SUBTRACT;
  Operator multiply = MULTIPLY;
  Operator divide = DIVIDE;

  @ParameterizedTest
  @EnumSource(value = Operator.class, names = {"MULTIPLY", "DIVIDE"})
  @DisplayName("*, / 는 +, - 보다 우선순위가 높다")
  void isPreceding(Operator preceding) {
    assertTrue(preceding.isPreceding(add));
    assertTrue(preceding.isPreceding(subtract));
  }

  @ParameterizedTest
  @EnumSource(value = Operator.class, names = {"ADD", "SUBTRACT"})
  @DisplayName("+, - 는 *, / 보다 우선순위가 낮다")
  void isTrailing(Operator trailing) {
    assertFalse(trailing.isPreceding(divide));
    assertFalse(trailing.isPreceding(multiply));
  }

  @Test
  @DisplayName("+, - 와 *, / 는 서로 우선순위가 높지 않다.")
  void isNotPreceding() {
    assertFalse(add.isPreceding(subtract));
    assertFalse(multiply.isPreceding(divide));
  }

  @ParameterizedTest
  @EnumSource(value = Operator.class, names = {"DIVIDE"})
  @DisplayName("나누기 0은 에러를 반환한다")
  void divideByZero(Operator divide) {
    assertThrows(ArithmeticException.class, () -> divide.operate(1, 0));
  }

  @ParameterizedTest
  @ValueSource(strings = {"+", "-", "*", "/"})
  @DisplayName("연산자인지 테스트한다")
  void isOperator(String input) {
    assertTrue(Operator.isOperator(input));
  }
}
