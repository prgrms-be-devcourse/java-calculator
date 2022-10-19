package com.prgrms.dev;

import com.prgrms.dev.calculator.Calculator;
import com.prgrms.dev.calculator.io.Operator;

public class Application {
  public static void main(String[] args) {
    Operator operator = new PostfixOperator();
    Console console = new Console();

    new Calculator(operator, console, console).run();
  }
}
