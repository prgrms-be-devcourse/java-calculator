package com.prgrms.dev.calculator;

import com.prgrms.dev.calculator.io.Input;
import com.prgrms.dev.calculator.io.Operator;
import com.prgrms.dev.calculator.io.Output;

public class Calculator implements Runnable {
  private final Operator operator;
  private final Input input;
  private final Output output;

  public Calculator(Operator operator, Input input, Output output) {
    this.operator = operator;
    this.input = input;
    this.output = output;
  }

  @Override
  public void run() {
    while(true) {
      String menu = input.menu("선택 : ").trim();
      if (menu.equals("1")) {
        output.printInMemory();
      } else if (menu.equals("2")) {
        String formula = this.input.input();

        int answer = operator.calculate(formula);
        output.reply(formula, answer);
      } else {
        output.menuError();
      }
    }
  }
}
