package com.programmers.engine.model;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import java.util.Scanner;

public class Menu implements Input, Output {

  private static final Scanner scanner = new Scanner(System.in);

  @Override
  public int selectOption() {
    System.out.print("선택 : ");
    int select = Integer.parseInt(scanner.nextLine());
    System.out.println();
    return select;
  }

  @Override
  public String getInfix() {
    return scanner.nextLine();
  }

  @Override
  public String getReplacedInfix(String infix) {
    return infix.replaceAll("\\s+", "");
  }

  @Override
  public void showMenu() {
    System.out.println("1. 조회\n2. 계산 \n3. 종료\n");
  }

  @Override
  public void exit() {
    System.out.println("계산기를 종료합니다.");
  }

  @Override
  public void incorrectOption() {
    System.out.println("올바른 메뉴 옵션을 선택해주세요.");
  }
}
