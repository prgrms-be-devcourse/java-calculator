package calculation.calculator.expression;

import java.math.BigDecimal;
import java.math.MathContext;

public class NormalArithmeticLogic implements ArithmeticLogic {

  private final String operatorRegex = "[\\+\\-\\*\\/]";
  private final String expressionRegex = "^((-?\\d*\\.?\\d+)\\s[\\+\\-\\*\\/]\\s)+(-?\\d*\\.?\\d+)$";;

  @Override
  public int getPriority(String op) {
    switch (op) {
      case "*":
      case "/":
        return 2;
      case "+":
      case "-":
        return 1;
    }
    return -1;
  }

  @Override
  public BigDecimal calculate(String operator, BigDecimal operandA, BigDecimal operandB) {
    switch (operator) {
      case "+":
        return operandA.add(operandB);
      case "-":
        return operandA.subtract(operandB);
      case "*":
        return operandA.multiply(operandB);
      case "/":
        return operandA.divide(operandB, MathContext.DECIMAL128);
      default:
        throw new IllegalArgumentException("잘못된 연산자 입니다.");
    }
  }

  @Override
  public String getOperatorRegex() {
    return operatorRegex;
  }

  @Override
  public String getExpressionRegex() {
    return expressionRegex;
  }

}
