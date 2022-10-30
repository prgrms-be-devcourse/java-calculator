package org.programmers.java.calculator.io;

import java.util.Scanner;

public class Console {

  private final Scanner sc = new Scanner(System.in);

  public String read() {
    return sc.nextLine();
  }

  public void print(String message) {
    System.out.println(message + "\n");
  }

  public void printMeun() {
    System.out.print(
            """
            메뉴를 선택하시오.
            1. 조회
            2. 계산
            3. 종료
            """);
    System.out.print("선택 : ");
  }

  public void printError() {
    System.out.println("""
            잘못된 입력 입니다.
            """);
  }
}