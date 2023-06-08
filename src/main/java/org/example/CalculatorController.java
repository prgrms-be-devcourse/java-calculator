package org.example;

import org.example.history.Formula;
import org.example.history.History;
import org.example.io.Input;
import org.example.io.Output;
import org.example.calculator.Calculator;

import java.io.IOException;

public class CalculatorController {
  static Calculator calculator;
  static History history;

  public static void run() throws IOException {
    while (true) {
      Output.showMenu();

      switch (Input.inputMenu()) {
        case 1:
          history.view();
          break;
        case 2:
          String formula = Input.inputFormula();
          double result = calculator.calculate(formula);
          history.save(new Formula(formula, result));
          Output.printResult(result);
          break;
        case 3:
          return;
      }
    }
  }
}