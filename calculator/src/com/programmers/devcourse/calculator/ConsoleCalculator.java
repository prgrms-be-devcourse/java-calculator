package com.programmers.devcourse.calculator;

import com.programmers.devcourse.calculator.exception.CalculatorException;
import com.programmers.devcourse.parser.Parser;
import com.programmers.devcourse.repository.ResultRepository;
import com.programmers.devcourse.repository.StringResultRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ConsoleCalculator implements Calculator {

  private Parser parser;
  private BufferedReader br;
  private ResultRepository<String> repository;


  public ConsoleCalculator(Parser parser) {
    this.parser = parser;
    this.repository = new StringResultRepository();
    this.br = new BufferedReader(new InputStreamReader(System.in));
  }

  @Override
  public void start() {
    int mode;
    try {
      while (true) {

        mode = printMenuAndGetMode();
        if (mode == 1) {
          printAllResults();
        } else if (mode == 2) {
          String expression = br.readLine();
          double result;
          try {
            result = calculate(expression);

          } catch (CalculatorException e) {
            System.out.println(e.getMessage());
            continue;
          }
          repository.save(
              expression + " = " + result);
          System.out.println(result);
          System.out.println();

        } else {
          break;
        }

      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();


    } finally {
      System.out.println("\n계산기 종료");
    }


  }

  private int printMenuAndGetMode() throws IOException {
    System.out.println("1. 조회");
    System.out.println("2. 계산\n");
    System.out.print("선택 : ");
    int mode = Integer.parseInt(br.readLine());
    System.out.println();
    return mode;
  }

  private void printAllResults() {
    if (repository.getSize() == 0) {
      System.out.println("없음");
      return;
    }
    for (String result : repository.getAllResults()
    ) {
      System.out.println(result);
    }
    System.out.println();
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

  private void traverseAndCalculate(LinkedList<Double> numList,
      LinkedList<Character> operatorList, int operatorPointer, char operator) {
    double first = numList.get(operatorPointer);
    double second = numList.get(operatorPointer + 1);
    double result = calculateTwoNumbers(operator, first, second);
    numList.set(operatorPointer, result);
    numList.remove(operatorPointer + 1);
    operatorList.remove(operatorPointer);
  }

  public Double calculate(String expression) throws CalculatorException {
    List<String> tokens;
    tokens = parser.parse(expression);

    Iterator<String> tokenIterator = tokens.iterator();
    LinkedList<Double> numList = new LinkedList<>();
    LinkedList<Character> operatorList = new LinkedList<>();
    int i = 0;

    while (tokenIterator.hasNext()) {
      String token = tokenIterator.next();
      if (i % 2 == 0) {
        numList.add(Double.parseDouble(token));
        i++;
        continue;
      }
      operatorList.add(token.charAt(0));
      i++;
    }

    int operatorPointer = 0;
    // 연산자 리스트를 순회하면서 곱셈과 나눗셈을 먼저 수행한다.
    while (operatorPointer < operatorList.size()) {

      char operator = operatorList.get(operatorPointer);
      if (operator == '*' || operator == '/') {
        traverseAndCalculate(numList, operatorList, operatorPointer, operator);
      } else {
        operatorPointer++;

      }
    }
    StringBuffer sb = new StringBuffer();
    // 덧셈 뺄셈 연산을 해서 숫자 리스트의 크기를 1로 줄이고 그 값을 반환한다.
    operatorPointer = 0;
    while (operatorPointer < operatorList.size()) {

      char operator = operatorList.get(operatorPointer);
      if (operator == '+' || operator == '-') {
        traverseAndCalculate(numList, operatorList, operatorPointer, operator);
      }
    }

    return numList.getFirst();
  }


}
