package com.programmers.devcourse.processor;

import com.programmers.devcourse.exception.processor.ProcessorException;
import com.programmers.devcourse.exception.processor.WrongOperatorTokenException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StringTokenProcessor implements Processor<List<String>, Double> {

  private LinkedList<Double> numberList;
  private LinkedList<Character> operatorList;

  @Override
  public Double process(List<String> tokens) throws ProcessorException {
    numberList = new LinkedList<>();
    operatorList = new LinkedList<>();
    identifyTokens(tokens);

    processMultiplicationAndDivision();
    processAdditionAndSubtraction();
    return numberList.getFirst();
  }

  private void processAdditionAndSubtraction() throws WrongOperatorTokenException {
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

  private void processMultiplicationAndDivision() throws WrongOperatorTokenException {
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
    AtomicInteger i = new AtomicInteger();
    tokens.forEach(token -> {
      if (i.getAndIncrement() % 2 == 0) {
        numberList.add(Double.parseDouble(token));
        return;
      }
      operatorList.add(token.charAt(0));
    });
  }

  private void operateNumbersInList(int operatorPointer, char operator)
      throws WrongOperatorTokenException {
    double first = numberList.get(operatorPointer);
    double second = numberList.get(operatorPointer + 1);
    double result = calculateTwoNumbers(operator, first, second);

    numberList.set(operatorPointer, result);
    numberList.remove(operatorPointer + 1);
    operatorList.remove(operatorPointer);
  }

  private double calculateTwoNumbers(char operator, double first, double second)
      throws WrongOperatorTokenException {
    Operator realOperator = Operator.from(operator);
    return realOperator.operate(first, second);
  }
}
