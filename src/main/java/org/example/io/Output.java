package org.example.io;

public class Output {
  public void showMenu() {
    System.out.println("1. 조회");
    System.out.println("2. 계산");
  }

  public void printResult(double result) {
    System.out.println("결과 : " + result);
  }
}