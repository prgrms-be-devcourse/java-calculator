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
                Output.printHistories(calculatorService.getHistories());
            }
            if (menu.isCalculate()) {
                processExpression();
            }

        } while (!menu.isFinish());
    }

    private void processExpression() {
        String expression = Input.inputExpression();

        try {
            int result = calculatorService.calculate(expression);
            Output.printResult(result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요");
            this.processExpression();
        } catch (IllegalArgumentException e) {
            System.out.println("식이 잘못 되었습니다. 다시 입력하세요");
            this.processExpression();
        }
    }

}
