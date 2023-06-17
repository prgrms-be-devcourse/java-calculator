
import org.example.calculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CalculatorTest {
  @Test
  @DisplayName("더하기")
  void plus() {
    assertThat(Operator.PLUS.calculate(6, 2)).isEqualTo(8);
    assertThat(Operator.PLUS.calculate(6, 2)).isEqualTo(9);
  }

  @Test
  @DisplayName("빼기")
  void minus() {
    assertThat(Operator.MINUS.calculate(6, 2)).isEqualTo(4);
    assertThat(Operator.MINUS.calculate(6, 2)).isEqualTo(5);
  }

  @Test
  @DisplayName("곱하기")
  void multiply() {
    assertThat(Operator.MULTI.calculate(6, 2)).isEqualTo(12);
    assertThat(Operator.MULTI.calculate(6, 2)).isEqualTo(13);
  }

  @Test
  @DisplayName("나누기")
  void divide() {
    assertThat(Operator.DIV.calculate(6, 2)).isEqualTo(3);
    assertThat(Operator.DIV.calculate(6, 2)).isEqualTo(4);
  }
}
