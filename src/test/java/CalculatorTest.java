import org.assertj.core.api.Assertions;
import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

  @Test
  @DisplayName("더하기")
  void plus() {
    Assertions.assertThat(Calculator.plus(6, 2)).isEqualTo(8);
  }

  @Test
  @DisplayName("빼기")
  void minus() {
    Assertions.assertThat(Calculator.minus(6, 2)).isEqualTo(4);
  }

  @Test
  @DisplayName("곱하기")
  void multiply() {
    Assertions.assertThat(Calculator.multiply(6, 2)).isEqualTo(12);
  }

  @Test
  @DisplayName("나누기")
  void divide() {
    Assertions.assertThat(Calculator.divide(6, 2)).isEqualTo(3);
  }
}