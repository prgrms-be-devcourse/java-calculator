package programmers.calculator;

import java.util.Arrays;

public enum MenuOption {

  HISTORY(1), CALCULATE(2), ERROR(-1);

  private static final int NOT_A_NUMBER = -1;
  private final int code;

  MenuOption(int code) {
    this.code = code;
  }

  static MenuOption of(String input) {
    int code = toCode(input);
    return Arrays.stream(MenuOption.values())
        .filter(option -> option.code == code)
        .findFirst()
        .orElse(ERROR);
  }

  private static int toCode(String num) {
    try {
      return Integer.parseInt(num);
    } catch (NumberFormatException e) {
      return NOT_A_NUMBER;
    }
  }
}
