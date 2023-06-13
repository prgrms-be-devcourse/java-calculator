package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.io.Input;
import com.devcourse.java.calculator.io.Output;
import com.devcourse.java.calculator.repository.CalculatorRepository;
import com.devcourse.java.calculator.util.CalculateUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable{

    private final Input input;
    private final Output output;
    private final CalculatorRepository calculatorRepository;
    private final CalculateUtil calculateUtil;
    private int command;

    @Override
    public void run() {

        while (true) {
            output.printCommandMenu();

            try {
                command = input.getCommand();
            } catch (RuntimeException e) {
                output.printExceptionMessage(e.getMessage());
                continue;
            }

            if (command == MenuConstant.SELECTED_EXIT_COMMAND) {
                return;
            }

            runCommand(command);
        }
    }

    public void runCommand(int command) {
        if (command == MenuConstant.SELECTED_PRINT_HISTORY_COMMAND) {
            printHistoryCommand();
        }

        else if (command == MenuConstant.SELECTED_CALCULATE_COMMAND) {
            calculateCommand();
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
            String equationWithAnswer = calculateUtil.calculateAndReturnEquationWithAnswer(equation);
            output.printAnswerFromEquation(equationWithAnswer);
            calculatorRepository.storeHistory(equationWithAnswer);

        } catch (RuntimeException e) {
            output.printExceptionMessage(e.getMessage());
        }
    }
}
