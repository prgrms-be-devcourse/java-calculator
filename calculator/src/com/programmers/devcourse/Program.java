package com.programmers.devcourse;

import com.programmers.devcourse.calculator.exception.CalculatorException;
import com.programmers.devcourse.parser.Parser;
import com.programmers.devcourse.parser.RegexParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Program {

  public static Parser parser = new RegexParser();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> resultList = new LinkedList<>();

    while (true) {
      System.out.println("1. 조회");
      System.out.println("2. 계산\n");
      System.out.print("선택 : ");
      int mode;
      try {
        mode = Integer.parseInt(br.readLine());
        if (mode > 2) {
          throw new NumberFormatException("Wrong Number");
        }
      } catch (NumberFormatException e) {
        System.out.println("프로그램 종료");
        break;
      }
      System.out.println();

      if (mode == 1) {
        if (resultList.isEmpty()) {
          System.out.println("없음");
        } else {
          resultList.forEach(System.out::println);
        }
        System.out.println();

      } else if (mode == 2) {
        String expression = br.readLine();
        double result;
        try {
          result = calculate(expression);

        } catch (CalculatorException e) {
          System.out.println(e.getMessage());
          continue;
        }
        resultList.add(
            expression + " = " + result);
        System.out.println(result);
        System.out.println();

      }
    }
    br.close();
  }

  public static Double calculate(String expression) throws CalculatorException {
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

  private static void traverseAndCalculate(LinkedList<Double> numList,
      LinkedList<Character> operatorList, int operatorPointer, char operator) {
    double first = numList.get(operatorPointer);
    double second = numList.get(operatorPointer + 1);
    double result = calculateTwoNumbers(operator, first, second);
    numList.set(operatorPointer, result);
    numList.remove(operatorPointer + 1);
    operatorList.remove(operatorPointer);
  }

  private static double calculateTwoNumbers(char operator, double first, double second) {
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
