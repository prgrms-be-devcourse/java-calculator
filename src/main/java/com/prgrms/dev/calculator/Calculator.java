package com.prgrms.dev.calculator;

import com.prgrms.dev.calculator.io.Input;
import com.prgrms.dev.calculator.io.Operator;
import com.prgrms.dev.calculator.io.Output;

import java.util.regex.Matcher;
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
      String menu = input.menu("선택 : ");
      if (menu.equals("1")) {     // 조회
        output.printInMemory();
      } else if (menu.equals("2")) {                    // 계산
        String inputStr = this.input.input();

        // 식 검증
        Matcher matcher = pattern.matcher(inputStr);
        if (!matcher.matches()) {
          output.inputError();
          continue;
        }

        int result = operator.calculate(inputStr);
        output.reply(inputStr, result);
      } else {
        output.menuError();
      }
    }
  }
}
