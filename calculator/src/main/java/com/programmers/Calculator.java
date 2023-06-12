package com.programmers;

import com.programmers.io.Input;
import com.programmers.io.Output;
import com.programmers.model.CalculationFormula;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {

  private final Input input;
  private final Output output;
  private final CalculationFormula calculationFormula;

  @Override
  public void run() {
    while (true) {
      // 메뉴 보여주기
      output.showMenu();

      switch (input.selectOption()) {
        case 1:
          calculationFormula.showResult();
          continue;
        case 2:
          calculationFormula.calculate();
          continue;
        case 3:
          output.exit();
          return;
        default:
          output.incorrectOption();
      }
    }
  }
}
