package com.programmers.console;

import static com.programmers.console.Menu.calc;
import static com.programmers.console.Menu.inquiry;
import static com.programmers.console.Menu.outSide;

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

    return switch (choice) {
      case "1" -> calc;
      case "2" -> inquiry;
      case "3" -> outSide;
      default -> throw new IllegalArgumentException("1에서 3사이의 값만 입력 가능합니다.");
    };
  }

  public void print(String answer) {
    System.out.println(answer);
  }

  public void print(List<String> memory) {
    memory.forEach(System.out::println);
  }
}
