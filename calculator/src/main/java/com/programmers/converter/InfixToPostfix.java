package com.programmers.converter;

import java.util.Stack;

public class InfixToPostfix {

  private static int getPrecedence(char operator) {
    switch (operator) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
    }
    return -1;
  }

  public static String convertToPostfix(String infixExpression) {
    StringBuilder postfixExpression = new StringBuilder();
    Stack<Character> operatorStack = new Stack<>();

    for (int i = 0; i < infixExpression.length(); i++) {
      char ch = infixExpression.charAt(i);

      if (ch == ' ') {
        continue;
      }

      if (Character.isDigit(ch)) {
        postfixExpression.append(ch);
      } else {
        while (!operatorStack.isEmpty() && getPrecedence(ch) <= getPrecedence(
            operatorStack.peek())) {
          postfixExpression.append(operatorStack.pop());
        }
        operatorStack.push(ch);
      }
    }

    while (!operatorStack.isEmpty()) {
      postfixExpression.append(operatorStack.pop());
    }

    return postfixExpression.toString();
  }
}
