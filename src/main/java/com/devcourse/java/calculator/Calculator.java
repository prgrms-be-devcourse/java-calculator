package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.Menu;
import com.devcourse.java.calculator.io.Input;
import com.devcourse.java.calculator.io.Output;
import com.devcourse.java.calculator.repository.CalculatorRepository;
import com.devcourse.java.calculator.util.CalculateUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Calculator implements Runnable{

    private final Input input;
    private final Output output;
    private final CalculatorRepository calculatorRepository;
    private Menu command;

    @Override
    public void run() {

        while (true) {
            output.printCommandMenu();

            try {
                command = Menu.getCommandMenu(input.getCommand());
            } catch (RuntimeException e) {
                output.printExceptionMessage(e.getMessage());
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
            output.printCalculateHistory(calculatorRepository.getHistory());

        } catch (RuntimeException e) {
            output.printExceptionMessage(e.getMessage());
        }
    }

    public void calculateCommand() {
        try {
            output.printRequestEquationInput();
            String equation = input.getEquation();
            String equationWithAnswer = CalculateUtil.calculateAndReturnEquationWithAnswer(equation);
            output.printAnswerFromEquation(equationWithAnswer);
            calculatorRepository.storeHistory(equationWithAnswer);

        } catch (RuntimeException e) {
            output.printExceptionMessage(e.getMessage());
        }
    }
}
