package com.programmers.model;

import com.programmers.io.Input;
import com.programmers.io.Output;
import java.util.Scanner;

public class Menu implements Input, Output {

  private final Scanner scanner = new Scanner(System.in);

  @Override
  public int selectOption() {
    System.out.print("선택 : ");
    int select = Integer.parseInt(scanner.nextLine());
    System.out.println();
    return select;
  }

  @Override
  public String getCalculationFormula() {
    String infix = scanner.nextLine();
    infix = infix.replaceAll("\\s+", "");
    return infix;
  }

  @Override
  public void showMenu() {
    System.out.println("1. 조회\n2. 계산 \n3. 종료\n");
  }

  @Override
  public void exit() {
    System.out.println("종료할게");
  }

  @Override
  public void incorrectOption() {
    System.out.println("올바른 답이 아니야");
  }
}
