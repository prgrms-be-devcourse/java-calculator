package com.programmers.model;

public enum Operator {
  ADD('+') {
    @Override
    public double performOperation(double operand1, double operand2) {
      return operand1 + operand2;
    }
  },
  SUBTRACT('-') {
    @Override
    public double performOperation(double operand1, double operand2) {
      return operand1 - operand2;
    }
  },
  MULTIPLY('*') {
    @Override
    public double performOperation(double operand1, double operand2) {
      return operand1 * operand2;
    }
  },
  DIVIDE('/') {
    @Override
    public double performOperation(double operand1, double operand2) {
      if (operand2 == 0) {
        throw new ArithmeticException("Division by zero");
      }
      return Math.round(operand1 / operand2 * 100.0) / 100.0;
    }
  };

  private final char symbol;

  Operator(char symbol) {
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }

  public static Operator fromSymbol(char symbol) {
    for (Operator operator : values()) {
      if (operator.symbol == symbol) {
        return operator;
      }
    }
    throw new IllegalArgumentException("Invalid operator symbol: " + symbol);
  }

  public abstract double performOperation(double operand1, double operand2);
}
