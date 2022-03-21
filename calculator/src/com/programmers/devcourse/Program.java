package com.programmers.devcourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Program {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> resultList = new LinkedList<>();

    while (true) {
      System.out.println("1. 조회");
      System.out.println("2. 계산\n");
      System.out.print("선택 : ");
      int mode = Integer.parseInt(br.readLine());
      System.out.println();

      if (mode > 2) {
        System.out.println("프로그램 종료");
        break;
      }
      if (mode == 1) {
        if (resultList.isEmpty()) {
          System.out.println("없음");
        } else {
          resultList.forEach(System.out::println);
        }
        System.out.println();

      } else if (mode == 2) {
        String expression = br.readLine();
        int result = calculate(expression);
        resultList.add(
            expression + " = " + result);
        System.out.println(result);
        System.out.println();

      }
    }
    br.close();
  }

  public static int calculate(String expression) {
    StringTokenizer st = new StringTokenizer(expression);
    LinkedList<Integer> numList = new LinkedList<>();
    LinkedList<Character> operatorList = new LinkedList<>();
    int i = 0;

    while (st.hasMoreTokens()) {
      String token = st.nextToken();
      if (i % 2 == 0) {
        numList.add(Integer.parseInt(token));
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

  private static void traverseAndCalculate(LinkedList<Integer> numList,
      LinkedList<Character> operatorList, int operatorPointer, char operator) {
    int first = numList.get(operatorPointer);
    int second = numList.get(operatorPointer + 1);
    int result = calculateTwoNumbers(operator, first, second);
    numList.set(operatorPointer, result);
    numList.remove(operatorPointer + 1);
    operatorList.remove(operatorPointer);
  }

  private static int calculateTwoNumbers(char operator, int first, int second) {
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
