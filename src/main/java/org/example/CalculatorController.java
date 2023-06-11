package org.example;

import org.example.history.Formula;
import org.example.history.History;
import org.example.io.Input;
import org.example.io.Output;
import org.example.calculator.Calculator;

import java.io.IOException;

public class CalculatorController {
  Calculator calculator = new Calculator();
  History history = new History();

  final int HISTORY = 1;
  final int CALCULATE = 2;
  final int EXIT = 3;

  public void run() throws IOException {
    while (true) {
      Output.showMenu();

      switch (Input.inputMenu()) {
        case HISTORY:
          history.view();
          break;
        case CALCULATE:
          String formula = Input.inputFormula();
          double result = calculator.calculate(formula);
          history.save(new Formula(formula, result));
          Output.printResult(result);
          break;
        case EXIT:
          return;
        default:
          System.out.println("보기에 나와있는 메뉴를 선택하세요.");
      }
    }
  }
}