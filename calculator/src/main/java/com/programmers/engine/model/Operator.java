package com.programmers.engine.model;

public enum Operator {
  ADD('+') {
    @Override
    public double calculate(double leftOperand, double rightOperand) {
      return leftOperand + rightOperand;
    }
  },
  SUBTRACT('-') {
    @Override
    public double calculate(double leftOperand, double rightOperand) {
      return leftOperand - rightOperand;
    }
  },
  MULTIPLY('*') {
    @Override
    public double calculate(double leftOperand, double rightOperand) {
      return leftOperand * rightOperand;
    }
  },
  DIVIDE('/') {
    @Override
    public double calculate(double leftOperand, double rightOperand) {
      if (rightOperand == 0) {
        throw new ArithmeticException("0으로 나눌 수 없습니다.");
      }
      return Math.round(leftOperand / rightOperand * 100.0) / 100.0;
    }
  };

  private final char symbol;

  Operator(char symbol) {
    this.symbol = symbol;
  }

  public static Operator fromSymbol(char symbol) {
    for (Operator operator : values()) {
      if (operator.symbol == symbol) {
        return operator;
      }
    }
    throw new IllegalArgumentException("잘못된 연산자입니다." + symbol);
  }

  public abstract double calculate(double leftOperand, double rightOperand);
}
