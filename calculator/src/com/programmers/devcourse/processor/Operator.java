package com.programmers.devcourse.processor;

import com.programmers.devcourse.exception.processor.WrongOperatorTokenException;
import java.util.function.BiFunction;

public enum Operator {

  ADDITION('+', Double::sum),
  SUBTRACTION('-', (a, b) -> a - b
  ), MULTIPLICATION('*', (a, b) -> a * b),
  DIVISION('/', (a, b) -> a / b);

  private final char signature;
  private final BiFunction<Double, Double, Double> concreteOperator;

  Operator(char signature,
      BiFunction<Double, Double, Double> concreteOperator) {
    this.signature = signature;
    this.concreteOperator = concreteOperator;
  }

  public static Operator from(char candidate) throws WrongOperatorTokenException {
    for (Operator operator : Operator.values()) {
      if (operator.signature == candidate) {
        return operator;
      }
    }
    throw new WrongOperatorTokenException();
  }

  public double operate(double a, double b) {
    return concreteOperator.apply(a, b);
  }
}
