package programmers.calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import programmers.calculator.processor.Processor;
import programmers.calculator.processor.register.BufferRegister;
import programmers.calculator.processor.register.OperatorRegister;
import programmers.calculator.processor.register.ResultRegister;
import programmers.calculator.repository.InMemoryRepository;

class ControlUnitTest {

  ControlUnit controlUnit = new ControlUnit(
      new Processor(new BufferRegister(), new ResultRegister(), new OperatorRegister()),
      new InMemoryRepository());

  public static Stream<Arguments> provideSuccessData() {
    return Stream.of(
        Arguments.of("1 + 2", Arrays.asList("1", "+", "2")),
        Arguments.of("1 + 2 + 3", Arrays.asList("1", "+", "2", "+", "3")),
        Arguments.of("1 + 2 * 3", Arrays.asList("1", "+", "2", "*", "3")),
        Arguments.of("1 / 2 * 3 - 4", Arrays.asList("1", "/", "2", "*", "3", "-", "4"))
    );
  }

  @Test
  @DisplayName("연산 결과를 출력한다")
  void printHistory() {
    controlUnit.execute("1 + 2");
    String history = controlUnit.printHistory();

    assertEquals("1 + 2 = 3\n", history);
  }

  @ParameterizedTest
  @CsvSource({
      "3 + 4 * 5, 23",
      "1.23 + 4.56 * 5.78, 27.59",
      "-4 * 2 / -3, 2.67",
      "1 + 4 + 3 * 2 - 4 * 3, -1",
      "2 * 2 + 4, 8"
  })
  @DisplayName("연산한다")
  void execute(String input, String expected) {
    String result = controlUnit.execute(input);

    assertEquals(expected, result);
  }

  @ParameterizedTest
  @DisplayName("공백을 구분하여 토큰으로 나눈다")
  @MethodSource("provideSuccessData")
  void parseSuccess(String input, List<String> expected) {
    List<String> parse = controlUnit.parse(input);
    assertThat(parse).containsExactly(expected.toArray(new String[0]));
  }

  @ParameterizedTest
  @DisplayName("수식이 잘못되면 예외가 발생한다")
  @ValueSource(strings = {
      "1 +2",
      "1 + 2--3",
      "1 + 2 2 * 3",
      "/ 1 / 2 * 3 - 4",
      "10 / 2 * 3 - 4 *",
      "가나다라"
  })
  void parseFailure(String input) {
    assertThrows(IllegalArgumentException.class, () -> controlUnit.parse(input));
  }

}