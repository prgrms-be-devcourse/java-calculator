package org.example.calculator;

import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (num1, num2) -> num1 + num2),
  MINUS("-", (num1, num2) -> num1 - num2),
  MULTI("*", (num1, num2) -> num1 * num2),
  DIV("/", (num1, num2) -> num1 / num2);

  private final String operator;
  private final BiFunction<Double, Double, Double> formula;

  Operator(String operator, BiFunction<Double, Double, Double> formula) {
    this.operator = operator;
    this.formula = formula;
  }

  public String getOperator() {
    return operator;
  }

  public double calculate(double num1, double num2) {
    return formula.apply(num1, num2);
  }
}