package com.programmers.console;

import java.util.stream.Stream;

public enum Menu{
  CALC("1"),
  INQUIRY("2"),
  OUTSIDE("3"),
  NORESULT("-1");

  private final String str;

  Menu(String str) {
    this.str = str;
  }

  public static Menu exist(String choice) {
    return Stream.of(values())
        .filter(num -> num.str.equals(choice))
        .findFirst()
        .orElse(NORESULT);
  }

}
