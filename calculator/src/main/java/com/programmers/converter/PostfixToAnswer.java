package com.programmers.converter;

import com.programmers.model.Operator;
import java.util.Stack;

public class PostfixToAnswer {

  public static double PostfixToAnswer(String postfixExpression) {
    Stack<Double> operandStack = new Stack<>();

    for (int i = 0; i < postfixExpression.length(); i++) {
      char ch = postfixExpression.charAt(i);

      if (ch == ' ') {
        continue;
      }

      if (Character.isDigit(ch)) {
        operandStack.push((double) (ch - '0'));
      } else {
        Operator operator = Operator.fromSymbol(ch);
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        double result = operator.performOperation(operand1, operand2);
        operandStack.push(result);
      }
    }

    return operandStack.pop();
  }
}

