package programmers.calculator.io;

import java.util.Scanner;

public class Console implements Input, Output {

  private final Scanner scanner = new Scanner(System.in);

  @Override
  public String read() {
    return scanner.nextLine();
  }

  @Override
  public void printLine(String message) {
    System.out.println(message);
  }

  @Override
  public void printMenu() {
    System.out.print("""
        메뉴를 선택하세요.
        1. 조회
        2. 계산

        선택 :\s""");
  }
}