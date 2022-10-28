package com.programmers.io;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

  private final Scanner scanner = new Scanner(System.in);

  public String getForm(String prompt) {
    System.out.print(prompt + "\n");
    return scanner.nextLine().trim();
  }

  public String getChoice(String prompt) {
    System.out.println(prompt);
    return scanner.nextLine();
  }

  public void printAnswer(String answer) {
    System.out.println(answer);
  }

  public void printMemory(List<String> memory) {
    memory.forEach(System.out::println);
  }
}
