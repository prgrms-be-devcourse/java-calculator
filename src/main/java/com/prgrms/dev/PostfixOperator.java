package com.prgrms.dev;

import com.prgrms.dev.calculator.io.Operator;

import java.util.Stack;

public class PostfixOperator implements Operator {
  @Override
  public int calculate(String formula) {
    String postFix = convertPostFix(formula);
    return calculatorPostFix(postFix);
  }

  private int calculatorPostFix(String postFix) {
    int a, b, result;
    Stack<Integer> stack = new Stack<>();

    for (char ch : postFix.toCharArray()) {
      if (isOperator(ch)) {
        b = stack.pop();
        a = stack.pop();

        result = calculate(a, b, ch);

        stack.push(result);
      } else {
        stack.push(Character.getNumericValue(ch));
      }
    }
    return stack.pop();
  }

  private boolean isOperator(char c) {
    return (c == '+' || c=='-' || c=='*' || c == '/' || c == '%');
  }

  private int calculate(int a, int b, char operator) {
    switch (operator) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        return a / b;
    }
    return 0;
  }

  private String convertPostFix(String formula) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    char[] arr = formula.replace(" ", "").toCharArray();
    for (char ch : arr) {
      switch (ch) {
        case '+':
        case '-':
        case '*':
        case '/':
          while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
            sb.append(stack.pop());
          }
          stack.add(ch);
          break;
        default:
          sb.append(ch);
      }
    }

    while (!stack.isEmpty())
      sb.append(stack.pop());

    return sb.toString();
  }

  private int priority(char operator) {
    if (operator == '+' || operator == '-')
      return 1;
    return 2;
  }
}
