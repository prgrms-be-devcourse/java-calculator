package com.programmers.verification;

public class Verification {

  public boolean verify(String input) {

    String[] split = input.split(" ");
    String operation = "+-*/";
    String num = "^[0-9]*$";
    boolean flag = true;

    for (int i = 0; i < split.length; i++) {
      if (!((i % 2 == 0 && split[i].matches(num)) ||
          (i % 2 == 1 && operation.contains(split[i]))) ||
          operation.contains(split[split.length - 1])) {
        flag = false;
        break;
      }
    }
    return flag;
  }

}
