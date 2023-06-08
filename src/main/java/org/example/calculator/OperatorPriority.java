package org.example.calculator;

public class OperatorPriority {

  public static boolean isOperator(String letter) {
    if (("+").equals(letter) || ("-").equals(letter) || ("*").equals(letter) || ("/").equals(letter)) {
      return true;
    }
    return false;
  }
}