package programmers.calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WhiteSpaceParserTest {

  WhiteSpaceParser parser = new WhiteSpaceParser();

  public static Stream<Arguments> provideSuccessData() {
    return Stream.of(
        Arguments.of("1 + 2", Arrays.asList("1", "+", "2")),
        Arguments.of("1 + 2 + 3", Arrays.asList("1", "+", "2", "+", "3")),
        Arguments.of("1 + 2 * 3", Arrays.asList("1", "+", "2", "*", "3")),
        Arguments.of("1 / 2 * 3 - 4", Arrays.asList("1", "/", "2", "*", "3", "-", "4"))
    );
  }

  @ParameterizedTest
  @DisplayName("공백을 구분하여 토큰으로 나눈다")
  @MethodSource("provideSuccessData")
  void parseSuccess(String input, List<String> expected) {
    List<String> parse = parser.parse(input);
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
    assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
  }

}