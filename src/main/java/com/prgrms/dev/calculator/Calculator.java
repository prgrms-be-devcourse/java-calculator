package com.prgrms.dev.calculator;

import com.prgrms.dev.calculator.io.Input;
import com.prgrms.dev.calculator.io.Operator;
import com.prgrms.dev.calculator.io.Output;

import java.util.regex.Pattern;

public class Calculator implements Runnable {
  private final Operator operator;
  private final Input input;
  private final Output output;

  private final Pattern pattern = Pattern.compile("^([0-9] [+-/*] )+[0-9]$");

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

        if (!validateFormula(formula)) {
          output.inputError();
          continue;
        }

        if (formula.indexOf("/ 0") > 0) {
          output.inputError("0으로 나눌 수 없습니다.");
          continue;
        }

        int answer = operator.calculate(formula);
        output.reply(formula, answer);
      } else {
        output.menuError();
      }
    }
  }

  private boolean validateFormula(String formula) {
    return pattern.matcher(formula).matches();
  }

}
