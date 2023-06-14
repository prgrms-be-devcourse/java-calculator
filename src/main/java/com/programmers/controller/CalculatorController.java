package com.programmers.controller;

import com.programmers.domain.Menu;
import com.programmers.error.CalculatorException;
import com.programmers.service.CalculatorService;
import com.programmers.view.Input;
import com.programmers.view.Output;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        Menu menu;
        do {
            Output.printMenu();

            int menuNum = Input.inputMenu();

            menu = Menu.getMenu(menuNum);

            if (menu.isHistory()) {
                Output.printHistories(calculatorService.getHistories());
            }
            if (menu.isCalculate()) {
                processCalculation();
            }

        } while (!menu.isFinish());
    }

    private void processCalculation() {
        boolean calculationSuccessful = false;

        while (!calculationSuccessful) {
            String expression = Input.inputExpression();
            try {
                int result = calculatorService.calculate(expression);
                Output.printResult(result);
                calculationSuccessful = true;
            } catch (CalculatorException e) {
                System.out.println("다시 입력하세요.");
            }
        }
    }

}
