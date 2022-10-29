package com.programmers.console;

public enum Menu {
  calc("1"),
  inquiry("2"),
  outSide("3");

  private String str;

  Menu(String str) {
    this.str = str;
  }
}
