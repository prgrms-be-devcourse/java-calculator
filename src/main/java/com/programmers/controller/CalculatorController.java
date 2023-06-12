package com.programmers.controller;

import com.programmers.domain.Menu;
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
                //todo : map에서 출력
            }
            if (menu.isCalculate()) {
                String expression = Input.inputExpression();
                int result = calculatorService.calculate(expression);
            }

        } while (!menu.isFinish());
    }
}
