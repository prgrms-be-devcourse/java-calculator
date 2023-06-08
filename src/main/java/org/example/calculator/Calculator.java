package org.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
  Stack<Double> stack = new Stack<>();

  public double calculate(String inputFormula) {

    String[] formula = inputFormula.split(" ");
    for (String letter : formula) {
      if (OperatorPriority.isOperator(letter)) {
        double number1 = stack.pop();
        double number2 = stack.pop();
        stack.push(calculation(number1, number2, letter));
        continue;
      }
      stack.push(Double.parseDouble(letter));
    }
    return stack.pop();
  }

  public double calculation(double number1, double number2, String operator) {
    if (("+").equals(operator)) {
      return Operator.PLUS.calculate(number1, number2);
    }
    if (("-").equals(operator)) {
      return Operator.MINUS.calculate(number1, number2);
    }
    if (("*").equals(operator)) {
      return Operator.MULTI.calculate(number1, number2);
    }
    if (("/").equals(operator)) {
      return Operator.DIV.calculate(number1, number2);
    }
    throw new IllegalArgumentException();
  }
}