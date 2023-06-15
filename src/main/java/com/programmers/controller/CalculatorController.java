package com.programmers.controller;

import com.programmers.domain.Menu;
import com.programmers.error.CalculatorException;
import com.programmers.service.CalculatorService;
import com.programmers.view.Input;
import com.programmers.view.Output;

import static com.programmers.error.ConsoleMessage.INPUT_RETRY_MESSAGE;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        Menu menu;
        do {
            Output.printMenu();

            int menuNum = inputMenu();

            Output.printNewLine();//공백

            menu = Menu.getMenu(menuNum);

            if (menu.isHistory()) {
                Output.printHistories(calculatorService.getHistories());
            }
            if (menu.isCalculate()) {
                processCalculation();
            }

        } while (!menu.isFinish());
    }
    private int inputMenu(){
        boolean inputMenuSuccessful = false;
        int menuNum = 0;
        while(!inputMenuSuccessful){
            try{
                String menuString = Input.inputLine();
                menuNum = Input.processMenu(menuString);
                inputMenuSuccessful = true;
            }
            catch(CalculatorException e){
                Output.printMessage(INPUT_RETRY_MESSAGE);
            }
        }
        return menuNum;
    }


    private void processCalculation() {
        boolean calculationSuccessful = false;

        while (!calculationSuccessful) {
            String beforeProcessExpression = Input.inputLine();
            String expression = Input.processExpression(beforeProcessExpression);
            try {
                int result = calculatorService.calculate(expression);
                Output.printResult(result);
                calculationSuccessful = true;
            } catch (CalculatorException e) {
                Output.printMessage(INPUT_RETRY_MESSAGE);
            }
        }
    }

}
