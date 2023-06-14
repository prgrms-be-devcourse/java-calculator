package com.programmers;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.model.CalculationFormula;
import com.programmers.engine.model.Menu;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {

  private final Input input;
  private final Output output;
  private final CalculationFormula calculationFormula;
  private final Menu menu;

  @Override
  public void run() {
    while (true) {
      output.showMenu();

      switch (input.selectOption()) {
        case 1:
          calculationFormula.showResult();
          continue;
        case 2:
          String formula = menu.getInfix();
          calculationFormula.calculate(formula);
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
