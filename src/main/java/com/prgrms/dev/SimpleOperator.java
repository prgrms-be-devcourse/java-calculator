package com.prgrms.dev;

import com.prgrms.dev.calculator.io.Operator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class SimpleOperator implements Operator {
  private final Pattern pattern = Pattern.compile("[0-9]( [/*] [0-9])*");

  @Override
  public int calculate(String formula) {
    String[] arr = calculatePriority(formula).split(" ");
    return calculateFormula(arr);
  }

  private String calculatePriority(String formula) {
    Matcher matcher = pattern.matcher(formula);
    while (matcher.find()) {
      String priority = matcher.group();
      if (priority.equals("")) continue;

      // 계산
      int result = calculateFormula(priority.split(" "));
      formula = formula.replace(priority, String.valueOf(result));
    }
    return formula;
  }

  private int calculateFormula(String[] array) {
    int result = toInt(array[0]);
    for (int i = 1; i < array.length; i+=2) {
      switch (array[i]) {
        case "+":
          result += toInt(array[i + 1]);
          break;
        case "-":
          result -= toInt(array[i + 1]);
          break;
        case "*":
          result *= toInt(array[i + 1]);
          break;
        case "/":
          if (array[i + 1].equals("0")) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
          result /= toInt(array[i + 1]);
          break;
        default:
          break;
      }
    }
    return result;
  }
}
