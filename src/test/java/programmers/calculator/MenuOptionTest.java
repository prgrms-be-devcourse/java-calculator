package programmers.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuOptionTest {

  @Test
  @DisplayName("1, 2 중에 선택한다")
  void of() {
    MenuOption historyOption = MenuOption.of("1");
    MenuOption calculateOption = MenuOption.of("2");

    assertEquals(historyOption, MenuOption.HISTORY);
    assertEquals(calculateOption, MenuOption.CALCULATE);
  }

  @ParameterizedTest
  @ValueSource(strings = {"3", "-1", "가나다", " ", "abc de"})
  @DisplayName("잘못된 입력은 에러 옵션을 반환한다.")
  void noneOf(String input) {
    MenuOption menuOption = MenuOption.of(input);
    assertEquals(menuOption, MenuOption.ERROR);
  }
}