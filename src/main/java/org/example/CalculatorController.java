package org.example;

import org.example.history.Formula;
import org.example.history.History;
import org.example.io.Input;
import org.example.io.Output;
import org.example.calculator.Calculator;

import java.io.IOException;

public class CalculatorController {
  static Input input;
  static Output output;
  static Calculator calculator;
  static History history;

  public static void run() throws IOException {
    while (true) {
      output.showMenu();

      switch (input.inputMenu()) {
        case 1:
          history.findAll();
          break;
        case 2:
          String formula = input.inputFormula();
          double result = calculator.calculate(formula);
          history.save(new Formula(formula, result));
          output.printResult(result);
          break;
        case 3:
          return ;
      }
    }
  }
}