package org.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

  public double calculate(String inputFormula) {

    String[] formula = inputFormula.split(" ");
    List<String> list = seperate(formula);
    Stack<Double> stack = new Stack<>();

    for (String letter : list) {
      if (!stack.isEmpty() && OperatorPriority.isOperator(letter)) {
        double number1 = stack.pop();
        double number2 = stack.pop();
        stack.push(calculation(number1, number2, letter));
        continue;
      }
      stack.push(Double.parseDouble(letter));
    }
    return stack.pop();
  }

  public List<String> seperate(String[] formula) {

    List<String> list = new ArrayList<>();
    Stack<String> stack = new Stack<>();

    for (String letter : formula) {
      if (OperatorPriority.isOperator(letter)) {
        while (!stack.isEmpty() && OperatorPriority.getPriority(stack.peek()) >= OperatorPriority.getPriority(letter)) {
          list.add(stack.pop());
        }
        stack.push(letter);
      } else {
        list.add(letter);
      }
    }
    while (!stack.isEmpty()) {
      list.add(stack.pop());
    }
    return list;
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