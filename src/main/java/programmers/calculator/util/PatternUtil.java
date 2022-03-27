package programmers.calculator.util;

import java.util.regex.Pattern;

public class PatternUtil {

  private static final Pattern number = Pattern.compile("^[+-]?(([1-9]\\d*)|0)(\\.\\d+)?");

  public static boolean isNumeric(String token) {
    return number.matcher(token).matches();
  }
}
