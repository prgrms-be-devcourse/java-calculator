package org.example.calculator;

public enum OperatorPriority {
  PLUS("+", 1),
  MINUS("-", 1),
  MULTI("*", 2),
  DIV("/", 2);

  private final String operator;
  private final int priority;

  OperatorPriority(String operator, int priority) {
    this.operator = operator;
    this.priority = priority;
  }

  public String getOperator() {
    return operator;
  }

  public static boolean isOperator(String letter) {
    for (OperatorPriority op : OperatorPriority.values()) {
      if (op.getOperator().equals(letter)) {
        return true;
      }
    }
    return false;
  }
}