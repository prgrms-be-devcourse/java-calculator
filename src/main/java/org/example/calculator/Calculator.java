package org.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
  public double calculate(String inputFormula) {
    String[] formula = inputFormula.split(" ");
    List<String> separatedFormula = separate(formula);
    Stack<Double> numbers = new Stack<>();

    for (String letter : separatedFormula) {
      if (!numbers.isEmpty() && OperatorPriority.isOperator(letter)) {
        double number1 = numbers.pop();
        double number2 = numbers.pop();
        numbers.push(calculation(number1, number2, letter));
        continue;
      }
      numbers.push(Double.parseDouble(letter));
    }
    return numbers.pop();
  }

  public List<String> separate(String[] formula) {
    List<String> parsedFormula = new ArrayList<>();
    Stack<String> operators = new Stack<>();

    for (String value : formula) {
      if (OperatorPriority.isOperator(value)) {
        while (!operators.isEmpty() && OperatorPriority.checkPriority(operators.peek()) >= OperatorPriority.checkPriority(value)) {
          parsedFormula.add(operators.pop());
        }
        operators.push(value);
      } else {
        parsedFormula.add(value);
      }
    }

    while (!operators.isEmpty()) {
      parsedFormula.add(operators.pop());
    }
    return parsedFormula;
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
