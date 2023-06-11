
import org.assertj.core.api.Assertions;
import org.example.calculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

  @Test
  @DisplayName("더하기")
  void plus() {
    Assertions.assertThat(Operator.PLUS.calculate(6,2)).isEqualTo(8);
    Assertions.assertThat(Operator.PLUS.calculate(6,2)).isEqualTo(9);
  }

  @Test
  @DisplayName("빼기")
  void minus() {
    Assertions.assertThat(Operator.MINUS.calculate(6,2)).isEqualTo(4);
    Assertions.assertThat(Operator.MINUS.calculate(6,2)).isEqualTo(5);
  }

  @Test
  @DisplayName("곱하기")
  void multiply() {
    Assertions.assertThat(Operator.MULTI.calculate(6,2)).isEqualTo(12);
    Assertions.assertThat(Operator.MULTI.calculate(6,2)).isEqualTo(13);
  }

  @Test
  @DisplayName("나누기")
  void divide() {
    Assertions.assertThat(Operator.DIV.calculate(6,2)).isEqualTo(3);
    Assertions.assertThat(Operator.DIV.calculate(6,2)).isEqualTo(4);
  }
}
