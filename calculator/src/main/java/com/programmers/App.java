package com.programmers;

import com.programmers.engine.model.CalculationFormula;
import com.programmers.engine.model.Menu;

public class App {

  public static void main(String[] args) {
    Menu menu = new Menu();
    CalculationFormula calculationFormula = new CalculationFormula();
    Calculator calculator = new Calculator(menu, menu, calculationFormula, menu);

    calculator.run();
  }
}