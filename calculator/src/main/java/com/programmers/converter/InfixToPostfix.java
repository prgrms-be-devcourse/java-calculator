package com.programmers.converter;

import java.util.Stack;

public class InfixToPostfix {

  private static int getPriority(char operator) {
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

  public static String InfixToPostfix(String infix) {
    StringBuilder postfixStringBuilder = new StringBuilder();
    Stack<Character> operatorStack = new Stack<>();

    for (int i = 0; i < infix.length(); i++) {
      char ch = infix.charAt(i);

      if (ch == ' ') {
        continue;
      }

      if (Character.isDigit(ch)) {
        postfixStringBuilder.append(ch);
      } else {
        while (!operatorStack.isEmpty() && getPriority(ch) <= getPriority(
            operatorStack.peek())) {
          postfixStringBuilder.append(operatorStack.pop());
        }
        operatorStack.push(ch);
      }
    }

    while (!operatorStack.isEmpty()) {
      postfixStringBuilder.append(operatorStack.pop());
    }

    return postfixStringBuilder.toString();
  }
}
