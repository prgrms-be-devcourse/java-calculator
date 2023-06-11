package org.example.io;

public class Output {

  public static void showMenu() {
    System.out.println("1. 조회");
    System.out.println("2. 계산");
    System.out.println("3. 종료");
  }

  public static void printResult(double result) {
    System.out.println("결과 : " + result);
  }
}
