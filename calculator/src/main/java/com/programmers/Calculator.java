package com.programmers;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.model.CalculationFormula;
import com.programmers.engine.model.Menu;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {

  public static final int HISTORY = 1;
  public static final int CALCULATE = 2;
  public static final int EXIT = 3;
  private final Input input;
  private final Output output;
  private final CalculationFormula calculationFormula;
  private final Menu menu;

  @Override
  public void run() {
    while (true) {
      output.showMenu();

      switch (input.selectOption()) {
        case HISTORY:
          calculationFormula.showResult();
          continue;
        case CALCULATE:
          String formula = menu.getInfix();
          calculationFormula.calculate(formula);
          continue;
        case EXIT:
          output.exit();
          return;
        default:
          output.incorrectOption();
      }
    }
  }
}
