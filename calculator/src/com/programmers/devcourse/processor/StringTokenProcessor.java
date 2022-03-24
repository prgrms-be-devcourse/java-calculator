package com.programmers.devcourse.processor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StringTokenProcessor implements Processor<List<String>, Double> {

  private LinkedList<Double> numberList;
  private LinkedList<Character> operatorList;

  @Override
  public Double process(List<String> tokens) {
    numberList = new LinkedList<>();
    operatorList = new LinkedList<>();
    identifyTokens(tokens);

    processMultiplicationAndDivision();
    processAdditionAndSubtraction();
    return numberList.getFirst();
  }

  private void processAdditionAndSubtraction() {
    int operatorPointer;
    // 덧셈 뺄셈 연산을 해서 숫자 리스트의 크기를 1로 줄이고 그 값을 반환한다.
    operatorPointer = 0;
    while (operatorPointer < operatorList.size()) {

      char operator = operatorList.get(operatorPointer);
      if (operator == '+' || operator == '-') {
        operateNumbersInList(operatorPointer, operator);
      }
    }
  }

  private void processMultiplicationAndDivision() {
    int operatorPointer = 0;
    // 연산자 리스트를 순회하면서 곱셈과 나눗셈을 먼저 수행한다.
    while (operatorPointer < operatorList.size()) {

      char operator = operatorList.get(operatorPointer);
      if (operator == '*' || operator == '/') {
        operateNumbersInList(operatorPointer, operator);
      } else {
        operatorPointer++;

      }
    }
  }

  private void identifyTokens(List<String> tokens) {
    Iterator<String> tokenIterator = tokens.iterator();
    int i = 0;

    while (tokenIterator.hasNext()) {
      String token = tokenIterator.next();
      if (i % 2 == 0) {
        numberList.add(Double.parseDouble(token));
        i++;
        continue;
      }
      operatorList.add(token.charAt(0));
      i++;
    }
  }

  private void operateNumbersInList(int operatorPointer, char operator) {
    double first = numberList.get(operatorPointer);
    double second = numberList.get(operatorPointer + 1);
    double result = calculateTwoNumbers(operator, first, second);

    numberList.set(operatorPointer, result);
    numberList.remove(operatorPointer + 1);
    operatorList.remove(operatorPointer);
  }

  private double calculateTwoNumbers(char operator, double first, double second) {
    switch (operator) {
      case '+':
        return first + second;
      case '-':
        return first - second;
      case '*':
        return first * second;
      case '/':
        return first / second;
      default:
        throw new ArithmeticException("연산자 입력 오류");
    }
  }
}
