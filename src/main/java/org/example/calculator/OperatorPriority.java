package org.example.calculator;

import java.util.Arrays;

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

  public static boolean isOperator(String value) {
    return Arrays.stream(Operator.values())
            .anyMatch(o -> o.getType().equals(value));
  }

  public static int checkPriority(String operator) {
    if (PLUS.getOperator().equals(operator)) {
      return PLUS.priority;
    }
    if (MINUS.getOperator().equals(operator)) {
      return MINUS.priority;
    }
    if (MULTI.getOperator().equals(operator)) {
      return MULTI.priority;
    }
    if (DIV.getOperator().equals(operator)) {
      return DIV.priority;
    }
    return -1;
  }
}
