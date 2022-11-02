package com.programmers.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Operation {

  private static final Map<Character, BiFunction<Double, Double, Double>> operators = new HashMap<>();

  static {
    operators.put('+', (num1, num2) -> num1 + num2);
    operators.put('-', (num1, num2) -> num1 - num2);
    operators.put('*', (num1, num2) -> num1 * num2);
    operators.put('/', (num1, num2) -> {
      if (num2 == 0) {
        throw new ArithmeticException("0으로는 나눌 수 없습니다.");
      }
      return num1 / num2;
    });
  }

  public static Double calculate(Character operator, double num1, double num2) {
    return operators.get(operator).apply(num1, num2);
  }

}
