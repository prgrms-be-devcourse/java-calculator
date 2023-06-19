package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.Menu;
import com.devcourse.java.calculator.io.Console;
import com.devcourse.java.calculator.repository.CalculatorRepository;
import com.devcourse.java.calculator.util.CalculateUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Calculator implements Runnable{

    private final Console console;
    private final CalculatorRepository calculatorRepository;
    private Menu command;

    @Override
    public void run() {

        while (true) {
            console.printCommandMenu();

            try {
                command = Menu.getCommandMenu(console.getCommand());
            } catch (RuntimeException e) {
                console.printExceptionMessage(e.getMessage());
                continue;
            }

            switch (command) {
                case SELECTED_EXIT:
                    return;
                case SELECTED_PRINT_HISTORY:
                    printHistoryCommand();
                    break;
                case SELECTED_CALCULATE:
                    calculateCommand();
                    break;
            }

        }
    }

    public void printHistoryCommand() {
        try {
            console.printCalculateHistory(calculatorRepository.getHistory());

        } catch (RuntimeException e) {
            console.printExceptionMessage(e.getMessage());
        }
    }

    public void calculateCommand() {
        try {
            console.printRequestEquationInput();
            String equation = console.getEquation();
            String equationWithAnswer = CalculateUtil.calculateAndReturnEquationWithAnswer(equation);
            console.printAnswerFromEquation(equationWithAnswer);
            calculatorRepository.storeHistory(equationWithAnswer);

        } catch (RuntimeException e) {
            console.printExceptionMessage(e.getMessage());
        }
    }
}
