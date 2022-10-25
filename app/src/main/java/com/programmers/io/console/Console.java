package com.programmers.io.console;

import com.programmers.io.Input;
import com.programmers.io.Output;
import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

  private final Scanner sc = new Scanner(System.in);

  @Override
  public String prompt(String prompt) {
    System.out.println(prompt);
    sc.nextLine();
    return sc.nextLine().trim();
  }

  @Override
  public int getChoice(String prompt) {
    System.out.println(prompt);
    return sc.nextInt();
  }

  @Override
  public void printAnswer(String answer) {
    System.out.println(answer);
  }

  @Override
  public void printMemory(List<String> dataBase) {
    dataBase.forEach(System.out::println);
  }


}
