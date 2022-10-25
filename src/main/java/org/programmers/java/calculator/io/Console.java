package org.programmers.java.calculator.io;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.controller.CalculatorController;

import java.util.Scanner;

public class Console implements Input, Output {

  private final Scanner sc = new Scanner(System.in);

  @Override
  public String read() {
    return sc.nextLine();
  }

  @Override
  public void print(String message) {

  }

  @Override
  public void printMeun() {
    System.out.println("""
            메뉴를 선택하시오.
            1. 조회
            2. 계산
            3. 종료
            
            """);
  }

  @Override
  public void printError() {
    System.out.println("""
            잘못된 입력 입니다.
            """);
  }
}