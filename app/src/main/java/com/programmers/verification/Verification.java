package com.programmers.verification;

public class Verification {

  private final String OPERATION = "+-*/";
  private final String NUM = "^[0-9]*$";

  public boolean verify(String input) {

    String[] split = input.split(" ");

    for (int i = 0; i < split.length; i++) {
      if (!((i % 2 == 0 && split[i].matches(NUM)) ||
          (i % 2 == 1 && OPERATION.contains(split[i]))) ||
          OPERATION.contains(split[split.length - 1])) {
        return false;
      }
    }
    return true;
  }

}
