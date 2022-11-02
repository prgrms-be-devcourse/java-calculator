package com.programmers.console;

import java.util.List;
import java.util.Scanner;

public class Console {

  private final Scanner scanner = new Scanner(System.in);

  public String getExpression(String prompt) {
    System.out.print(prompt + "\n");
    return scanner.nextLine().trim();
  }

  public Menu getCommand(String prompt) {
    System.out.println(prompt);
    String choice = scanner.nextLine();
    return Menu.exist(choice);
  }

  public void print(String answer) {
    System.out.println(answer);
  }

  public void print(List<String> memory) {
    memory.forEach(System.out::println);
  }
}
