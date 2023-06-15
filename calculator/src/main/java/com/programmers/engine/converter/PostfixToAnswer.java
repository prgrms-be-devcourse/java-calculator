package com.programmers.engine.converter;

import com.programmers.engine.model.Operator;
import java.util.Stack;

public class PostfixToAnswer {

  public static double PostfixToAnswer(String postfix) {
    Stack<Double> operandStack = new Stack<>();

    for (int i = 0; i < postfix.length(); i++) {
      char ch = postfix.charAt(i);

      if (ch == ' ') {
        continue;
      }

      if (isDigit(ch)) {
        operandStack.push((double) (ch - '0'));
      } else {
        Operator operator = Operator.fromSymbol(ch);
        double rightOperand = operandStack.pop();
        double leftOperand = operandStack.pop();
        double result = operator.calculate(leftOperand, rightOperand);

        operandStack.push(result);
      }
    }
    return operandStack.pop();
  }

  private static boolean isDigit(char ch) {
    return Character.isDigit(ch);
  }
}

