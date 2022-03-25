package com.prgrms.dev;

import com.prgrms.dev.calculator.io.Input;
import com.prgrms.dev.calculator.io.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
  private final Scanner scanner = new Scanner(System.in);
  private final List<String> inMemory = new ArrayList<>();

  @Override
  public String menu(String message) {
    System.out.print("1.조회\n2.계산\n\n" + message);
    return scanner.nextLine();
  }

  @Override
  public String input() {
    System.out.println();
    return scanner.nextLine();
  }

  @Override
  public void reply(String formula, int answer) {
    inMemory.add(formula + " = " + answer);
    System.out.println(answer);
    System.out.println();
  }

  @Override
  public void printInMemory() {
    System.out.println();
    inMemory.forEach(System.out::println);
    System.out.println();
  }

  @Override
  public void menuError() {
    System.out.println("메뉴는 1, 2만 입력해주세요.");
  }

  @Override
  public void inputError() {
    System.out.println("입력이 잘못되었습니다.");
  }

  @Override
  public void inputError(String message) {
    System.out.println(message);
  }
}
