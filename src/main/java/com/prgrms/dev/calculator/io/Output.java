package com.prgrms.dev.calculator.io;

public interface Output {
  void printInMemory();

  void inputError();

  void reply(String formula, int answer);

  void menuError();
}
