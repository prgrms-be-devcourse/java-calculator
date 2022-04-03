package programmers.calculator.processor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import programmers.calculator.processor.register.BufferRegister;
import programmers.calculator.processor.register.OperatorRegister;
import programmers.calculator.processor.register.ResultRegister;

class ProcessorTest {

  Processor processor;

  @BeforeEach
  void setUp() {
    processor = new Processor(
        new BufferRegister(),
        new ResultRegister(),
        new OperatorRegister()
    );
  }

  @ParameterizedTest
  @DisplayName("버퍼에 숫자를 쓴다")
  @ValueSource(strings = {"1", "0", "-1", "50", "10240"})
  void writeNumberToBuffer(String number) {
    processor.writeBuffer(number);

    assertThat(processor.readBuffer()).containsExactly(number);
  }

  @ParameterizedTest
  @DisplayName("버퍼에 연산자를 쓴다")
  @ValueSource(strings = {"+", "-", "*", "/"})
  void writeOperatorToBuffer(String operator) {
    processor.writeBuffer(operator);

    assertThat(processor.readBuffer()).containsExactly(operator);
  }


  @Test
  @DisplayName("버퍼 결과를 읽어온다")
  void readBuffer() {
    processor.writeBuffer("1");
    processor.writeBuffer("+");
    processor.writeBuffer("2");

    assertThat(processor.readBuffer()).containsExactly("1", "2", "+");
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "0", "-1", "50", "10240"})
  @DisplayName("연산 버퍼에 단일 숫자를 쓴다")
  void writeOneResult(String number) {
    processor.writeResult(number);

    assertThat(processor.readResult()).isEqualTo(Double.parseDouble(number));
  }


  @ParameterizedTest
  @CsvSource(value = {
      "1, +, 2, 3",
      "1, -, 2, -1",
      "5, *, 45, 225",
      "1, /, 2, 0.5"
  })
  @DisplayName("연산 버퍼에 여러 숫자를 쓴다")
  void writeMultiResult(String number1, String operator, String number2, String result) {
    processor.writeResult(number1);
    processor.writeResult(number2);
    processor.writeResult(operator);

    assertThat(processor.readResult()).isEqualTo(Double.parseDouble(result));
  }
}