package com.prgrms.dev.calculator.io;

public interface Output {
  void reply(String formula, int answer);
  void printInMemory();
  void menuError();
  void inputError();
}
