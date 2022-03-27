package programmers.calculator.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PatternUtilTest {

  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "15123", "-4", "0", "600", "1.2", "-4.5"})
  @DisplayName("숫자인지 테스트한다")
  void isNumeric(String input) {

    assertTrue(PatternUtil.isNumeric(input));
  }
}