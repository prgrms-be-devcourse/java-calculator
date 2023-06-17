package org.example;

import org.example.history.Formula;
import org.example.history.History;
import org.example.io.Input;
import org.example.io.Output;
import org.example.calculator.Calculator;

public class CalculatorController {
  private Calculator calculator = new Calculator();
  private History history = new History();

  private static final int HISTORY = 1;
  private static final int CALCULATE = 2;
  private static final int EXIT = 3;

  public void run() {
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
