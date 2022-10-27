package com.programmers.io;

import java.util.Scanner;

public class Console implements Input, Output {

  private final Scanner scanner = new Scanner(System.in);

  public String getForm(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine().trim();
  }

  public String getChoice(String prompt) {
    System.out.println(prompt);
    return scanner.nextLine();
  }

  public void printAnswer(Double answer) {
    System.out.println(answer);
  }
}
