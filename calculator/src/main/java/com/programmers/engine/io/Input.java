package com.programmers.engine.io;

public interface Input {

  int selectOption();

  String getInfix();

  String getReplacedInfix(String infix);
}
