package org.example.calculator;

import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (num1, num2) -> num1 + num2),
  MINUS("-", (num1, num2) -> num2 - num1),
  MULTI("*", (num1, num2) -> num1 * num2),
  DIV("/", (num1, num2) -> num2 / num1);

  private final String type;
  private final BiFunction<Double, Double, Double> formula;

  Operator(String type, BiFunction<Double, Double, Double> formula) {
    this.type = type;
    this.formula = formula;
  }

  public String getType() {
    return type;
  }

  public double calculate(double num1, double num2) {
    return formula.apply(num1, num2);
  }
}
